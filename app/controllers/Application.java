package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.*;
import java.util.List;

import java.util.Comparator;

public class Application extends Controller {

    static Form<models.Todo> todoForm = Form.form(models.Todo.class);
    
    //検索用
    public static class FindForm {
        public String input;
    }

    public static Result root() {
        return redirect(routes.Application.index());
    }

    public static Result index() {
        Form<models.Todo> todoForm = new Form(models.Todo.class);
        return ok(index.render("", models.Todo.all(),todoForm));
    }

    public static Result create() {
       Form<models.Todo> filledForm = todoForm.bindFromRequest();
       if (filledForm.hasErrors()) {
           return badRequest(
               index.render("", models.Todo.all(),filledForm)
           );
       }

       try {
           models.Todo.create(filledForm.get());
           return redirect(routes.Application.index());
       } catch(Exception e) {
            return badRequest(index.render("既に登録されています。",models.Todo.all(), filledForm));
       }
    }

    public static Result edit(Long id) {
        models.Todo todo = models.Todo.find(id);
        todoForm = new Form(models.Todo.class).fill(todo);
        return ok(edit.render(todo,todoForm));
    }

    public static Result update(Long id) {
        Form<models.Todo> filledForm = todoForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(
                index.render("", models.Todo.all(),filledForm)
            );
        } else {
            models.Todo.update(filledForm.get());
            return redirect(routes.Application.index());
        }
    }

    public static Result search() {
        Form<FindForm> f = new Form(FindForm.class).bindFromRequest();
        List<models.Todo> datas = null;
        List<models.Todo> search_datas = null;
        if (!f.hasErrors()) {
            String input = f.get().input;
            datas = models.Todo.find.where().eq("state",0).ilike("title", "%" + input + "%").orderBy("created_at desc").findList();
        }
        return ok(search.render(f,datas));
    }

}
