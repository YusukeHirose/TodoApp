package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.*;

public class Application extends Controller {

    static Form<models.Todo> todoForm = Form.form(models.Todo.class);

    public static Result root() {
        return redirect(routes.Application.index());
    }

    public static Result index() {
        return ok(index.render(models.Todo.all(),todoForm));
    }

    public static Result create() {
       Form<models.Todo> filledForm = todoForm.bindFromRequest();
       if (filledForm.hasErrors()) {
           return badRequest(
               index.render(models.Todo.all(),filledForm)
           );
       } else {
           models.Todo.create(filledForm.get());
           return redirect(routes.Application.index());
       }
    }

    public static Result edit(Long id) {
        models.Todo todo = models.Todo.find(id);
        return ok(edit.render(todo,todoForm));
    }

    public static Result update(Long id) {
        Form<models.Todo> filledForm = todoForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(
                index.render(models.Todo.all(),filledForm)
            );
        } else {
            models.Todo.update(filledForm.get());
            return redirect(routes.Application.index());
        }
    }

    public static Result search() {
        return ok(search.render("/search"));
    }

}
