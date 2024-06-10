package hexlet.code.controller;

import hexlet.code.dto.BasePage;
import io.javalin.http.Context;
import java.util.Collections;

public class RootController {
    public static void index(Context ctx) {
        var page = new BasePage();
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
}