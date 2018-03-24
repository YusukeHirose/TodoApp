package models;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.*;
import play.db.ebean.*;
import play.data.validation.*;

@Entity
public class Todo extends Model {

  @Id
  public Long id;

  @Constraints.Required
  @Constraints.Min(1)
  @Constraints.Max(31)
  public String title;

  @Constraints.Required
  public Date deadline;

  @Constraints.Required
  public Date createdAt;

  public Date updatedAt;

}
