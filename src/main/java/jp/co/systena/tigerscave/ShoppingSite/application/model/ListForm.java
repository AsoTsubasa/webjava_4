package jp.co.systena.tigerscave.ShoppingSite.application.model;

public class ListForm {

  // アイテムID
  private int[] itemIdList;

  // 数量
  private int[] nums;

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
