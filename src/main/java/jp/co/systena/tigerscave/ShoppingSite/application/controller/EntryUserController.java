package jp.co.systena.tigerscave.ShoppingSite.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingSite.application.model.EntryUserForm;
import jp.co.systena.tigerscave.ShoppingSite.application.model.UserService;

@Controller
public class EntryUserController {

  @Autowired
  HttpSession session;

  @Autowired
  UserService userService;

  @RequestMapping(value = "/EntryUser", method = RequestMethod.GET)
  public ModelAndView Entry(ModelAndView mav)
  {
    String errMsg = (String)session.getAttribute("errMsg");

    if(errMsg != null && !errMsg.isEmpty())
    {
      mav.addObject("errMsg", errMsg);
    }

    session.removeAttribute("errMsg");

    EntryUserForm entryUserForm = new EntryUserForm();

    mav.addObject("entryUserForm", entryUserForm);
    return mav;
  }

  @RequestMapping(value = "/EntryUser", method = RequestMethod.POST)
  public ModelAndView InputUserInfo(ModelAndView mav, @Valid EntryUserForm entryUserForm, BindingResult bindingResult, HttpServletRequest request)
  {
    // ユーザ情報
    String userId = entryUserForm.getUserId();
    String userName = entryUserForm.getUserName();
    String password = entryUserForm.getPassword();
    String validationPass = entryUserForm.getValidationPass();

    // エラーメッセージ
    String errMsg = checkEntryUser(userId, userName, password, validationPass);

    if(errMsg != null && !errMsg.isEmpty())
    {
      session.setAttribute("errMsg", errMsg);

      // もう一度ログイン画面に遷移（エラーメッセージ表示）
      return new ModelAndView("redirect:/EntryUser");

    }

    // DBにユーザを登録
    userService.registerUser(userId, userName, password);

    // 登録完了のメッセージ
    String message = "ユーザ登録が完了しました。ログインしてください。";
    session.setAttribute("message", message);

    // ログイン画面に遷移
    return new ModelAndView("redirect:/Login");

  }

  // 新規登録するユーザ情報のエラーチェック(エラーメッセージを返す)
  private String checkEntryUser(String id, String name, String pass, String validationPass)
  {
    // エラーメッセージ
    String errMsg = "";

    // 必須チェック
    if(id == null || id.isEmpty())
    {
      errMsg += "ユーザIDを入力してください。";
    }

    if(name == null || name.isEmpty())
    {
      if(errMsg != null && !errMsg.isEmpty())
      {
        errMsg += "\n";
      }
      errMsg += "ユーザ名を入力してください。";
    }

    if(pass == null || pass.isEmpty())
    {
      if(errMsg != null && !errMsg.isEmpty())
      {
        errMsg += "\n";
      }
      errMsg += "パスワードを入力してください。";
    }

    if(validationPass == null || validationPass.isEmpty())
    {
      if(errMsg != null && !errMsg.isEmpty())
      {
        errMsg += "\n";
      }
      errMsg += "（確認用）パスワードを入力してください。";
    }

    // 未登録のIDかどうか
    if(!userService.checkUserId(id))
    {
      if(errMsg != null && !errMsg.isEmpty())
      {
        errMsg += "\n";
      }
      errMsg += "入力されたIDは既に登録されています。";
    }

    // パスワードと確認用パスワードが一致しているか
    if(!pass.equals(validationPass))
    {
      if(errMsg != null && !errMsg.isEmpty())
      {
        errMsg += "\n";
      }
      errMsg += "パスワードと確認用パスワードが一致していません。もう一度入力してください。";
    }

    return errMsg;
  }

}
