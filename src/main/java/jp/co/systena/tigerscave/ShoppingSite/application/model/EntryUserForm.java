package jp.co.systena.tigerscave.ShoppingSite.application.model;

public class EntryUserForm {

  // ユーザID
  private String userId;

  // ユーザ名
  private String userName;

  // パスワード
  private String password;

  // （確認用）パスワード
  private String validationPass;


  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userId)
  {
    this.userId = userId;
  }


  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }


  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getValidationPass()
  {
    return validationPass;
  }

  public void setValidationPass(String validationPass)
  {
    this.validationPass = validationPass;
  }

}
