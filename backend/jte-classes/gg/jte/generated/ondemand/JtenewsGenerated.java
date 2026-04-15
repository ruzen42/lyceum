package gg.jte.generated.ondemand;
import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtenewsGenerated {
	public static final String JTE_NAME = "news.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,10,10,16,16,26,26,27,27,27,28,28,30,30,35,35,37,37,39,39,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,41,41,43,43,45,45,46,46,46,47,47,48,48,48,49,49,49,51,51,52,52,52,53,53,54,54,54,58,58,60,60,63,63,63,64,64,64,5,6,7,8,8,8,8};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<News> newsList, String currentUser, Set<Role> userRoles, String success) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Новости", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header bellota-bold\">\n            <div class=\"container\">\n                <h1 class=\"bellota-bold\">Новости</h1>\n                <p>Актуальные события и публикации нашей школы</p>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                ");
				if (success != null) {
					jteOutput.writeContent("\n                    <div class=\"alert alert-success\">✓ ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(success);
					jteOutput.writeContent("</div>\n                ");
				}
				jteOutput.writeContent("\n\n                ");
				if (newsList.isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"empty-state\">\n                        <div class=\"empty-state-icon\">📰</div>\n                        <p>Новостей пока нет</p>\n                    </div>\n                ");
				} else {
					jteOutput.writeContent("\n                    <div class=\"grid grid-2\">\n                        ");
					for (News news : newsList) {
						jteOutput.writeContent("\n                            <div class=\"card\">\n                                ");
						if (news.getImageUrl() != null) {
							jteOutput.writeContent("\n                                    <img");
							var __jte_html_attribute_0 = news.getImageUrl();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeContent(" src=\"");
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							var __jte_html_attribute_1 = news.getTitle();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
								jteOutput.writeContent(" alt=\"");
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_1);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							jteOutput.writeContent(" class=\"card-img\">\n                                ");
						} else {
							jteOutput.writeContent("\n                                    <div class=\"card-img-placeholder\">📰</div>\n                                ");
						}
						jteOutput.writeContent("\n                                <div class=\"card-body\">\n                                    ");
						if (news.getCategory() != null) {
							jteOutput.writeContent("\n                                        <span class=\"badge badge-secondary\">");
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(news.getCategory());
							jteOutput.writeContent("</span>\n                                    ");
						}
						jteOutput.writeContent("\n                                    <h2 class=\"card-title bellota-bold\" style=\"margin-top:0.5rem\">");
						jteOutput.setContext("h2", null);
						jteOutput.writeUserContent(news.getTitle());
						jteOutput.writeContent("</h2>\n                                    <p class=\"card-text\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(news.getContent());
						jteOutput.writeContent("</p>\n                                    <div class=\"card-meta\" style=\"margin-top:1rem\">\n                                        ");
						if (news.getUser() != null) {
							jteOutput.writeContent("\n                                            <span>✍ ");
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(news.getUser().getUsername());
							jteOutput.writeContent("</span>\n                                        ");
						}
						jteOutput.writeContent("\n                                        <span>🗓 ");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(news.getCreatedAt().toLocalDate().toString());
						jteOutput.writeContent("</span>\n                                    </div>\n                                </div>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "news");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<News> newsList = (List<News>)params.get("newsList");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		String success = (String)params.getOrDefault("success", null);
		render(jteOutput, jteHtmlInterceptor, newsList, currentUser, userRoles, success);
	}
}
