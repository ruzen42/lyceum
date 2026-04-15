package gg.jte.generated.ondemand.admin;
import com.jvmd.lyceum_backend.model.AdmissionApplication;
import com.jvmd.lyceum_backend.model.Role;
import com.jvmd.lyceum_backend.model.User;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtedashboardGenerated {
	public static final String JTE_NAME = "admin/dashboard.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,6,15,15,21,21,25,25,31,31,32,32,38,38,46,46,46,47,47,49,49,51,51,56,56,57,57,57,58,58,59,59,60,60,60,61,61,63,63,126,149,170,197,197,199,199,200,200,200,200,200,200,200,200,200,226,229,229,234,234,249,249,252,252,252,253,253,254,254,254,255,255,257,257,257,258,258,258,259,259,259,260,260,260,262,262,262,262,263,263,263,266,266,266,268,268,272,272,275,307,307,311,311,322,322,324,324,324,325,325,325,327,327,328,328,328,328,329,329,329,331,331,334,334,338,338,340,340,361,361,361,362,362,362,6,7,8,9,10,11,12,13,13,13,13};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String currentUser, Set<Role> userRoles, List<AdmissionApplication> applications, List<User> users, String success, String error, boolean isAdmin, boolean isTeacher) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Панель управления", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"admin-layout\">\n            <aside class=\"admin-sidebar\">\n                <h3 class=\"bellota-bold\">Контент</h3>\n                ");
				if (isTeacher) {
					jteOutput.writeContent("\n                    <a href=\"#news\" onclick=\"showTab('news',this);return false\"><span class=\"material-icons\">article</span> Новости</a>\n                    <a href=\"#achievements\" onclick=\"showTab('achievements',this);return false\"><span class=\"material-icons\">emoji_events</span> Достижения</a>\n                    <a href=\"#portfolio\" onclick=\"showTab('portfolio',this);return false\"><span class=\"material-icons\">person</span> Портфолио</a>\n                    <a href=\"#museum\" onclick=\"showTab('museum',this);return false\"><span class=\"material-icons\">museum</span> Музей</a>\n                    <a href=\"#materials\" onclick=\"showTab('materials',this);return false\"><span class=\"material-icons\">description</span> Материалы</a>\n                ");
				}
				jteOutput.writeContent("\n                ");
				if (isAdmin) {
					jteOutput.writeContent("\n                    <h3 class=\"bellota-bold\">Управление</h3>\n                    <a href=\"#vacancies\" onclick=\"showTab('vacancies',this);return false\"><span class=\"material-icons\">work</span> Вакансии</a>\n                    <a href=\"#classrooms\" onclick=\"showTab('classrooms',this);return false\"><span class=\"material-icons\">menu_book</span> Кабинеты</a>\n                    <a href=\"#admissions\" onclick=\"showTab('admissions',this);return false\"><span class=\"material-icons\">assignment</span> Заявки</a>\n                    <a href=\"#users\" onclick=\"showTab('users',this);return false\"><span class=\"material-icons\">group</span> Пользователи</a>\n                ");
				}
				jteOutput.writeContent("\n            </aside>\n\n            <div class=\"admin-main\">\n                <div style=\"display:flex;align-items:center;justify-content:space-between;margin-bottom:1.5rem\">\n                    <h1 class=\"bellota-bold\" style=\"font-size:1.5rem;font-weight:800;color:var(--primary)\">Панель управления</h1>\n                    <div>\n                        <span style=\"font-size:0.875rem;color:var(--text-muted)\">\n                            ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(currentUser);
				jteOutput.writeContent("\n                            ");
				if (isAdmin) {
					jteOutput.writeContent("\n                                · <span class=\"badge badge-danger\">Администратор</span>\n                            ");
				} else if (isTeacher) {
					jteOutput.writeContent("\n                                · <span class=\"badge badge-secondary\">Учитель</span>\n                            ");
				}
				jteOutput.writeContent("\n                        </span>\n                    </div>\n                </div>\n\n                ");
				if (success != null) {
					jteOutput.writeContent("\n                    <div class=\"alert alert-success\">✓ ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(success);
					jteOutput.writeContent("</div>\n                ");
				}
				jteOutput.writeContent("\n                ");
				if (error != null) {
					jteOutput.writeContent("\n                    <div class=\"alert alert-danger\">✗ ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(error);
					jteOutput.writeContent("</div>\n                ");
				}
				jteOutput.writeContent("\n\n                ");
				if (isTeacher) {
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-news\">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">article</span> Добавить новость</h2>\n                        <form method=\"post\" action=\"/admin/news\" enctype=\"multipart/form-data\">\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Заголовок *</label>\n                                    <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Заголовок новости\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Изображение</label>\n                                    <input type=\"file\" name=\"image\" class=\"form-control\" accept=\"image/*\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Содержание *</label>\n                                <textarea name=\"content\" class=\"form-control\" rows=\"5\" required placeholder=\"Текст новости...\"></textarea>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Опубликовать новость</button>\n                        </form>\n                    </div>\n\n                    <div class=\"admin-section\" id=\"tab-achievements\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">emoji_events</span> Добавить достижение</h2>\n                        <form method=\"post\" action=\"/admin/achievements\">\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Название *</label>\n                                    <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Название достижения\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Имя ученика *</label>\n                                    <input type=\"text\" name=\"studentName\" class=\"form-control\" required placeholder=\"Иванов Иван\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Описание *</label>\n                                <textarea name=\"description\" class=\"form-control\" rows=\"3\" required placeholder=\"Описание достижения\"></textarea>\n                            </div>\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Категория *</label>\n                                    <input type=\"text\" name=\"category\" class=\"form-control\" required placeholder=\"Математика, Физика...\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Год *</label>\n                                    <input type=\"number\" name=\"year\" class=\"form-control\" required placeholder=\"2025\" min=\"2000\" max=\"2100\">\n                                </div>\n                            </div>\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Место проведения *</label>\n                                    <input type=\"text\" name=\"place\" class=\"form-control\" required placeholder=\"Москва, МГУ...\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Уровень / Место *</label>\n                                    <input type=\"text\" name=\"level\" class=\"form-control\" required placeholder=\"1 место, Золото...\">\n                                </div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить достижение</button>\n                        </form>\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-portfolio\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">person</span> Добавить портфолио</h2>\n                        <form method=\"post\" action=\"/admin/portfolio\" enctype=\"multipart/form-data\">\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Имя студента *</label>\n                                    <input type=\"text\" name=\"studentName\" class=\"form-control\" required placeholder=\"Иванов Иван\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Класс *</label>\n                                    <input type=\"text\" name=\"grade\" class=\"form-control\" required placeholder=\"11А\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Файл портфолио (.docx) *</label>\n                                <input type=\"file\" name=\"file\" class=\"form-control\" accept=\".docx\" required>\n                                <div class=\"form-hint\">Только файлы в формате .docx</div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить портфолио</button>\n                        </form>\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-museum\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">museum</span> Добавить экспонат</h2>\n                        <form method=\"post\" action=\"/admin/museum\" enctype=\"multipart/form-data\">\n                            <div class=\"form-group\">\n                                <label>Название *</label>\n                                <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Название экспоната\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Описание *</label>\n                                <textarea name=\"description\" class=\"form-control\" rows=\"4\" required placeholder=\"Описание экспоната...\"></textarea>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Фотографии</label>\n                                <input type=\"file\" name=\"images\" class=\"form-control\" accept=\"image/*\" multiple>\n                                <div class=\"form-hint\">Можно выбрать несколько файлов</div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить экспонат</button>\n                        </form>\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-materials\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">description</span> Добавить материал в кабинет</h2>\n                        <form method=\"post\" action=\"/admin/materials\" enctype=\"multipart/form-data\">\n                            <div class=\"form-group\">\n                                <label>ID кабинета *</label>\n                                <input type=\"number\" name=\"classroomId\" class=\"form-control\" required placeholder=\"Введите ID кабинета\">\n                                <div class=\"form-hint\">\n                                    Найдите ID кабинета на <a href=\"/classrooms\">странице кабинетов</a>\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Название материала *</label>\n                                <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Название материала\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Описание</label>\n                                <textarea name=\"description\" class=\"form-control\" rows=\"3\" placeholder=\"Описание материала...\"></textarea>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Файлы</label>\n                                <input type=\"file\" name=\"files\" class=\"form-control\" multiple>\n                                <div class=\"form-hint\">Можно выбрать несколько файлов</div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить материал</button>\n                        </form>\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n\n                ");
				if (isAdmin) {
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-vacancies\"");
					var __jte_html_attribute_0 = isTeacher ? "display:none" : "";
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" style=\"");
						jteOutput.setContext("div", "style");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("div", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">work</span> Управление вакансиями</h2>\n                        <form method=\"post\" action=\"/admin/vacancies\" style=\"margin-bottom:1.5rem\">\n                            <div class=\"form-group\">\n                                <label>Название вакансии *</label>\n                                <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Учитель математики\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Описание</label>\n                                <textarea name=\"description\" class=\"form-control\" rows=\"3\" placeholder=\"Требования и условия...\"></textarea>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить вакансию</button>\n                        </form>\n                    </div>\n\n                    <div class=\"admin-section\" id=\"tab-classrooms\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">menu_book</span> Создать кабинет</h2>\n                        <form method=\"post\" action=\"/admin/classrooms\">\n                            <div class=\"form-group\">\n                                <label>Название кабинета *</label>\n                                <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Кабинет математики №24\">\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Создать кабинет</button>\n                        </form>\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-admissions\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">assignment</span> Заявки на поступление</h2>\n                        ");
					if (applications == null || applications.isEmpty()) {
						jteOutput.writeContent("\n                            <div class=\"empty-state\" style=\"padding:1.5rem 0\">\n                                <div class=\"empty-state-icon\"><span class=\"material-icons\" style=\"font-size:3rem\">assignment</span></div>\n                                <p>Заявок пока нет</p>\n                            </div>\n                        ");
					} else {
						jteOutput.writeContent("\n                            <div class=\"table-wrap\">\n                                <table>\n                                    <thead>\n                                        <tr>\n                                            <th>Родитель</th>\n                                            <th>Ребёнок</th>\n                                            <th>Возраст</th>\n                                            <th>Класс</th>\n                                            <th>Телефон</th>\n                                            <th>Статус</th>\n                                            <th>Дата</th>\n                                        </tr>\n                                    </thead>\n                                    <tbody>\n                                        ");
						for (AdmissionApplication app : applications) {
							jteOutput.writeContent("\n                                            <tr>\n                                                <td>\n                                                    <strong>");
							jteOutput.setContext("strong", null);
							jteOutput.writeUserContent(app.getParentName());
							jteOutput.writeContent("</strong>\n                                                    ");
							if (app.getEmail() != null) {
								jteOutput.writeContent("\n                                                        <br><small style=\"color:var(--text-muted)\">");
								jteOutput.setContext("small", null);
								jteOutput.writeUserContent(app.getEmail());
								jteOutput.writeContent("</small>\n                                                    ");
							}
							jteOutput.writeContent("\n                                                </td>\n                                                <td>");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(app.getChildName());
							jteOutput.writeContent("</td>\n                                                <td>");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(app.getChildAge());
							jteOutput.writeContent("</td>\n                                                <td>");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(app.getClassType().equals("1_CLASS") ? "1 класс" : "Дошкольная");
							jteOutput.writeContent("</td>\n                                                <td>");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(app.getPhone());
							jteOutput.writeContent("</td>\n                                                <td>\n                                                    <span class=\"badge ");
							jteOutput.setContext("span", "class");
							jteOutput.writeUserContent(app.getStatus() == AdmissionApplication.ApplicationStatus.PENDING ? "status-pending" : app.getStatus() == AdmissionApplication.ApplicationStatus.REVIEWED ? "status-reviewed" : "status-rejected");
							jteOutput.setContext("span", null);
							jteOutput.writeContent("\">\n                                                        ");
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(app.getStatus() == AdmissionApplication.ApplicationStatus.PENDING ? "Ожидает" : app.getStatus() == AdmissionApplication.ApplicationStatus.REVIEWED ? "Рассмотрено" : "Отклонено");
							jteOutput.writeContent("\n                                                    </span>\n                                                </td>\n                                                <td style=\"font-size:0.8rem\">");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(app.getCreatedAt().toLocalDate().toString());
							jteOutput.writeContent("</td>\n                                            </tr>\n                                        ");
						}
						jteOutput.writeContent("\n                                    </tbody>\n                                </table>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-users\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\"><span class=\"material-icons\">group</span> Создать аккаунт</h2>\n                        <form method=\"post\" action=\"/admin/users\" style=\"margin-bottom:2rem\">\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Имя пользователя *</label>\n                                    <input type=\"text\" name=\"username\" class=\"form-control\" required placeholder=\"ivanov_ivan\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Email *</label>\n                                    <input type=\"email\" name=\"email\" class=\"form-control\" required placeholder=\"ivan@lyceum.kz\">\n                                </div>\n                            </div>\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Пароль *</label>\n                                    <input type=\"password\" name=\"password\" class=\"form-control\" required placeholder=\"Минимум 6 символов\" minlength=\"6\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Роль *</label>\n                                    <select name=\"role\" class=\"form-control\" required>\n                                        <option value=\"STUDENT\">Ученик</option>\n                                        <option value=\"TEACHER\">Учитель</option>\n                                        <option value=\"ADMIN\">Администратор</option>\n                                    </select>\n                                </div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Создать аккаунт</button>\n                        </form>\n\n                        <h3 class=\"bellota-bold\" style=\"font-size:1rem;margin-bottom:1rem\">Все пользователи</h3>\n                        ");
					if (users == null || users.isEmpty()) {
						jteOutput.writeContent("\n                            <div class=\"empty-state\" style=\"padding:1rem 0\">\n                                <p style=\"color:var(--text-muted)\">Пользователей пока нет</p>\n                            </div>\n                        ");
					} else {
						jteOutput.writeContent("\n                            <div class=\"table-wrap\">\n                                <table>\n                                    <thead>\n                                        <tr>\n                                            <th>Имя пользователя</th>\n                                            <th>Email</th>\n                                            <th>Роли</th>\n                                        </tr>\n                                    </thead>\n                                    <tbody>\n                                        ");
						for (User u : users) {
							jteOutput.writeContent("\n                                            <tr>\n                                                <td><strong>");
							jteOutput.setContext("strong", null);
							jteOutput.writeUserContent(u.getUsername());
							jteOutput.writeContent("</strong></td>\n                                                <td style=\"color:var(--text-muted)\">");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(u.getEmail());
							jteOutput.writeContent("</td>\n                                                <td>\n                                                    ");
							for (Role r : u.getRoles()) {
								jteOutput.writeContent("\n                                                        <span class=\"badge ");
								jteOutput.setContext("span", "class");
								jteOutput.writeUserContent(r == Role.ROLE_ADMIN ? "badge-danger" : r == Role.ROLE_TEACHER ? "badge-secondary" : r == Role.ROLE_STUDENT ? "badge-primary" : "");
								jteOutput.setContext("span", null);
								jteOutput.writeContent("\">\n                                                            ");
								jteOutput.setContext("span", null);
								jteOutput.writeUserContent(r == Role.ROLE_ADMIN ? "Админ" : r == Role.ROLE_TEACHER ? "Учитель" : r == Role.ROLE_STUDENT ? "Ученик" : "Пользователь");
								jteOutput.writeContent("\n                                                        </span>\n                                                    ");
							}
							jteOutput.writeContent("\n                                                </td>\n                                            </tr>\n                                        ");
						}
						jteOutput.writeContent("\n                                    </tbody>\n                                </table>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </div>\n\n        <style>\n            .admin-sidebar a { display: flex; align-items: center; gap: 0.5rem; }\n            .admin-sidebar a .material-icons { font-size: 1.1rem; }\n            .admin-section h2 .material-icons { font-size: 1.2rem; vertical-align: middle; margin-right: 0.25rem; }\n        </style>\n\n        <script>\n        function showTab(tabName, link) {\n            document.querySelectorAll('[id^=\"tab-\"]').forEach(el => el.style.display = 'none');\n            const tab = document.getElementById('tab-' + tabName);\n            if (tab) tab.style.display = 'block';\n            document.querySelectorAll('.admin-sidebar a').forEach(a => a.classList.remove('active'));\n            if (link) link.classList.add('active');\n        }\n        const firstLink = document.querySelector('.admin-sidebar a');\n        if (firstLink) firstLink.classList.add('active');\n        </script>\n    ");
			}
		}, currentUser, userRoles, "");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String currentUser = (String)params.get("currentUser");
		Set<Role> userRoles = (Set<Role>)params.get("userRoles");
		List<AdmissionApplication> applications = (List<AdmissionApplication>)params.getOrDefault("applications", null);
		List<User> users = (List<User>)params.getOrDefault("users", null);
		String success = (String)params.getOrDefault("success", null);
		String error = (String)params.getOrDefault("error", null);
		boolean isAdmin = (boolean)params.getOrDefault("isAdmin", false);
		boolean isTeacher = (boolean)params.getOrDefault("isTeacher", false);
		render(jteOutput, jteHtmlInterceptor, currentUser, userRoles, applications, users, success, error, isAdmin, isTeacher);
	}
}
