package jp.co.systena.tigerscave.ShoppingSite.application.model;

public class Order {

  // 商品
  private Item item;

  // 個数
  private int num;

  public Order(Item item, int num)
  {
    setItem(item);
    setNum(num);
  }

  public Item getItem()
  {
    return item;
  }

  public int getNum()
  {
    return num;
  }

  public void setItem(Item item)
  {
    this.item = item;
  }

  public void setNum(int num)
  {
    this.num = num;
  }

  // 小計を返す
  public int getSum()
  {
    int sum = item.getPrice() * num;

    return sum;
  }



}
