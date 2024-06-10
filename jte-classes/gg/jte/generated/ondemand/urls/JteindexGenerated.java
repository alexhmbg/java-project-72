package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.util.NamedRoutes;
import java.time.format.DateTimeFormatter;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,5,6,6,7,7,8,8,9,9,11,14,14,29,29,31,31,31,33,33,33,33,33,33,33,33,33,33,33,33,35,35,37,37,37,40,40,40,42,42,45,45,47,47,51,51,54,54,54,54,54,54,54,54,54,55,55,55,55,55,55,55,55,57,57,58,58,58,58,58,58,58,58,58,59,59,59,59,59,59,59,59,59,59,59,61,61,62,62,62,62,62,62,62,62,62,63,63,63,63,63,63,63,63,67,67,70,70,70,70,70,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n");
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		jteOutput.writeContent("\n");
		var pages = page.getPages();
		jteOutput.writeContent("\n");
		var currentPage = page.getCurrentPage();
		jteOutput.writeContent("\n");
		var urls = page.getUrls();
		jteOutput.writeContent("\n");
		var urlChecks = page.getUrlChecks();
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <section>\n        <div class=\"container-lg mt-5\">\n            <h1>Сайты</h1>\n\n            <table class=\"table table-bordered table-hover mt-3\">\n                <thead>\n                <tr>\n                    <th class=\"col-1\">ID</th>\n                    <th>Имя</th>\n                    <th class=\"col-2\">Последняя проверка</th>\n                    <th class=\"col-1\">Код ответа</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
				for (var url: urls) {
					jteOutput.writeContent("\n                    <tr>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent("</td>\n                        <td>\n                            <a");
					var __jte_html_attribute_0 = NamedRoutes.urlPath(url.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("</a>\n                        </td>\n                        ");
					if (urlChecks.containsKey(url.getId())) {
						jteOutput.writeContent("\n                            <td>\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlChecks.get(url.getId()).getCreatedAt().toLocalDateTime().format(formatter));
						jteOutput.writeContent("\n                            </td>\n                            <td>\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlChecks.get(url.getId()).getStatusCode());
						jteOutput.writeContent("\n                            </td>\n                        ");
					} else {
						jteOutput.writeContent("\n                            <td></td>\n                            <td></td>\n                        ");
					}
					jteOutput.writeContent("\n                    </tr>\n                ");
				}
				jteOutput.writeContent("\n                </tbody>\n            </table>\n\n            ");
				if (pages.size() > 0) {
					jteOutput.writeContent("\n                <nav aria-label=\"Page navigation\">\n                    <ul class=\"pagination justify-content-center mt-5\">\n                        <li");
					var __jte_html_attribute_1 = "page-item" + (currentPage <= 1 ? " disabled" : "");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" class='");
						jteOutput.setContext("li", "class");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("li", null);
						jteOutput.writeContent("'");
					}
					jteOutput.writeContent(">\n                            <a class=\"page-link\" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(NamedRoutes.urlsPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("?page=");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(currentPage - 1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">Previous</a>\n                        </li>\n                        ");
					for (var pageNumber : pages) {
						jteOutput.writeContent("\n                            <li");
						var __jte_html_attribute_2 = "page-item" + (currentPage == pageNumber ? " active" : "");
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
							jteOutput.writeContent(" class='");
							jteOutput.setContext("li", "class");
							jteOutput.writeUserContent(__jte_html_attribute_2);
							jteOutput.setContext("li", null);
							jteOutput.writeContent("'");
						}
						jteOutput.writeContent(">\n                                <a class=\"page-link\" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(NamedRoutes.urlsPath());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("?page=");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(pageNumber);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(pageNumber);
						jteOutput.writeContent("</a>\n                            </li>\n                        ");
					}
					jteOutput.writeContent("\n                        <li");
					var __jte_html_attribute_3 = "page-item" + (currentPage >= pages.size() ? " disabled" : "");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
						jteOutput.writeContent(" class='");
						jteOutput.setContext("li", "class");
						jteOutput.writeUserContent(__jte_html_attribute_3);
						jteOutput.setContext("li", null);
						jteOutput.writeContent("'");
					}
					jteOutput.writeContent(">\n                            <a class=\"page-link\" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(NamedRoutes.urlsPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("?page=");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(currentPage + 1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">Next</a>\n                        </li>\n                    </ul>\n                </nav>\n            ");
				}
				jteOutput.writeContent("\n        </div>\n    </section>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
