package gg.jte.generated.ondemand;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteadmissionGenerated {
	public static final String JTE_NAME = "admission.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,8,8,14,14,24,24,26,26,26,28,28,29,29,31,31,31,33,33,93,93,93,94,94,94,3,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String currentUser, Set<Role> userRoles, String success, String error) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Поступление", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"page-header bellota-bold\">\n            <div class=\"container\">\n                <h1 class=\"bellota-bold\">Поступление в лицей</h1>\n                <p>Заполните заявку, и мы свяжемся с вами в течение 2–3 рабочих дней</p>\n            </div>\n        </div>\n\n        <section class=\"section\">\n            <div class=\"container\" style=\"max-width:700px\">\n                ");
				if (success != null) {
					jteOutput.writeContent("\n                    <div class=\"alert alert-success\">\n                        ✓ ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(success);
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n                ");
				if (error != null) {
					jteOutput.writeContent("\n                    <div class=\"alert alert-danger\">\n                        ✗ ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(error);
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n\n                <div class=\"admission-section\">\n                    <h2 class=\"bellota-bold\" style=\"font-size:1.25rem;font-weight:700;color:var(--primary);margin-bottom:1.5rem\">Заявка на поступление</h2>\n\n                    <form method=\"post\" action=\"/admission\">\n                        <h3 class=\"bellota-bold\" style=\"font-size:1rem;font-weight:700;color:var(--text-muted);text-transform:uppercase;letter-spacing:0.05em;margin-bottom:1rem\">Информация о родителе</h3>\n                        <div class=\"form-group\">\n                            <label for=\"parentName\">ФИО родителя / опекуна *</label>\n                            <input type=\"text\" id=\"parentName\" name=\"parentName\" class=\"form-control\" required placeholder=\"Иванов Иван Иванович\">\n                        </div>\n\n                        <hr class=\"divider\">\n                        <h3 class=\"bellota-bold\" style=\"font-size:1rem;font-weight:700;color:var(--text-muted);text-transform:uppercase;letter-spacing:0.05em;margin-bottom:1rem\">Информация о ребёнке</h3>\n\n                        <div class=\"form-row\">\n                            <div class=\"form-group\">\n                                <label for=\"childName\">ФИО ребёнка *</label>\n                                <input type=\"text\" id=\"childName\" name=\"childName\" class=\"form-control\" required placeholder=\"Иванов Пётр Иванович\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label for=\"childAge\">Возраст ребёнка *</label>\n                                <input type=\"number\" id=\"childAge\" name=\"childAge\" class=\"form-control\" required min=\"4\" max=\"18\" placeholder=\"7\">\n                            </div>\n                        </div>\n\n                        <div class=\"form-group\">\n                            <label for=\"classType\">Класс поступления *</label>\n                            <select id=\"classType\" name=\"classType\" class=\"form-control\" required>\n                                <option value=\"\">— Выберите —</option>\n                                <option value=\"1_CLASS\">1 класс</option>\n                                <option value=\"PRESCHOOL\">Дошкольная группа</option>\n                            </select>\n                        </div>\n\n                        <hr class=\"divider\">\n                        <h3 class=\"bellota-bold\" style=\"font-size:1rem;font-weight:700;color:var(--text-muted);text-transform:uppercase;letter-spacing:0.05em;margin-bottom:1rem\">Контактные данные</h3>\n\n                        <div class=\"form-row\">\n                            <div class=\"form-group\">\n                                <label for=\"phone\">Телефон *</label>\n                                <input type=\"tel\" id=\"phone\" name=\"phone\" class=\"form-control\" required placeholder=\"+7 (999) 000-00-00\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label for=\"email\">Электронная почта</label>\n                                <input type=\"email\" id=\"email\" name=\"email\" class=\"form-control\" placeholder=\"example@mail.ru\">\n                            </div>\n                        </div>\n\n                        <div class=\"form-group\">\n                            <label for=\"message\">Дополнительная информация</label>\n                            <textarea id=\"message\" name=\"message\" class=\"form-control\" rows=\"4\" placeholder=\"Укажите любую важную информацию о ребёнке, вопросы и пожелания...\"></textarea>\n                        </div>\n\n                        <button type=\"submit\" class=\"btn btn-primary btn-lg w-100\">Отправить заявку</button>\n                        <p class=\"form-hint text-center mt-2\">Нажимая кнопку, вы соглашаетесь на обработку персональных данных</p>\n                    </form>\n                </div>\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "admission");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		String success = (String)params.getOrDefault("success", null);
		String error = (String)params.getOrDefault("error", null);
		render(jteOutput, jteHtmlInterceptor, currentUser, userRoles, success, error);
	}
}
