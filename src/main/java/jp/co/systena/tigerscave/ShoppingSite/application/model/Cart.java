package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {

  // 注文リスト
  private List<Order> orderList = new ArrayList<Order>();

  public List<Order> getOrderList()
  {
    return orderList;
  }

  public void setOrderList(List<Order> orderList)
  {
    this.orderList = orderList;
  }

  // カートに追加する。
  public void add(Order order)
  {
    Order existOrder = findOrderByItemId(order.getItem().getItemId());

    if(existOrder == null) //カートに同じ商品が存在しない場合
    {
      orderList.add(order);
      Collections.sort(orderList, new OrderComparator());
    }
    else // 既に同じ商品がカートにある場合
    {
      existOrder.setNum(existOrder.getNum() + order.getNum());
    }

  }

  // カートから削除する
  public void removeOrder(int itemId)
  {
    Order order = findOrderByItemId(itemId);
    orderList.remove(order);
  }

  // 指定した商品IDの注文情報を取得
  private Order findOrderByItemId(int itemId)
  {
    for(Order order : orderList)
    {
      if(order.getItem().getItemId() == itemId)
      {
        return order;
      }
    }

    // アイテムが見つからなかった場合、NULLを返す
    return null;
  }

  public int getTotal()
  {
    int total = 0;

    for(int i = 0; i < orderList.size(); i++)
    {
      total += orderList.get(i).getSum();
    }

    return total;

  }
}
