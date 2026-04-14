package gg.jte.generated.ondemand.admin;
import com.jvmd.lyceum_backend.model.AdmissionApplication;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtedashboardGenerated {
	public static final String JTE_NAME = "admin/dashboard.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,13,13,19,19,23,23,29,29,30,30,35,35,43,43,43,44,44,46,46,48,48,53,53,54,54,54,55,55,56,56,57,57,57,58,58,60,60,123,159,180,207,207,209,209,210,210,210,210,210,210,210,210,210,236,239,239,244,244,259,259,262,262,262,263,263,264,264,264,265,265,267,267,267,268,268,268,269,269,269,270,270,270,272,272,272,272,273,273,273,276,276,276,278,278,282,282,284,284,296,300,300,300,301,301,301,5,6,7,8,9,10,11,11,11,11};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String currentUser, Set<Role> userRoles, List<AdmissionApplication> applications, String success, String error, boolean isAdmin, boolean isTeacher) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Панель управления", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"admin-layout\">\n            <aside class=\"admin-sidebar\">\n                <h3 class=\"bellota-bold\">Контент</h3>\n                ");
				if (isTeacher) {
					jteOutput.writeContent("\n                    <a href=\"#news\" onclick=\"showTab('news',this);return false\">📰 Новости</a>\n                    <a href=\"#achievements\" onclick=\"showTab('achievements',this);return false\">🏆 Достижения</a>\n                    <a href=\"#portfolio\" onclick=\"showTab('portfolio',this);return false\">👤 Портфолио</a>\n                    <a href=\"#museum\" onclick=\"showTab('museum',this);return false\">🏛️ Музей</a>\n                    <a href=\"#materials\" onclick=\"showTab('materials',this);return false\">📄 Материалы</a>\n                ");
				}
				jteOutput.writeContent("\n                ");
				if (isAdmin) {
					jteOutput.writeContent("\n                    <h3 class=\"bellota-bold\">Управление</h3>\n                    <a href=\"#vacancies\" onclick=\"showTab('vacancies',this);return false\">💼 Вакансии</a>\n                    <a href=\"#classrooms\" onclick=\"showTab('classrooms',this);return false\">📚 Кабинеты</a>\n                    <a href=\"#admissions\" onclick=\"showTab('admissions',this);return false\">📋 Заявки</a>\n                ");
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
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-news\">\n                        <h2 class=\"bellota-bold\">📰 Добавить новость</h2>\n                        <form method=\"post\" action=\"/admin/news\" enctype=\"multipart/form-data\">\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Заголовок *</label>\n                                    <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Заголовок новости\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Изображение</label>\n                                    <input type=\"file\" name=\"image\" class=\"form-control\" accept=\"image/*\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Содержание *</label>\n                                <textarea name=\"content\" class=\"form-control\" rows=\"5\" required placeholder=\"Текст новости...\"></textarea>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Опубликовать новость</button>\n                        </form>\n                    </div>\n\n                    <div class=\"admin-section\" id=\"tab-achievements\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\">🏆 Добавить достижение</h2>\n                        <form method=\"post\" action=\"/admin/achievements\">\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Название *</label>\n                                    <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Название достижения\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Имя ученика *</label>\n                                    <input type=\"text\" name=\"studentName\" class=\"form-control\" required placeholder=\"Иванов Иван\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Описание *</label>\n                                <textarea name=\"description\" class=\"form-control\" rows=\"3\" required placeholder=\"Описание достижения\"></textarea>\n                            </div>\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Категория *</label>\n                                    <input type=\"text\" name=\"category\" class=\"form-control\" required placeholder=\"Математика, Физика...\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Год *</label>\n                                    <input type=\"number\" name=\"year\" class=\"form-control\" required placeholder=\"2025\" min=\"2000\" max=\"2100\">\n                                </div>\n                            </div>\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Место проведения *</label>\n                                    <input type=\"text\" name=\"place\" class=\"form-control\" required placeholder=\"Москва, МГУ...\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Уровень / Место *</label>\n                                    <input type=\"text\" name=\"level\" class=\"form-control\" required placeholder=\"1 место, Золото...\">\n                                </div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить достижение</button>\n                        </form>\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-portfolio\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\">👤 Добавить портфолио</h2>\n                        <form method=\"post\" action=\"/admin/portfolio\" enctype=\"multipart/form-data\">\n                            <div class=\"form-row\">\n                                <div class=\"form-group\">\n                                    <label>Имя студента *</label>\n                                    <input type=\"text\" name=\"studentName\" class=\"form-control\" required placeholder=\"Иванов Иван\">\n                                </div>\n                                <div class=\"form-group\">\n                                    <label>Класс *</label>\n                                    <input type=\"text\" name=\"grade\" class=\"form-control\" required placeholder=\"11А\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Биография *</label>\n                                <textarea name=\"bio\" class=\"form-control\" rows=\"3\" required placeholder=\"Краткое описание студента...\"></textarea>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Фото</label>\n                                <input type=\"file\" name=\"image\" class=\"form-control\" accept=\"image/*\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Навыки (через запятую) *</label>\n                                <input type=\"text\" name=\"skillsRaw\" class=\"form-control\" required placeholder=\"Математика, Программирование, Физика\">\n                                <div class=\"form-hint\">Введите навыки через запятую</div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Достижения (через запятую) *</label>\n                                <input type=\"text\" name=\"achievementsRaw\" class=\"form-control\" required placeholder=\"Победитель олимпиады, 1 место на конкурсе\">\n                                <div class=\"form-hint\">Введите достижения через запятую</div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить портфолио</button>\n                        </form>\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-museum\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\">🏛️ Добавить экспонат</h2>\n                        <form method=\"post\" action=\"/admin/museum\" enctype=\"multipart/form-data\">\n                            <div class=\"form-group\">\n                                <label>Название *</label>\n                                <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Название экспоната\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Описание *</label>\n                                <textarea name=\"description\" class=\"form-control\" rows=\"4\" required placeholder=\"Описание экспоната...\"></textarea>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Фотографии</label>\n                                <input type=\"file\" name=\"images\" class=\"form-control\" accept=\"image/*\" multiple>\n                                <div class=\"form-hint\">Можно выбрать несколько файлов</div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить экспонат</button>\n                        </form>\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-materials\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\">📄 Добавить материал в кабинет</h2>\n                        <form method=\"post\" action=\"/admin/materials\" enctype=\"multipart/form-data\">\n                            <div class=\"form-group\">\n                                <label>ID кабинета *</label>\n                                <input type=\"number\" name=\"classroomId\" class=\"form-control\" required placeholder=\"Введите ID кабинета\">\n                                <div class=\"form-hint\">\n                                    Найдите ID кабинета на <a href=\"/classrooms\">странице кабинетов</a>\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Название материала *</label>\n                                <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Название материала\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Описание</label>\n                                <textarea name=\"description\" class=\"form-control\" rows=\"3\" placeholder=\"Описание материала...\"></textarea>\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Файлы</label>\n                                <input type=\"file\" name=\"files\" class=\"form-control\" multiple>\n                                <div class=\"form-hint\">Можно выбрать несколько файлов</div>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить материал</button>\n                        </form>\n                    </div>\n                ");
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
					jteOutput.writeContent(">\n                        <h2 class=\"bellota-bold\">💼 Управление вакансиями</h2>\n                        <form method=\"post\" action=\"/admin/vacancies\" style=\"margin-bottom:1.5rem\">\n                            <div class=\"form-group\">\n                                <label>Название вакансии *</label>\n                                <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Учитель математики\">\n                            </div>\n                            <div class=\"form-group\">\n                                <label>Описание</label>\n                                <textarea name=\"description\" class=\"form-control\" rows=\"3\" placeholder=\"Требования и условия...\"></textarea>\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Добавить вакансию</button>\n                        </form>\n                    </div>\n\n                    <div class=\"admin-section\" id=\"tab-classrooms\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\">📚 Создать кабинет</h2>\n                        <form method=\"post\" action=\"/admin/classrooms\">\n                            <div class=\"form-group\">\n                                <label>Название кабинета *</label>\n                                <input type=\"text\" name=\"title\" class=\"form-control\" required placeholder=\"Кабинет математики №24\">\n                            </div>\n                            <button type=\"submit\" class=\"btn btn-primary\">Создать кабинет</button>\n                        </form>\n                    </div>\n\n                    ");
					jteOutput.writeContent("\n                    <div class=\"admin-section\" id=\"tab-admissions\" style=\"display:none\">\n                        <h2 class=\"bellota-bold\">📋 Заявки на поступление</h2>\n                        ");
					if (applications == null || applications.isEmpty()) {
						jteOutput.writeContent("\n                            <div class=\"empty-state\" style=\"padding:1.5rem 0\">\n                                <div class=\"empty-state-icon\">📋</div>\n                                <p>Заявок пока нет</p>\n                            </div>\n                        ");
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
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </div>\n\n        <script>\n        function showTab(tabName, link) {\n            document.querySelectorAll('[id^=\"tab-\"]').forEach(el => el.style.display = 'none');\n            const tab = document.getElementById('tab-' + tabName);\n            if (tab) tab.style.display = 'block';\n            document.querySelectorAll('.admin-sidebar a').forEach(a => a.classList.remove('active'));\n            if (link) link.classList.add('active');\n        }\n        ");
				jteOutput.writeContent("\n        const firstLink = document.querySelector('.admin-sidebar a');\n        if (firstLink) firstLink.classList.add('active');\n        </script>\n    ");
			}
		}, currentUser, userRoles, "");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String currentUser = (String)params.get("currentUser");
		Set<Role> userRoles = (Set<Role>)params.get("userRoles");
		List<AdmissionApplication> applications = (List<AdmissionApplication>)params.getOrDefault("applications", null);
		String success = (String)params.getOrDefault("success", null);
		String error = (String)params.getOrDefault("error", null);
		boolean isAdmin = (boolean)params.getOrDefault("isAdmin", false);
		boolean isTeacher = (boolean)params.getOrDefault("isTeacher", false);
		render(jteOutput, jteHtmlInterceptor, currentUser, userRoles, applications, success, error, isAdmin, isTeacher);
	}
}
