package gg.jte.generated.ondemand;
import com.jvmd.lyceum_backend.model.Achievement;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteachievementsGenerated {
	public static final String JTE_NAME = "achievements.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,9,9,15,15,25,25,30,30,32,32,35,35,35,35,36,36,36,38,38,38,39,39,39,41,41,41,42,42,42,46,46,46,47,47,47,52,52,54,54,57,57,57,58,58,58,5,6,7,7,7,7};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Achievement> achievements, String currentUser, Set<Role> userRoles) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Достижения", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header\">\n            <div class=\"container\">\n                <h1>Достижения учеников</h1>\n                <p>Гордость нашей школы — успехи наших учеников на олимпиадах и конкурсах</p>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                ");
				if (achievements.isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"empty-state\">\n                        <div class=\"empty-state-icon\">🏆</div>\n                        <p>Достижений пока нет</p>\n                    </div>\n                ");
				} else {
					jteOutput.writeContent("\n                    <div class=\"grid grid-3\">\n                        ");
					for (Achievement a : achievements) {
						jteOutput.writeContent("\n                            <div class=\"card\">\n                                <div class=\"card-body achievement-card\">\n                                    <div class=\"achievement-level ");
						jteOutput.setContext("div", "class");
						jteOutput.writeUserContent(a.getLevel().toLowerCase().contains("золот") || a.getLevel().equalsIgnoreCase("gold") || a.getLevel().equals("1") ? "level-gold" : a.getLevel().toLowerCase().contains("серебр") || a.getLevel().equalsIgnoreCase("silver") || a.getLevel().equals("2") ? "level-silver" : a.getLevel().toLowerCase().contains("бронз") || a.getLevel().equalsIgnoreCase("bronze") || a.getLevel().equals("3") ? "level-bronze" : "level-other");
						jteOutput.setContext("div", null);
						jteOutput.writeContent("\">\n                                        ");
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(a.getLevel());
						jteOutput.writeContent("\n                                    </div>\n                                    <h3 class=\"card-title\">");
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(a.getTitle());
						jteOutput.writeContent("</h3>\n                                    <p class=\"card-text\" style=\"margin-bottom:0.4rem\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(a.getDescription());
						jteOutput.writeContent("</p>\n                                    <div class=\"card-meta\">\n                                        <span class=\"badge badge-primary\">");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(a.getCategory());
						jteOutput.writeContent("</span>\n                                        <span>");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(a.getYear());
						jteOutput.writeContent("</span>\n                                    </div>\n                                    <div style=\"margin-top:0.75rem;padding-top:0.75rem;border-top:1px solid var(--border-light)\">\n                                        <div style=\"font-size:0.85rem;color:var(--text-muted)\">\n                                            <strong style=\"color:var(--primary)\">");
						jteOutput.setContext("strong", null);
						jteOutput.writeUserContent(a.getStudentName());
						jteOutput.writeContent("</strong>\n                                            <br>");
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(a.getPlace());
						jteOutput.writeContent("\n                                        </div>\n                                    </div>\n                                </div>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "achievements");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Achievement> achievements = (List<Achievement>)params.get("achievements");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, achievements, currentUser, userRoles);
	}
}
