package jp.co.systena.tigerscave.ShoppingSite.application.model;

public class ListForm {

  // アイテムID
  private int[] itemIdList;
  //private int itemId;

  // 数量
  private int[] nums;

//  public ListForm(int numListSize)
//  {
//    this.nums = new String[numListSize];
//  }

//  public int getItemId()
//  {
//    return itemId;
//  }
//
//  public void setItemId(int itemId)
//  {
//    this.itemId = itemId;
//  }
  public int[] getItemIdList()
  {
    return itemIdList;
  }

  public void setItemIdList(int[] itemIdList)
  {
    this.itemIdList = itemIdList;
  }

  public int[] getNums()
  {
    return nums;
  }

  public void setNums(int[] nums)
  {
    this.nums = nums;
  }

}
