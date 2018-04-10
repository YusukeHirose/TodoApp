import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.*;


import static play.mvc.Results.*;

public class Global extends GlobalSettings {
    
    public Promise<SimpleResult> onError(RequestHeader request, Throwable t) {
        return Promise.<SimpleResult>pure(internalServerError(views.html.error.render("ページを表示できません。")));
    }

    public Promise<SimpleResult> onHandlerNotFound(RequestHeader request) {
        return Promise.<SimpleResult>pure(notFound(views.html.error.render("ページが見つかりません。")));
    }

}