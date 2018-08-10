package jp.co.systena.tigerscave.ShoppingSite.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingSite.application.model.Cart;
import jp.co.systena.tigerscave.ShoppingSite.application.model.User;

@Controller
public class PurchaseConfirmController
{

  @Autowired
  HttpSession session;

  @RequestMapping(value="/PurchaseConfirm", method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav)
  {
    // ユーザ情報を取得
    User user = (User)session.getAttribute("user");

    // ユーザ情報が取得できない場合は、ログイン画面に遷移
    if(user == null)
    {
      return new ModelAndView("redirect:/Login");
    }
    else
    {
      // ユーザ情報をオブジェクトに格納
      mav.addObject("user", user);
    }

    String message = (String) session.getAttribute("message");
    session.removeAttribute("message");

    // カート情報の取得
    Cart cart = (Cart)session.getAttribute("cart");

    // カートが無い場合は新規作成
    if(cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }

    mav.addObject("cart", cart);

    if(message != null && !message.isEmpty())
    {
      mav.addObject("message", message);
    }

    return mav;

  }

  @RequestMapping(value="/PurchaseConfirm", method = RequestMethod.POST)
  public ModelAndView order(ModelAndView mav, BindingResult bindingResult, HttpServletRequest request)
  {
    // リダイレクト
    return new ModelAndView("redirect:/PurchaseConfirm");
  }



}
