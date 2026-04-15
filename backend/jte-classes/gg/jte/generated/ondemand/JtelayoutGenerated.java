package gg.jte.generated.ondemand;
import gg.jte.Content;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,15,15,15,15,32,32,32,32,32,32,32,32,32,33,33,33,33,33,33,33,33,33,34,34,34,34,34,34,34,34,34,35,35,35,35,35,35,35,35,35,36,36,36,36,36,36,36,36,36,37,37,37,37,37,37,37,37,37,38,38,38,38,38,38,38,38,38,39,39,39,39,39,39,39,39,39,42,42,43,43,45,45,47,47,49,49,49,51,51,53,53,67,67,68,68,70,70,72,72,73,73,75,75,80,80,80,118,118,118,4,5,6,7,8,8,8,8};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content content, String currentUser, Set<Role> userRoles, String activePage) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent(" — Первый IT лицей</title>\n    <link rel=\"stylesheet\" href=\"/css/main.css\">\n    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n    <link href=\"https://fonts.googleapis.com/css2?family=Pacifico&display=swap\" rel=\"stylesheet\">\n    <link href=\"https://fonts.googleapis.com/css2?family=Bellota:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&display=swap\" rel=\"stylesheet\">\n    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n</head>\n<body>\n\n<header class=\"site-header\">\n    <div class=\"header-inner\">\n        <a href=\"/\" class=\"site-logo-wrapper\">\n            <img src=\"/img/icon.png\" alt=\"Lyceum Logo\" class=\"header-logo-img\">\n        </a>\n        <nav class=\"site-nav bellota-bold\">\n\n            <a href=\"/\"");
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
			} else if (userRoles != null && userRoles.contains(Role.ROLE_STUDENT)) {
				jteOutput.writeContent("\n                    <a href=\"/student/portfolio\" class=\"btn btn-accent btn-sm\">Моё портфолио</a>\n                ");
			}
			jteOutput.writeContent("\n                <form method=\"post\" action=\"/logout\" style=\"margin:0\">\n                    <button type=\"submit\" class=\"btn btn-outline-white btn-sm\">");
			jteOutput.setContext("button", null);
			jteOutput.writeUserContent(currentUser);
			jteOutput.writeContent("</button>\n                </form>\n            ");
		} else {
			jteOutput.writeContent("\n                <a href=\"/login\" class=\"btn btn-outline-white btn-sm\">Войти</a>\n            ");
		}
		jteOutput.writeContent("\n            <button class=\"menu-toggle\" onclick=\"document.getElementById('mobileNav').classList.toggle('open')\">☰\n            </button>\n        </div>\n    </div>\n    <nav class=\"mobile-nav\" id=\"mobileNav\">\n        <a href=\"/\">Главная</a>\n        <a href=\"/news\">Новости</a>\n        <a href=\"/achievements\">Достижения</a>\n        <a href=\"/portfolio\">Портфолио</a>\n        <a href=\"/vacancies\">Вакансии</a>\n        <a href=\"/museum\">Музей</a>\n        <a href=\"/classrooms\">Кабинеты</a>\n        <a href=\"/admission\">Поступление</a>\n        ");
		if (currentUser != null) {
			jteOutput.writeContent("\n            ");
			if (userRoles != null && (userRoles.contains(Role.ROLE_ADMIN) || userRoles.contains(Role.ROLE_TEACHER))) {
				jteOutput.writeContent("\n                <a href=\"/admin\">Панель управления</a>\n            ");
			} else if (userRoles != null && userRoles.contains(Role.ROLE_STUDENT)) {
				jteOutput.writeContent("\n                <a href=\"/student/portfolio\">Моё портфолио</a>\n            ");
			}
			jteOutput.writeContent("\n        ");
		} else {
			jteOutput.writeContent("\n            <a href=\"/login\">Войти</a>\n        ");
		}
		jteOutput.writeContent("\n    </nav>\n</header>\n\n<main class=\"main-content\">\n    ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</main>\n\n<footer class=\"site-footer\">\n    <div class=\"container\">\n        <div class=\"footer-grid\">\n            <div class=\"footer-col\">\n                <h4>Первый IT лицей</h4>\n                <p>Качественное образование для будущих лидеров</p>\n            </div>\n            <div class=\"footer-col\">\n                <h4>Разделы</h4>\n                <a href=\"/news\">Новости</a>\n                <a href=\"/achievements\">Достижения</a>\n                <a href=\"/museum\">Школьный музей</a>\n                <a href=\"/classrooms\">Учебные кабинеты</a>\n            </div>\n            <div class=\"footer-col\">\n                <h4>Информация</h4>\n                <a href=\"/vacancies\">Вакансии</a>\n                <a href=\"/admission\">Поступление</a>\n                <a href=\"/portfolio\">Портфолио</a>\n            </div>\n            <div class=\"footer-col\">\n                <h4>Контакты</h4>\n                <p>г. Петропавловск, ул. Жамбыла улица, 196</p>\n                <p>+7 705 101 7879</p>\n                <p>vakin83@list.ru</p>\n            </div>\n        </div>\n        <div class=\"footer-bottom\">\n            <span>© 2026 Первый IT лицей. Все права защищены.</span>\n        </div>\n    </div>\n</footer>\n\n</body>\n</html>\n");
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
