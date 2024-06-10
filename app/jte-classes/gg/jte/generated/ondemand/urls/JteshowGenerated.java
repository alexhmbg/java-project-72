package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlPage;
import hexlet.code.util.NamedRoutes;
import java.time.format.DateTimeFormatter;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,5,6,6,7,7,9,12,12,15,15,15,21,21,21,25,25,25,29,29,29,35,35,35,35,35,35,35,35,35,49,49,51,51,51,52,52,52,53,53,53,54,54,54,55,55,55,56,56,56,58,58,63,63,63,63,63,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		jteOutput.writeContent("\n");
		var url = page.getUrl();
		jteOutput.writeContent("\n");
		var checks = page.getUrlChecks();
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <section>\n        <div class=\"container-lg mt-5\">\n            <h1>Сайт ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(url.getName());
				jteOutput.writeContent("</h1>\n\n            <table class=\"table table-bordered table-hover mt-3\">\n                <tbody>\n                <tr>\n                    <td>ID</td>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(url.getId());
				jteOutput.writeContent("</td>\n                </tr>\n                <tr>\n                    <td>Имя</td>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(url.getName());
				jteOutput.writeContent("</td>\n                </tr>\n                <tr>\n                    <td>Дата создания</td>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(url.getCreatedAt().toLocalDateTime().format(formatter));
				jteOutput.writeContent("</td>\n                </tr>\n                </tbody>\n            </table>\n\n            <h2 class=\"mt-5\">Проверки</h2>\n            <form method=\"post\"");
				var __jte_html_attribute_0 = NamedRoutes.checksPath(url.getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n                <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\n            </form>\n\n            <table class=\"table table-bordered table-hover mt-3\">\n                <thead>\n                <th class=\"col-1\">ID</th>\n                <th class=\"col-1\">Код ответа</th>\n                <th>title</th>\n                <th>h1</th>\n                <th>description</th>\n                <th class=\"col-2\">Дата проверки</th>\n                </thead>\n                <tbody>\n                ");
				for (var check : checks) {
					jteOutput.writeContent("\n                    <tr>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getId());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getStatusCode());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getTitle());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getH1());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getDescription());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getCreatedAt().toLocalDateTime().format(formatter));
					jteOutput.writeContent("</td>\n                    </tr>\n                ");
				}
				jteOutput.writeContent("\n                </tbody>\n            </table>\n        </div>\n    </section>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
