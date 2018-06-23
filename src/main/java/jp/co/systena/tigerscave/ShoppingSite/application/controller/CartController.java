package jp.co.systena.tigerscave.ShoppingSite.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingSite.application.model.Cart;

@Controller
public class CartController
{

  @Autowired
  HttpSession session;

  @RequestMapping(value="/CartView", method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav)
  {
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

  @RequestMapping(value="/CartView", method = RequestMethod.POST)
  public ModelAndView order(ModelAndView mav, BindingResult bindingResult, HttpServletRequest request)
  {
    // リダイレクト
    return new ModelAndView("redirect:/CartView");
  }

  @RequestMapping(value="/DeleteOrder", method = RequestMethod.GET)
  public ModelAndView delete(ModelAndView mav, @RequestParam(name="item_id", required = true) String item_id)
  {
    int itemId = Integer.parseInt(item_id);

    Cart cart = (Cart)session.getAttribute("cart");
    cart.removeOrder(itemId);

    return new ModelAndView("redirect:/CartView");
  }

}
