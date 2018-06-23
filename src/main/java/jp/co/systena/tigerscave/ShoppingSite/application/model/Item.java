package jp.co.systena.tigerscave.ShoppingSite.application.model;

// 商品クラス
public class Item {

  // 商品ID
  private int itemId;

  // 商品名
  private String itemName;

  // 価格
  private int price;

  // デフォルトコンストラクタ
  public Item() {

  }

  // コンストラクタ
  public Item(int itemId, String name, int price)
  {
    setItemId(itemId);
    setItemName(name);
    setPrice(price);
  }

  public int getItemId() {

    return itemId;
  }

  public void setItemId(int itemId) {

    this.itemId = itemId;
  }

  public String getItemName() {

    return itemName;
  }

  public void setItemName(String name) {

    this.itemName = name;
  }

  public int getPrice() {

    return price;
  }

  public void setPrice(int price) {

    this.price = price;
  }

}
