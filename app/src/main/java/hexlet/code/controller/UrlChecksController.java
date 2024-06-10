package hexlet.code.controller;

import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlChecksRepository;
import hexlet.code.repository.UrlsRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.sql.SQLException;

public class UrlChecksController {
    public static void addCheck(Context ctx) throws SQLException {
        var urlId = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlsRepository.find(urlId)
                .orElseThrow(() -> new NotFoundResponse("Url not found"));

        String urlName = url.getName();
        HttpResponse<String> response = Unirest.get(urlName).asString();
        Document document = Jsoup.parse(response.getBody());

        int statusCode = response.getStatus();
        String title = document.title();

        Element h1Element = document.selectFirst("h1");
        String h1 = h1Element != null ? h1Element.text() : "";

        String description = document.getElementsByAttributeValue("name", "description").attr("content");

        UrlCheck urlCheck = new UrlCheck(statusCode, title, h1, description, urlId);
        UrlChecksRepository.save(urlCheck);
        ctx.sessionAttribute("flash", "Страница успешно проверена");
        ctx.sessionAttribute("flash-type", "success");
        ctx.redirect(NamedRoutes.urlPath(urlId));
    }
}