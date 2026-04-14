package gg.jte.generated.ondemand;
import gg.jte.Content;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,15,15,15,15,24,24,24,24,24,24,24,24,24,25,25,25,25,25,25,25,25,25,26,26,26,26,26,26,26,26,26,27,27,27,27,27,27,27,27,27,28,28,28,28,28,28,28,28,28,29,29,29,29,29,29,29,29,29,30,30,30,30,30,30,30,30,30,31,31,31,31,31,31,31,31,31,34,34,35,35,37,37,39,39,39,41,41,43,43,56,56,57,57,59,59,60,60,62,62,67,67,67,106,106,106,4,5,6,7,8,8,8,8};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content content, String currentUser, Set<Role> userRoles, String activePage) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent(" — Лицей №1</title>\n    <link rel=\"stylesheet\" href=\"/css/main.css\">\n</head>\n<body>\n\n<header class=\"site-header\">\n    <div class=\"header-inner\">\n        <a href=\"/\" class=\"site-logo\">Лицей <span>№1</span></a>\n        <nav class=\"site-nav\">\n            <a href=\"/\"");
		var __jte_html_attribute_0 = activePage.equals("home") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" class=\"");
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\n            <a href=\"/news\"");
		var __jte_html_attribute_1 = activePage.equals("news") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" class=\"");
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Новости</a>\n            <a href=\"/achievements\"");
		var __jte_html_attribute_2 = activePage.equals("achievements") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" class=\"");
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Достижения</a>\n            <a href=\"/portfolio\"");
		var __jte_html_attribute_3 = activePage.equals("portfolio") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
			jteOutput.writeContent(" class=\"");
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_3);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Портфолио</a>\n            <a href=\"/vacancies\"");
		var __jte_html_attribute_4 = activePage.equals("vacancies") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
			jteOutput.writeContent(" class=\"");
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_4);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Вакансии</a>\n            <a href=\"/museum\"");
		var __jte_html_attribute_5 = activePage.equals("museum") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
			jteOutput.writeContent(" class=\"");
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_5);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Музей</a>\n            <a href=\"/classrooms\"");
		var __jte_html_attribute_6 = activePage.equals("classrooms") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_6)) {
			jteOutput.writeContent(" class=\"");
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_6);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Кабинеты</a>\n            <a href=\"/admission\"");
		var __jte_html_attribute_7 = activePage.equals("admission") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_7)) {
			jteOutput.writeContent(" class=\"");
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_7);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Поступление</a>\n        </nav>\n        <div class=\"header-actions\">\n            ");
		if (currentUser != null) {
			jteOutput.writeContent("\n                ");
			if (userRoles != null && (userRoles.contains(Role.ROLE_ADMIN) || userRoles.contains(Role.ROLE_TEACHER))) {
				jteOutput.writeContent("\n                    <a href=\"/admin\" class=\"btn btn-accent btn-sm\">Панель</a>\n                ");
			}
			jteOutput.writeContent("\n                <form method=\"post\" action=\"/logout\" style=\"margin:0\">\n                    <button type=\"submit\" class=\"btn btn-outline-white btn-sm\">");
			jteOutput.setContext("button", null);
			jteOutput.writeUserContent(currentUser);
			jteOutput.writeContent("</button>\n                </form>\n            ");
		} else {
			jteOutput.writeContent("\n                <a href=\"/login\" class=\"btn btn-outline-white btn-sm\">Войти</a>\n            ");
		}
		jteOutput.writeContent("\n            <button class=\"menu-toggle\" onclick=\"document.getElementById('mobileNav').classList.toggle('open')\">☰</button>\n        </div>\n    </div>\n    <nav class=\"mobile-nav\" id=\"mobileNav\">\n        <a href=\"/\">Главная</a>\n        <a href=\"/news\">Новости</a>\n        <a href=\"/achievements\">Достижения</a>\n        <a href=\"/portfolio\">Портфолио</a>\n        <a href=\"/vacancies\">Вакансии</a>\n        <a href=\"/museum\">Музей</a>\n        <a href=\"/classrooms\">Кабинеты</a>\n        <a href=\"/admission\">Поступление</a>\n        ");
		if (currentUser != null) {
			jteOutput.writeContent("\n            ");
			if (userRoles != null && (userRoles.contains(Role.ROLE_ADMIN) || userRoles.contains(Role.ROLE_TEACHER))) {
				jteOutput.writeContent("\n                <a href=\"/admin\">Панель управления</a>\n            ");
			}
			jteOutput.writeContent("\n        ");
		} else {
			jteOutput.writeContent("\n            <a href=\"/login\">Войти</a>\n        ");
		}
		jteOutput.writeContent("\n    </nav>\n</header>\n\n<main class=\"main-content\">\n    ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</main>\n\n<footer class=\"site-footer\">\n    <div class=\"container\">\n        <div class=\"footer-grid\">\n            <div class=\"footer-col\">\n                <h4>Лицей №1</h4>\n                <p>Качественное образование для будущих лидеров</p>\n            </div>\n            <div class=\"footer-col\">\n                <h4>Разделы</h4>\n                <a href=\"/news\">Новости</a>\n                <a href=\"/achievements\">Достижения</a>\n                <a href=\"/museum\">Школьный музей</a>\n                <a href=\"/classrooms\">Учебные кабинеты</a>\n            </div>\n            <div class=\"footer-col\">\n                <h4>Информация</h4>\n                <a href=\"/vacancies\">Вакансии</a>\n                <a href=\"/admission\">Поступление</a>\n                <a href=\"/portfolio\">Портфолио</a>\n            </div>\n            <div class=\"footer-col\">\n                <h4>Контакты</h4>\n                <p>г. Москва, ул. Школьная, 1</p>\n                <p>+7 (495) 000-00-00</p>\n                <p>lyceum@school.ru</p>\n            </div>\n        </div>\n        <div class=\"footer-bottom\">\n            <span>© 2025 Лицей №1. Все права защищены.</span>\n            <span>Образование. Наука. Будущее.</span>\n        </div>\n    </div>\n</footer>\n\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		Content content = (Content)params.get("content");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		String activePage = (String)params.getOrDefault("activePage", "");
		render(jteOutput, jteHtmlInterceptor, title, content, currentUser, userRoles, activePage);
	}
}
