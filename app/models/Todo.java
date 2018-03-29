package models;

import java.util.*;
import java.util.Date;
import com.avaje.ebean.annotation.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;
import javax.persistence.*;
import play.data.format.Formats;

@Entity

@Table(name = "todos")
public class Todo extends Model {

  static final String TODOS = "todos";

@Id
  public Long id;

  @Required(message = "必須項目です。")
  @MaxLength(value = 31, message = "文字数オーバーです。")
  public String title;

  @Required(message = "必須項目です。")
  @Formats.DateTime(pattern = "yyyy/MM/dd")
  public Date deadline;

  @CreatedTimestamp
  public Date created_at;

  @UpdatedTimestamp
  public Date updated_at;

  public String rate;

  public static Finder<Long, Todo> find = new Finder(Long.class, Todo.class);

  public static List<Todo> all() {
    return find.all();
  }

  public static Todo find(Long id) {
    return find.byId(id);
  }

  public static void create(Todo todo) {
    todo.save();
  }

  public static void update(Todo todo) {
    todo.update();
  }

}
