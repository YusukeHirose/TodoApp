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

    public static Result edit() {
        return ok(edit.render("/edit"));
    }

    public static Result search() {
        return ok(search.render("/search"));
    }

}
