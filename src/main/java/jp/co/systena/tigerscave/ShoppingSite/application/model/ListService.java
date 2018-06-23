package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class ListService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  NamedParameterJdbcTemplate npJdbcTemplate;

  // 商品リスト
  private List<Item> itemList;

  public ListService()
  {
    this.itemList = new ArrayList<Item>();

  }

  // 商品IDから商品情報を取得
  public Item findItemById(int itemId)
  {
    // SQL文
    String commandText = "SELECT * FROM itemlist WHERE item_id=:itemId";

    // パラメータ
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("itemId", itemId);

    // 指定した商品IDをもつ商品情報（1件）を取得
    List<Item> list = npJdbcTemplate.query(commandText, param, new BeanPropertyRowMapper<Item>(Item.class));

    return list.get(0);

  }

  // DBから商品情報を取得
  public List<Item> getItemList() {

    String commandText = "SELECT * FROM itemlist ORDER BY item_id";

    itemList = jdbcTemplate.query(commandText, new BeanPropertyRowMapper<Item>(Item.class));

    return itemList;
  }
}
