package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.Comparator;

public class OrderComparator implements Comparator<Order>{

  @Override
  public int compare(Order o1, Order o2) {
    return o1.getItem().getItemId() < o2.getItem().getItemId() ? -1 : 1;
  }

}
