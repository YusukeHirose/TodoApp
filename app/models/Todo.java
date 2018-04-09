package models;

import java.util.*;
import java.util.Date;
import java.util.function.ToDoubleBiFunction;

import com.avaje.ebean.annotation.*;
import com.sun.javafx.image.impl.ByteIndexed.Getter;

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
  @Column(unique = true)
  public String title;

  @Required(message = "必須項目です。")
  @Formats.DateTime(pattern = "yyyy/MM/dd")
  public Date deadline;

  @CreatedTimestamp
  public Date created_at;

  @UpdatedTimestamp
  public Date updated_at;

  public String rate;

  public Integer state;

  public Todo(){
    this.state = 0;
  }

  public static Finder<Long, Todo> find = new Finder(Long.class, Todo.class);

  public static List<Todo> all() {
    return find.where().orderBy("created_at desc").findList();
  }

  public static Todo find(Long id) {
    return find.byId(id);
  }

  public static List<Todo> find_order_created_at(String input) {
    return find.where().eq("state", 0).ilike("title", "%" + input + "%").orderBy("created_at desc").findList();
  }

  public static void create(Todo todo) {
    todo.save();
  }

  public static void update(Long id, String title, Date deadline, String rate, Integer state) {
    Todo todo = Todo.find(id);
    todo.title = title;
    todo.deadline = deadline;
    todo.rate = rate;
    todo.state = state;
    todo.update();
  }
}
