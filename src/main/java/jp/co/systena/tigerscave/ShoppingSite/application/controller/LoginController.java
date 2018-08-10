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
import jp.co.systena.tigerscave.ShoppingSite.application.model.LoginForm;
import jp.co.systena.tigerscave.ShoppingSite.application.model.User;
import jp.co.systena.tigerscave.ShoppingSite.application.model.UserService;

@Controller
public class LoginController {

  @Autowired
  HttpSession session;

  @Autowired
  UserService userService;

  @RequestMapping(value = "/Login", method = RequestMethod.GET)
  public ModelAndView login(ModelAndView mav)
  {
    // 通常のメッセージ（黒字で表示）
    String msg = (String)session.getAttribute("message");
    // エラーメッセージ（赤字で表示）
    String errMsg = (String)session.getAttribute("errMsg");

    if(msg != null && !msg.isEmpty())
    {
      mav.addObject("message", msg);
    }

    if(errMsg != null && !errMsg.isEmpty())
    {
      mav.addObject("errMsg", errMsg);
    }
    
    session.removeAttribute("message");
    session.removeAttribute("errMsg");

    LoginForm loginForm = new LoginForm();

    mav.addObject("loginForm", loginForm);
    return mav;
  }

  @RequestMapping(value = "/Login", method = RequestMethod.POST)
  public ModelAndView signIn(ModelAndView mav, @Valid LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request)
  {
    // ユーザ情報
    String userId = loginForm.getUserId();
    String password = loginForm.getPassword();

    // エラーメッセージ
    String errMsg = "";


    // ユーザID・パスワードから、DBに登録されているユーザ情報を取得
    User user = userService.findUser(userId, password);

    // ユーザ情報の取得に失敗した場合、再度ログイン画面に遷移
    if(user == null)
    {
      errMsg = "ユーザIDまたはパスワードの指定に誤りがあります。もう一度入力してください。";
      session.setAttribute("errMsg", errMsg);

      // もう一度ログイン画面に遷移（エラーメッセージ表示）
      return new ModelAndView("redirect:/Login");
    }

    // ユーザ情報をセッションに格納
    session.setAttribute("user", user);

    // 商品一覧に遷移
    return new ModelAndView("redirect:/ListView");

  }

}
