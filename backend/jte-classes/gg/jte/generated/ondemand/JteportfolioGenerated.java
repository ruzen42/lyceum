package gg.jte.generated.ondemand;
import com.jvmd.lyceum_backend.model.StudentPortfolio;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteportfolioGenerated {
	public static final String JTE_NAME = "portfolio.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,9,9,15,15,25,25,30,30,32,32,36,36,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,38,38,40,40,42,42,42,43,43,43,46,46,46,48,48,52,52,53,53,53,54,54,57,57,59,59,63,63,64,64,64,65,65,68,68,71,71,71,75,75,77,77,80,80,80,81,81,81,5,6,7,7,7,7};
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
						jteOutput.writeContent("\n                            <div class=\"card\">\n                                <div class=\"card-body\">\n                                    <div class=\"portfolio-card\">\n                                        ");
						if (p.getImageUrl() != null) {
							jteOutput.writeContent("\n                                            <img");
							var __jte_html_attribute_0 = p.getImageUrl();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeContent(" src=\"");
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							var __jte_html_attribute_1 = p.getStudentName();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
								jteOutput.writeContent(" alt=\"");
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_1);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							jteOutput.writeContent(" class=\"portfolio-avatar\">\n                                        ");
						} else {
							jteOutput.writeContent("\n                                            <div class=\"portfolio-avatar-placeholder\">👤</div>\n                                        ");
						}
						jteOutput.writeContent("\n                                        <div style=\"flex:1\">\n                                            <h3 class=\"card-title bellota-bold\" style=\"margin-bottom:0.2rem\">");
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(p.getStudentName());
						jteOutput.writeContent("</h3>\n                                            <span class=\"badge badge-secondary\">");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(p.getGrade());
						jteOutput.writeContent("</span>\n                                        </div>\n                                    </div>\n                                    <p class=\"card-text\" style=\"margin-top:1rem\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(p.getBio());
						jteOutput.writeContent("</p>\n\n                                    ");
						if (!p.getSkills().isEmpty()) {
							jteOutput.writeContent("\n                                        <div style=\"margin-top:0.875rem\">\n                                            <div style=\"font-size:0.78rem;font-weight:700;color:var(--text-muted);text-transform:uppercase;letter-spacing:0.05em;margin-bottom:0.4rem\">Навыки</div>\n                                            <div class=\"tags\">\n                                                ");
							for (String skill : p.getSkills()) {
								jteOutput.writeContent("\n                                                    <span class=\"tag\">");
								jteOutput.setContext("span", null);
								jteOutput.writeUserContent(skill);
								jteOutput.writeContent("</span>\n                                                ");
							}
							jteOutput.writeContent("\n                                            </div>\n                                        </div>\n                                    ");
						}
						jteOutput.writeContent("\n\n                                    ");
						if (!p.getAchievements().isEmpty()) {
							jteOutput.writeContent("\n                                        <div style=\"margin-top:0.875rem\">\n                                            <div style=\"font-size:0.78rem;font-weight:700;color:var(--text-muted);text-transform:uppercase;letter-spacing:0.05em;margin-bottom:0.4rem\">Достижения</div>\n                                            <ul style=\"padding-left:1.2rem;font-size:0.85rem;color:var(--text-muted)\">\n                                                ");
							for (String ach : p.getAchievements()) {
								jteOutput.writeContent("\n                                                    <li>");
								jteOutput.setContext("li", null);
								jteOutput.writeUserContent(ach);
								jteOutput.writeContent("</li>\n                                                ");
							}
							jteOutput.writeContent("\n                                            </ul>\n                                        </div>\n                                    ");
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
