package gg.jte.generated.ondemand.museum;
import com.jvmd.lyceum_backend.model.MuseumExhibit;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtelistGenerated {
	public static final String JTE_NAME = "museum/list.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,9,9,15,15,25,25,30,30,32,32,34,34,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,36,36,38,38,40,40,40,41,41,42,42,42,43,43,44,44,46,46,46,48,48,51,51,51,51,52,52,53,53,53,54,54,57,57,59,59,62,62,62,63,63,63,5,6,7,7,7,7};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<MuseumExhibit> exhibits, String currentUser, Set<Role> userRoles) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Школьный музей", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header\">\n            <div class=\"container\">\n                <h1>Школьный музей</h1>\n                <p>Сохраняем историю. Вдохновляем будущее.</p>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                ");
				if (exhibits.isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"empty-state\">\n                        <div class=\"empty-state-icon\">🏛️</div>\n                        <p>Экспонаты пока не добавлены</p>\n                    </div>\n                ");
				} else {
					jteOutput.writeContent("\n                    <div class=\"grid grid-3\">\n                        ");
					for (MuseumExhibit e : exhibits) {
						jteOutput.writeContent("\n                            <div class=\"card\">\n                                ");
						if (!e.getImageUrls().isEmpty()) {
							jteOutput.writeContent("\n                                    <img");
							var __jte_html_attribute_0 = e.getImageUrls().get(0);
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeContent(" src=\"");
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							var __jte_html_attribute_1 = e.getTitle();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
								jteOutput.writeContent(" alt=\"");
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_1);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							jteOutput.writeContent(" class=\"card-img\">\n                                ");
						} else {
							jteOutput.writeContent("\n                                    <div class=\"card-img-placeholder\">🏛️</div>\n                                ");
						}
						jteOutput.writeContent("\n                                <div class=\"card-body\">\n                                    <h3 class=\"card-title\">");
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(e.getTitle());
						jteOutput.writeContent("</h3>\n                                    ");
						if (e.getDescription() != null) {
							jteOutput.writeContent("\n                                        <p class=\"card-text\">");
							jteOutput.setContext("p", null);
							jteOutput.writeUserContent(e.getDescription().length() > 100 ? e.getDescription().substring(0, 100) + "..." : e.getDescription());
							jteOutput.writeContent("</p>\n                                    ");
						}
						jteOutput.writeContent("\n                                    ");
						if (!e.getImageUrls().isEmpty()) {
							jteOutput.writeContent("\n                                        <div class=\"card-meta\">\n                                            <span style=\"font-size:0.78rem\">📷 ");
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(e.getImageUrls().size());
							jteOutput.writeContent(" фото</span>\n                                        </div>\n                                    ");
						}
						jteOutput.writeContent("\n                                </div>\n                                <div class=\"card-footer\">\n                                    <a href=\"/museum/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(e.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\" class=\"btn btn-primary btn-sm\">Подробнее</a>\n                                    ");
						if (!e.getRelatedExhibits().isEmpty()) {
							jteOutput.writeContent("\n                                        <span class=\"text-muted\" style=\"font-size:0.78rem\">связано: ");
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(e.getRelatedExhibits().size());
							jteOutput.writeContent("</span>\n                                    ");
						}
						jteOutput.writeContent("\n                                </div>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "museum");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<MuseumExhibit> exhibits = (List<MuseumExhibit>)params.get("exhibits");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, exhibits, currentUser, userRoles);
	}
}
