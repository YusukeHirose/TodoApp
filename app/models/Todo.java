package models;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;
import javax.persistence.*;

@Entity
public class Todo extends Model {

  @Id
  public Long id;

  public String title;


  public static Finder<Long, Todo> find = new Finder(Long.class, Todo.class);

  public static List<Todo> all() {
    return find.all();
  }

  public static void create(Todo todo) {
    todo.save();
  }

}
