package gg.jte.generated.ondemand.museum;
import com.jvmd.lyceum_backend.model.MuseumExhibit;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtedetailGenerated {
	public static final String JTE_NAME = "museum/detail.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,8,8,14,14,20,20,20,26,26,28,28,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,30,30,32,32,34,34,36,36,38,38,39,39,39,40,40,42,42,46,46,48,48,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,50,50,52,52,54,54,54,57,57,57,57,60,60,62,62,65,65,65,66,66,66,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MuseumExhibit exhibit, String currentUser, Set<Role> userRoles) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, exhibit.getTitle(), new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header bellota-bold\">\n            <div class=\"container\">\n                <div style=\"font-size:0.875rem;margin-bottom:0.5rem\">\n                    <a href=\"/museum\" style=\"color:rgba(255,255,255,0.7)\">← Музей</a>\n                </div>\n                <h1 class=\"bellota-bold\">");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(exhibit.getTitle());
				jteOutput.writeContent("</h1>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                ");
				if (!exhibit.getImageUrls().isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"exhibit-images\">\n                        ");
					for (String url : exhibit.getImageUrls()) {
						jteOutput.writeContent("\n                            <img");
						var __jte_html_attribute_0 = url;
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
							jteOutput.writeContent(" src=\"");
							jteOutput.setContext("img", "src");
							jteOutput.writeUserContent(__jte_html_attribute_0);
							jteOutput.setContext("img", null);
							jteOutput.writeContent("\"");
						}
						var __jte_html_attribute_1 = exhibit.getTitle();
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
							jteOutput.writeContent(" alt=\"");
							jteOutput.setContext("img", "alt");
							jteOutput.writeUserContent(__jte_html_attribute_1);
							jteOutput.setContext("img", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(" onclick=\"this.requestFullscreen && this.requestFullscreen()\">\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n\n                ");
				if (exhibit.getHtmlContent() != null && !exhibit.getHtmlContent().isBlank()) {
					jteOutput.writeContent("\n                    <div class=\"exhibit-html-content\">\n                        ");
					jteOutput.writeUnsafeContent(exhibit.getHtmlContent());
					jteOutput.writeContent("\n                    </div>\n                ");
				} else if (exhibit.getDescription() != null) {
					jteOutput.writeContent("\n                    <p style=\"font-size:1.05rem;line-height:1.7;color:var(--text)\">");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(exhibit.getDescription());
					jteOutput.writeContent("</p>\n                ");
				}
				jteOutput.writeContent("\n\n                ");
				if (!exhibit.getRelatedExhibits().isEmpty()) {
					jteOutput.writeContent("\n                    <hr class=\"divider\">\n                    <h2 class=\"bellota-bold\" style=\"font-size:1.25rem;font-weight:700;color:var(--primary);margin-bottom:1.25rem\">Связанные экспонаты</h2>\n                    <div class=\"grid grid-3\">\n                        ");
					for (MuseumExhibit rel : exhibit.getRelatedExhibits()) {
						jteOutput.writeContent("\n                            <div class=\"card\">\n                                ");
						if (!rel.getImageUrls().isEmpty()) {
							jteOutput.writeContent("\n                                    <img");
							var __jte_html_attribute_2 = rel.getImageUrls().get(0);
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
								jteOutput.writeContent(" src=\"");
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_2);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							var __jte_html_attribute_3 = rel.getTitle();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
								jteOutput.writeContent(" alt=\"");
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_3);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							jteOutput.writeContent(" class=\"card-img\">\n                                ");
						} else {
							jteOutput.writeContent("\n                                    <div class=\"card-img-placeholder\">🏛️</div>\n                                ");
						}
						jteOutput.writeContent("\n                                <div class=\"card-body\">\n                                    <h3 class=\"card-title bellota-bold\">");
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(rel.getTitle());
						jteOutput.writeContent("</h3>\n                                </div>\n                                <div class=\"card-footer\">\n                                    <a href=\"/museum/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(rel.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\" class=\"btn btn-primary btn-sm\">Смотреть</a>\n                                </div>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "museum");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MuseumExhibit exhibit = (MuseumExhibit)params.get("exhibit");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, exhibit, currentUser, userRoles);
	}
}
