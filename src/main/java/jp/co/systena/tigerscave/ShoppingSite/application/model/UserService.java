package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  //@Autowired
  //JdbcTemplate jdbcTemplate;

  @Autowired
  NamedParameterJdbcTemplate npJdbcTemplate;

  // ユーザ情報
  User user;

  public UserService()
  {
    this.user = new User();
  }

  // DBから、ユーザID・パスワードの組み合わせが一致するユーザ情報を取得
  public User findUser(String userId, String password)
  {
    // SQL文
    String commandText = "SELECT * FROM userlist WHERE user_id=:userId AND password=:pass";

    // パラメータ
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("userId", userId)
        .addValue("pass", password);

    // 指定したユーザIDをもつユーザ情報（1件）を取得
    List<User> list = npJdbcTemplate.query(commandText, param, new BeanPropertyRowMapper<User>(User.class));

    if(list.size() > 0)
    {
      return list.get(0);
    }
    else
    {
      return null;
    }
  }

  // 指定したユーザIDがDBに登録されているかを確認
  public boolean checkUserId(String userId)
  {
    // SQL文
    String commandText = "SELECT COUNT(*) FROM userlist WHERE user_id=:userId";

    // パラメータ
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("userId", userId);

    // 指定したユーザIDをもつユーザ情報（1件）を取得
    int result = npJdbcTemplate.queryForObject(commandText, param, Integer.class);

    if(result > 0)
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  // ユーザの登録
  public void registerUser(String userId, String userName, String password)
  {
    // SQL文
    String commandText = "INSERT INTO userlist(user_id, user_name, password) VALUES(:userId, :userName, :pass)";

    // パラメータ
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("userId", userId)
        .addValue("userName", userName)
        .addValue("pass", password);

    // 指定したユーザIDをもつユーザ情報（1件）を取得
    int result = npJdbcTemplate.update(commandText, param);

  }
}
