package gg.jte.generated.ondemand.auth;
@SuppressWarnings("unchecked")
public final class JteregisterGenerated {
	public static final String JTE_NAME = "auth/register.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,23,23,23,24,24,24,25,25,57,57,57,0,0,0,0};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String error) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Регистрация — Первый IT лицей</title>\n    <link rel=\"stylesheet\" href=\"/css/main.css\">\n</head>\n<body style=\"min-height:100vh;display:flex;flex-direction:column\">\n\n<header class=\"site-header\">\n    <div class=\"header-inner\">\n        <a href=\"/\" class=\"site-logo\">Лицей <span>№1</span></a>\n    </div>\n</header>\n\n<div class=\"auth-page\">\n    <div class=\"auth-card\">\n        <h1 class=\"bellota-bold\">Регистрация</h1>\n        <p class=\"subtitle\">Создайте аккаунт для доступа к порталу</p>\n\n        ");
		if (error != null) {
			jteOutput.writeContent("\n            <div class=\"alert alert-danger\">✗ ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(error);
			jteOutput.writeContent("</div>\n        ");
		}
		jteOutput.writeContent("\n\n        <form method=\"post\" action=\"/register\">\n            <div class=\"form-group\">\n                <label for=\"username\">Имя пользователя</label>\n                <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\" required autofocus\n                       minlength=\"3\" maxlength=\"50\" placeholder=\"от 3 до 50 символов\">\n            </div>\n            <div class=\"form-group\">\n                <label for=\"email\">Электронная почта</label>\n                <input type=\"email\" id=\"email\" name=\"email\" class=\"form-control\" required placeholder=\"example@mail.ru\">\n            </div>\n            <div class=\"form-group\">\n                <label for=\"password\">Пароль</label>\n                <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" required\n                       minlength=\"6\" placeholder=\"минимум 6 символов\">\n                <div class=\"form-hint\">Минимум 6 символов</div>\n            </div>\n            <button type=\"submit\" class=\"btn btn-primary w-100\" style=\"margin-top:0.5rem\">Зарегистрироваться</button>\n        </form>\n\n        <p style=\"text-align:center;margin-top:1.25rem;font-size:0.875rem;color:var(--text-muted)\">\n            Уже есть аккаунт? <a href=\"/login\">Войти</a>\n        </p>\n        <p style=\"text-align:center;margin-top:0.5rem;font-size:0.875rem\">\n            <a href=\"/\" style=\"color:var(--text-muted)\">← На главную</a>\n        </p>\n    </div>\n</div>\n\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String error = (String)params.getOrDefault("error", null);
		render(jteOutput, jteHtmlInterceptor, error);
	}
}
