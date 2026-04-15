package gg.jte.generated.ondemand;
import com.jvmd.lyceum_backend.model.StudentPortfolio;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteportfolioGenerated {
	public static final String JTE_NAME = "portfolio.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,9,9,15,15,25,25,30,30,32,32,38,38,38,39,39,39,43,43,45,45,45,45,45,45,45,45,45,51,51,54,54,54,58,58,60,60,63,63,63,64,64,64,5,6,7,7,7,7};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<StudentPortfolio> portfolios, String currentUser, Set<Role> userRoles) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Портфолио", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header bellota-bold\">\n            <div class=\"container\">\n                <h1 class=\"bellota-bold\">Портфолио студентов</h1>\n                <p>Знакомьтесь с нашими талантливыми учениками</p>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                ");
				if (portfolios.isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"empty-state\">\n                        <div class=\"empty-state-icon\">👨‍🎓</div>\n                        <p>Портфолио пока нет</p>\n                    </div>\n                ");
				} else {
					jteOutput.writeContent("\n                    <div class=\"grid grid-2\">\n                        ");
					for (StudentPortfolio p : portfolios) {
						jteOutput.writeContent("\n                            <div class=\"card\">\n                                <div class=\"card-body\">\n                                    <div class=\"portfolio-card\">\n                                        <div class=\"portfolio-avatar-placeholder\">👤</div>\n                                        <div style=\"flex:1\">\n                                            <h3 class=\"card-title bellota-bold\" style=\"margin-bottom:0.2rem\">");
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(p.getStudentName());
						jteOutput.writeContent("</h3>\n                                            <span class=\"badge badge-secondary\">");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(p.getGrade());
						jteOutput.writeContent("</span>\n                                        </div>\n                                    </div>\n\n                                    ");
						if (p.getFileUrl() != null) {
							jteOutput.writeContent("\n                                        <div style=\"margin-top:1rem\">\n                                            <a");
							var __jte_html_attribute_0 = p.getFileUrl();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeContent(" href=\"");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("a", null);
								jteOutput.writeContent("\"");
							}
							jteOutput.writeContent(" target=\"_blank\"\n                                               class=\"btn btn-outline btn-sm\"\n                                               style=\"display:inline-flex;align-items:center;gap:0.4rem\">\n                                                <span>📄</span> Скачать портфолио\n                                            </a>\n                                        </div>\n                                    ");
						}
						jteOutput.writeContent("\n\n                                    <div class=\"card-meta\" style=\"margin-top:1rem\">\n                                        <span style=\"font-size:0.78rem\">Добавлено: ");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(p.getCreatedAt().toLocalDate().toString());
						jteOutput.writeContent("</span>\n                                    </div>\n                                </div>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "portfolio");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<StudentPortfolio> portfolios = (List<StudentPortfolio>)params.get("portfolios");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, portfolios, currentUser, userRoles);
	}
}
