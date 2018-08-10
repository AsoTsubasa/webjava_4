package jp.co.systena.tigerscave.ShoppingSite.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

  @Autowired
  HttpSession session;

  @RequestMapping(value="/Logout", method=RequestMethod.GET)
  public ModelAndView doGetLogout(ModelAndView mav)
  {
    // ユーザ情報をセッションから削除
    session.removeAttribute("user");

    // ログイン画面に遷移
    return new ModelAndView("redirect:/Login");
  }

  @RequestMapping(value="/Logout", method=RequestMethod.POST)
  public ModelAndView doPostLogout(ModelAndView mav, BindingResult bindingResult, HttpServletRequest request)
  {
    // GETメソッドでログアウト処理を実行
    return new ModelAndView("redirect:Logout");
  }

}
