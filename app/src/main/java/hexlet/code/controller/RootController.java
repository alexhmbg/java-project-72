package hexlet.code.controller;

import hexlet.code.dto.BasePage;
import io.javalin.http.Context;

import java.util.Collections;

public class RootController {
    public static void index(Context ctx) {
        var page = new BasePage();
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));

        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
}
