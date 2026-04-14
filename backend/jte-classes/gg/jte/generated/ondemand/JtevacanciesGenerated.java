package gg.jte.generated.ondemand;
import com.jvmd.lyceum_backend.model.Vacancy;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtevacanciesGenerated {
	public static final String JTE_NAME = "vacancies.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,9,9,15,15,25,25,30,30,31,31,35,35,35,36,36,37,37,37,38,38,40,40,40,46,46,47,47,50,50,50,51,51,51,5,6,7,7,7,7};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Vacancy> vacancies, String currentUser, Set<Role> userRoles) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Вакансии", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header\">\n            <div class=\"container\">\n                <h1>Вакансии</h1>\n                <p>Присоединяйтесь к нашей команде профессионалов</p>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                ");
				if (vacancies.isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"empty-state\">\n                        <div class=\"empty-state-icon\">💼</div>\n                        <p>Открытых вакансий сейчас нет</p>\n                    </div>\n                ");
				} else {
					jteOutput.writeContent("\n                    ");
					for (Vacancy v : vacancies) {
						jteOutput.writeContent("\n                        <div class=\"vacancy-card\">\n                            <div style=\"display:flex;align-items:flex-start;justify-content:space-between;gap:1rem\">\n                                <div>\n                                    <h3>");
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(v.getTitle());
						jteOutput.writeContent("</h3>\n                                    ");
						if (v.getDescription() != null && !v.getDescription().isBlank()) {
							jteOutput.writeContent("\n                                        <p style=\"margin-top:0.5rem\">");
							jteOutput.setContext("p", null);
							jteOutput.writeUserContent(v.getDescription());
							jteOutput.writeContent("</p>\n                                    ");
						}
						jteOutput.writeContent("\n                                    <div style=\"margin-top:0.75rem;font-size:0.78rem;color:var(--text-muted)\">\n                                        Опубликовано: ");
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(v.getCreatedAt().toLocalDate().toString());
						jteOutput.writeContent("\n                                    </div>\n                                </div>\n                                <span class=\"badge badge-success\" style=\"flex-shrink:0\">Открыта</span>\n                            </div>\n                        </div>\n                    ");
					}
					jteOutput.writeContent("\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "vacancies");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Vacancy> vacancies = (List<Vacancy>)params.get("vacancies");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, vacancies, currentUser, userRoles);
	}
}
