package gg.jte.generated.ondemand.classrooms;
import com.jvmd.lyceum_backend.model.Classroom;
import com.jvmd.lyceum_backend.model.Material;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtedetailGenerated {
	public static final String JTE_NAME = "classrooms/detail.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,9,9,15,15,21,21,21,29,29,31,31,33,33,38,38,38,41,41,46,46,47,47,51,51,51,52,52,53,53,53,54,54,55,55,57,57,57,57,57,57,59,59,62,62,64,64,65,65,65,65,65,65,65,65,65,66,66,68,68,70,70,71,71,81,81,81,85,85,85,93,93,93,94,94,94,5,6,7,7,7,7};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Classroom classroom, String currentUser, Set<Role> userRoles) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, classroom.getTitle(), new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header bellota-bold\">\n            <div class=\"container\">\n                <div style=\"font-size:0.875rem;margin-bottom:0.5rem\">\n                    <a href=\"/classrooms\" style=\"color:rgba(255,255,255,0.7)\">← Кабинеты</a>\n                </div>\n                <h1 class=\"bellota-bold\">");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(classroom.getTitle());
				jteOutput.writeContent("</h1>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                <div style=\"display:grid;grid-template-columns:1fr 320px;gap:2rem;align-items:start\">\n                    <div>\n                        ");
				if (classroom.getHtmlContent() != null && !classroom.getHtmlContent().isBlank()) {
					jteOutput.writeContent("\n                            <div class=\"classroom-html-content\" style=\"background:white;border:1px solid var(--border);border-radius:var(--radius-lg);padding:1.75rem;margin-bottom:1.5rem\">\n                                ");
					jteOutput.writeUnsafeContent(classroom.getHtmlContent());
					jteOutput.writeContent("\n                            </div>\n                        ");
				}
				jteOutput.writeContent("\n\n                        <div>\n                            <h2 class=\"bellota-bold\" style=\"font-size:1.15rem;font-weight:700;color:var(--primary);margin-bottom:1rem\">\n                                Учебные материалы\n                                <span class=\"badge badge-secondary\" style=\"margin-left:0.5rem\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(classroom.getMaterials().size());
				jteOutput.writeContent("</span>\n                            </h2>\n\n                            ");
				if (classroom.getMaterials().isEmpty()) {
					jteOutput.writeContent("\n                                <div class=\"empty-state\" style=\"padding:2rem 0\">\n                                    <div class=\"empty-state-icon\">📄</div>\n                                    <p>Материалы пока не добавлены</p>\n                                </div>\n                            ");
				} else {
					jteOutput.writeContent("\n                                ");
					for (Material m : classroom.getMaterials()) {
						jteOutput.writeContent("\n                                    <div class=\"material-card\">\n                                        <div style=\"display:flex;justify-content:space-between;align-items:flex-start\">\n                                            <div style=\"flex:1\">\n                                                <h4>");
						jteOutput.setContext("h4", null);
						jteOutput.writeUserContent(m.getTitle());
						jteOutput.writeContent("</h4>\n                                                ");
						if (m.getDescription() != null && !m.getDescription().isBlank()) {
							jteOutput.writeContent("\n                                                    <p style=\"font-size:0.85rem;color:var(--text-muted);margin-top:0.25rem\">");
							jteOutput.setContext("p", null);
							jteOutput.writeUserContent(m.getDescription());
							jteOutput.writeContent("</p>\n                                                ");
						}
						jteOutput.writeContent("\n                                                ");
						if (m.getAuthor() != null) {
							jteOutput.writeContent("\n                                                    <div style=\"font-size:0.75rem;color:var(--text-muted);margin-top:0.4rem\">\n                                                        ✍ ");
							jteOutput.setContext("div", null);
							jteOutput.writeUserContent(m.getAuthor().getUsername());
							jteOutput.writeContent(" · ");
							jteOutput.setContext("div", null);
							jteOutput.writeUserContent(m.getCreatedAt().toLocalDate().toString());
							jteOutput.writeContent("\n                                                    </div>\n                                                ");
						}
						jteOutput.writeContent("\n                                            </div>\n                                        </div>\n                                        ");
						if (!m.getFileUrls().isEmpty()) {
							jteOutput.writeContent("\n                                            <div class=\"material-files\">\n                                                ");
							for (String url : m.getFileUrls()) {
								jteOutput.writeContent("\n                                                    <a");
								var __jte_html_attribute_0 = url;
								if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
									jteOutput.writeContent(" href=\"");
									jteOutput.setContext("a", "href");
									jteOutput.writeUserContent(__jte_html_attribute_0);
									jteOutput.setContext("a", null);
									jteOutput.writeContent("\"");
								}
								jteOutput.writeContent(" target=\"_blank\" class=\"material-file\">📎 Файл</a>\n                                                ");
							}
							jteOutput.writeContent("\n                                            </div>\n                                        ");
						}
						jteOutput.writeContent("\n                                    </div>\n                                ");
					}
					jteOutput.writeContent("\n                            ");
				}
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                    <aside>\n                        <div style=\"background:white;border:1px solid var(--border);border-radius:var(--radius-lg);padding:1.25rem;position:sticky;top:calc(var(--header-h) + 1rem)\">\n                            <h3 class=\"bellota-bold\" style=\"font-size:0.875rem;font-weight:700;text-transform:uppercase;letter-spacing:0.05em;color:var(--text-muted);margin-bottom:1rem\">О кабинете</h3>\n                            <div style=\"font-size:0.875rem\">\n                                <div style=\"display:flex;justify-content:space-between;padding:0.5rem 0;border-bottom:1px solid var(--border-light)\">\n                                    <span style=\"color:var(--text-muted)\">Название</span>\n                                    <span style=\"font-weight:600\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(classroom.getTitle());
				jteOutput.writeContent("</span>\n                                </div>\n                                <div style=\"display:flex;justify-content:space-between;padding:0.5rem 0\">\n                                    <span style=\"color:var(--text-muted)\">Материалов</span>\n                                    <span style=\"font-weight:600\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(classroom.getMaterials().size());
				jteOutput.writeContent("</span>\n                                </div>\n                            </div>\n                        </div>\n                    </aside>\n                </div>\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "classrooms");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Classroom classroom = (Classroom)params.get("classroom");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, classroom, currentUser, userRoles);
	}
}
