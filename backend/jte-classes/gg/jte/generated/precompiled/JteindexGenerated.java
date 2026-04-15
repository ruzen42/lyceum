package gg.jte.generated.precompiled;
import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.model.Achievement;
import com.jvmd.lyceum_backend.model.Role;
import com.jvmd.lyceum_backend.payload.SiteStatsResponse;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,13,13,19,19,35,35,35,39,39,39,43,43,43,47,47,47,60,60,65,65,67,67,69,69,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,71,71,73,73,75,75,76,76,76,77,77,78,78,78,79,79,79,81,81,82,82,82,83,83,84,84,84,88,88,90,90,100,100,105,105,107,107,110,110,110,110,111,111,111,113,113,113,114,114,114,114,114,114,115,115,115,117,117,117,121,121,123,123,151,151,151,152,152,152,7,8,9,10,11,11,11,11};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteindexGenerated.class, "JteindexGenerated.bin", 1,817,203,203,201,518,219,71,80,41,6,1,6,1,51,114,93,82,44,73,63,105,55,48,47,149,44,409,223,71,187,43,116,63,4,62,139,149,44,2417,1);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	private static final byte[] TEXT_PART_BINARY_9 = BINARY_CONTENT.get(9);
	private static final byte[] TEXT_PART_BINARY_10 = BINARY_CONTENT.get(10);
	private static final byte[] TEXT_PART_BINARY_11 = BINARY_CONTENT.get(11);
	private static final byte[] TEXT_PART_BINARY_12 = BINARY_CONTENT.get(12);
	private static final byte[] TEXT_PART_BINARY_13 = BINARY_CONTENT.get(13);
	private static final byte[] TEXT_PART_BINARY_14 = BINARY_CONTENT.get(14);
	private static final byte[] TEXT_PART_BINARY_15 = BINARY_CONTENT.get(15);
	private static final byte[] TEXT_PART_BINARY_16 = BINARY_CONTENT.get(16);
	private static final byte[] TEXT_PART_BINARY_17 = BINARY_CONTENT.get(17);
	private static final byte[] TEXT_PART_BINARY_18 = BINARY_CONTENT.get(18);
	private static final byte[] TEXT_PART_BINARY_19 = BINARY_CONTENT.get(19);
	private static final byte[] TEXT_PART_BINARY_20 = BINARY_CONTENT.get(20);
	private static final byte[] TEXT_PART_BINARY_21 = BINARY_CONTENT.get(21);
	private static final byte[] TEXT_PART_BINARY_22 = BINARY_CONTENT.get(22);
	private static final byte[] TEXT_PART_BINARY_23 = BINARY_CONTENT.get(23);
	private static final byte[] TEXT_PART_BINARY_24 = BINARY_CONTENT.get(24);
	private static final byte[] TEXT_PART_BINARY_25 = BINARY_CONTENT.get(25);
	private static final byte[] TEXT_PART_BINARY_26 = BINARY_CONTENT.get(26);
	private static final byte[] TEXT_PART_BINARY_27 = BINARY_CONTENT.get(27);
	private static final byte[] TEXT_PART_BINARY_28 = BINARY_CONTENT.get(28);
	private static final byte[] TEXT_PART_BINARY_29 = BINARY_CONTENT.get(29);
	private static final byte[] TEXT_PART_BINARY_30 = BINARY_CONTENT.get(30);
	private static final byte[] TEXT_PART_BINARY_31 = BINARY_CONTENT.get(31);
	private static final byte[] TEXT_PART_BINARY_32 = BINARY_CONTENT.get(32);
	private static final byte[] TEXT_PART_BINARY_33 = BINARY_CONTENT.get(33);
	private static final byte[] TEXT_PART_BINARY_34 = BINARY_CONTENT.get(34);
	private static final byte[] TEXT_PART_BINARY_35 = BINARY_CONTENT.get(35);
	private static final byte[] TEXT_PART_BINARY_36 = BINARY_CONTENT.get(36);
	private static final byte[] TEXT_PART_BINARY_37 = BINARY_CONTENT.get(37);
	private static final byte[] TEXT_PART_BINARY_38 = BINARY_CONTENT.get(38);
	private static final byte[] TEXT_PART_BINARY_39 = BINARY_CONTENT.get(39);
	private static final byte[] TEXT_PART_BINARY_40 = BINARY_CONTENT.get(40);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<News> recentNews, List<Achievement> recentAchievements, SiteStatsResponse stats, String currentUser, Set<Role> userRoles) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Главная", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(stats.getNewsCount());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(stats.getAchievementsCount());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(stats.getPortfolioCount());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(stats.getApplicationsCount());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				if (recentNews.isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
					for (News news : recentNews) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
						if (news.getImageUrl() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
							var __jte_html_attribute_0 = news.getImageUrl();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("img", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
							}
							var __jte_html_attribute_1 = news.getTitle();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_1);
								jteOutput.setContext("img", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
							}
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
						} else {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
						if (news.getCategory() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(news.getCategory());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(news.getTitle());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(news.getContent().length() > 120 ? news.getContent().substring(0, 120) + "..." : news.getContent());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
						if (news.getUser() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(news.getUser().getUsername());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(news.getCreatedAt().toLocalDate().toString());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
				if (recentAchievements.isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_28);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_29);
					for (Achievement a : recentAchievements) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_30);
						jteOutput.setContext("div", "class");
						jteOutput.writeUserContent(a.getLevel().toLowerCase().contains("золот") || a.getLevel().equalsIgnoreCase("gold") || a.getLevel().equals("1") ? "level-gold" : a.getLevel().toLowerCase().contains("серебр") || a.getLevel().equalsIgnoreCase("silver") || a.getLevel().equals("2") ? "level-silver" : a.getLevel().toLowerCase().contains("бронз") || a.getLevel().equalsIgnoreCase("bronze") || a.getLevel().equals("3") ? "level-bronze" : "level-other");
						jteOutput.setContext("div", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_31);
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(a.getLevel());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_32);
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(a.getTitle());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_33);
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(a.getStudentName());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_34);
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(a.getYear());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_35);
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(a.getPlace());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_36);
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(a.getCategory());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_37);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_38);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_39);
			}
		}, currentUser, userRoles, "home");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_40);
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
