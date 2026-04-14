package gg.jte.generated.ondemand;
import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.model.Achievement;
import com.jvmd.lyceum_backend.model.Role;
import com.jvmd.lyceum_backend.payload.SiteStatsResponse;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,7,7,7,7,13,13,19,19,35,35,35,39,39,39,43,43,43,47,47,47,60,60,65,65,67,67,69,69,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,71,71,73,73,75,75,76,76,76,77,77,78,78,78,79,79,79,81,81,82,82,82,83,83,84,84,84,88,88,90,90,100,100,105,105,107,107,110,110,110,110,111,111,111,113,113,113,114,114,114,114,114,114,115,115,115,117,117,117,121,121,123,123,151,151,151,152,152,152,7,8,9,10,11,11,11,11};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<News> recentNews, List<Achievement> recentAchievements, SiteStatsResponse stats, String currentUser, Set<Role> userRoles) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Главная", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <section class=\"hero\">\n            <div class=\"container bellota-bold\">\n                <h1>Добро пожаловать в <span>Первый IT лицей</span></h1>\n                <p>Хочешь быть первым, учись в первом.</p>\n                <div class=\"hero-actions bellota-bold\">\n                    <a href=\"/admission\" class=\"btn btn-accent btn-lg\">Подать заявку</a>\n                    <a href=\"/news\" class=\"btn btn-outline-white btn-lg\">Новости школы</a>\n                </div>\n            </div>\n        </section>\n\n        <section class=\"stats-bar bellota-bold\">\n            <div class=\"container\">\n                <div class=\"stats-grid\">\n                    <div class=\"stat-item\">\n                        <span class=\"stat-num\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(stats.getNewsCount());
				jteOutput.writeContent("</span>\n                        <span class=\"stat-label\">Публикаций</span>\n                    </div>\n                    <div class=\"stat-item\">\n                        <span class=\"stat-num\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(stats.getAchievementsCount());
				jteOutput.writeContent("</span>\n                        <span class=\"stat-label\">Достижений</span>\n                    </div>\n                    <div class=\"stat-item\">\n                        <span class=\"stat-num\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(stats.getPortfolioCount());
				jteOutput.writeContent("</span>\n                        <span class=\"stat-label\">Портфолио</span>\n                    </div>\n                    <div class=\"stat-item\">\n                        <span class=\"stat-num\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(stats.getApplicationsCount());
				jteOutput.writeContent("</span>\n                        <span class=\"stat-label\">Заявок</span>\n                    </div>\n                </div>\n            </div>\n        </section>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                <div class=\"section-header\">\n                    <h2 class=\"section-title\">Последние новости</h2>\n                    <a href=\"/news\" class=\"section-link\">Все новости →</a>\n                </div>\n                ");
				if (recentNews.isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"empty-state\">\n                        <div class=\"empty-state-icon\">📰</div>\n                        <p>Новостей пока нет</p>\n                    </div>\n                ");
				} else {
					jteOutput.writeContent("\n                    <div class=\"grid grid-3\">\n                        ");
					for (News news : recentNews) {
						jteOutput.writeContent("\n                            <div class=\"card\">\n                                ");
						if (news.getImageUrl() != null) {
							jteOutput.writeContent("\n                                    <img");
							var __jte_html_attribute_0 = news.getImageUrl();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeContent(" src=\"");
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							var __jte_html_attribute_1 = news.getTitle();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
								jteOutput.writeContent(" alt=\"");
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_1);
								jteOutput.setContext("img", null);
								jteOutput.writeContent("\"");
							}
							jteOutput.writeContent(" class=\"card-img\">\n                                ");
						} else {
							jteOutput.writeContent("\n                                    <div class=\"card-img-placeholder\">📰</div>\n                                ");
						}
						jteOutput.writeContent("\n                                <div class=\"card-body\">\n                                    ");
						if (news.getCategory() != null) {
							jteOutput.writeContent("\n                                        <span class=\"badge badge-secondary mb-1\">");
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(news.getCategory());
							jteOutput.writeContent("</span>\n                                    ");
						}
						jteOutput.writeContent("\n                                    <h3 class=\"card-title\">");
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(news.getTitle());
						jteOutput.writeContent("</h3>\n                                    <p class=\"card-text\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(news.getContent().length() > 120 ? news.getContent().substring(0, 120) + "..." : news.getContent());
						jteOutput.writeContent("</p>\n                                    <div class=\"card-meta\">\n                                        ");
						if (news.getUser() != null) {
							jteOutput.writeContent("\n                                            <span>✍ ");
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(news.getUser().getUsername());
							jteOutput.writeContent("</span>\n                                        ");
						}
						jteOutput.writeContent("\n                                        <span>");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(news.getCreatedAt().toLocalDate().toString());
						jteOutput.writeContent("</span>\n                                    </div>\n                                </div>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n\n        <section class=\"section section-alt\">\n            <div class=\"container\">\n                <div class=\"section-header\">\n                    <h2 class=\"section-title\">Достижения учеников</h2>\n                    <a href=\"/achievements\" class=\"section-link\">Все достижения →</a>\n                </div>\n                ");
				if (recentAchievements.isEmpty()) {
					jteOutput.writeContent("\n                    <div class=\"empty-state\">\n                        <div class=\"empty-state-icon\">🏆</div>\n                        <p>Достижений пока нет</p>\n                    </div>\n                ");
				} else {
					jteOutput.writeContent("\n                    <div class=\"grid grid-3\">\n                        ");
					for (Achievement a : recentAchievements) {
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
						jteOutput.writeContent("</h3>\n                                    <p class=\"card-text\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(a.getStudentName());
						jteOutput.writeContent(" · ");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(a.getYear());
						jteOutput.writeContent("</p>\n                                    <p class=\"card-text\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(a.getPlace());
						jteOutput.writeContent("</p>\n                                    <div class=\"card-meta\">\n                                        <span class=\"badge badge-primary\">");
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(a.getCategory());
						jteOutput.writeContent("</span>\n                                    </div>\n                                </div>\n                            </div>\n                        ");
					}
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            </div>\n        </section>\n\n        <section class=\"section\">\n            <div class=\"container\">\n                <div style=\"display:grid;grid-template-columns:repeat(auto-fit,minmax(280px,1fr));gap:1.5rem\">\n                    <div style=\"background:var(--primary);color:white;border-radius:var(--radius-lg);padding:2rem\">\n                        <div style=\"font-size:2rem;margin-bottom:0.75rem\">🏛️</div>\n                        <h3 style=\"font-size:1.2rem;margin-bottom:0.5rem\">Школьный музей</h3>\n                        <p style=\"color:rgba(255,255,255,0.75);font-size:0.875rem;margin-bottom:1rem\">Узнайте историю нашей школы через уникальные экспонаты и архивные материалы.</p>\n                        <a href=\"/museum\" class=\"btn btn-accent btn-sm\">Посетить музей</a>\n                    </div>\n                    <div style=\"background:var(--secondary);color:white;border-radius:var(--radius-lg);padding:2rem\">\n                        <div style=\"font-size:2rem;margin-bottom:0.75rem\">📚</div>\n                        <h3 style=\"font-size:1.2rem;margin-bottom:0.5rem\">Учебные кабинеты</h3>\n                        <p style=\"color:rgba(255,255,255,0.75);font-size:0.875rem;margin-bottom:1rem\">Доступ к материалам, ресурсам и расписанию учебных кабинетов школы.</p>\n                        <a href=\"/classrooms\" class=\"btn btn-outline-white btn-sm\">Смотреть кабинеты</a>\n                    </div>\n                    <div style=\"background:#2a9d8f;color:white;border-radius:var(--radius-lg);padding:2rem\">\n                        <div style=\"font-size:2rem;margin-bottom:0.75rem\">📋</div>\n                        <h3 style=\"font-size:1.2rem;margin-bottom:0.5rem\">Поступление</h3>\n                        <p style=\"color:rgba(255,255,255,0.75);font-size:0.875rem;margin-bottom:1rem\">Запишите ребёнка в наш лицей. Мы принимаем детей в 1 класс и дошкольную группу.</p>\n                        <a href=\"/admission\" class=\"btn btn-outline-white btn-sm\">Подать заявку</a>\n                    </div>\n                </div>\n            </div>\n        </section>\n    ");
			}
		}, currentUser, userRoles, "home");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<News> recentNews = (List<News>)params.get("recentNews");
		List<Achievement> recentAchievements = (List<Achievement>)params.get("recentAchievements");
		SiteStatsResponse stats = (SiteStatsResponse)params.get("stats");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, recentNews, recentAchievements, stats, currentUser, userRoles);
	}
}
