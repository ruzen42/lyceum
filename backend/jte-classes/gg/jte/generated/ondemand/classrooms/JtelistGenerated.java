package gg.jte.generated.ondemand.classrooms;
import com.jvmd.lyceum_backend.model.Classroom;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtelistGenerated {
	public static final String JTE_NAME = "classrooms/list.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,9,9,15,15,25,25,30,30,32,32,36,36,36,38,38,38,42,42,42,42,45,45,47,47,50,50,50,51,51,51,5,6,7,7,7,7};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Classroom> classrooms, String currentUser, Set<Role> userRoles) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Учебные кабинеты", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header\">\n            <div class=\"container\">\n                <h1>Учебные кабинеты</h1>\n                <p>Материалы, ресурсы и информация по каждому кабинету</p>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                ");
				if (classrooms.isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"empty-state\">\n                        <div class=\"empty-state-icon\">📚</div>\n                        <p>Кабинеты пока не добавлены</p>\n                    </div>\n                ");
				} else {
					jteOutput.writeContent("\n                    <div class=\"grid grid-3\">\n                        ");
					for (Classroom c : classrooms) {
						jteOutput.writeContent("\n                            <div class=\"card\">\n                                <div class=\"card-img-placeholder\" style=\"height:130px;font-size:3rem\">📚</div>\n                                <div class=\"card-body\">\n                                    <h3 class=\"card-title\">");
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(c.getTitle());
						jteOutput.writeContent("</h3>\n                                    <div class=\"card-meta\">\n                                        <span>📄 ");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(c.getMaterials().size());
						jteOutput.writeContent(" материалов</span>\n                                    </div>\n                                </div>\n                                <div class=\"card-footer\">\n                                    <a href=\"/classrooms/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(c.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\" class=\"btn btn-primary btn-sm\">Открыть</a>\n                                </div>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "classrooms");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Classroom> classrooms = (List<Classroom>)params.get("classrooms");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, classrooms, currentUser, userRoles);
	}
}
