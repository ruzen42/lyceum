package gg.jte.generated.precompiled;
import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtenewsGenerated {
	public static final String JTE_NAME = "news.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,10,10,16,16,26,26,27,27,27,28,28,30,30,35,35,37,37,39,39,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,41,41,43,43,45,45,46,46,46,47,47,48,48,48,49,49,49,51,51,52,52,52,53,53,54,54,54,58,58,60,60,63,63,63,64,64,64,5,6,7,8,8,8,8};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtenewsGenerated.class, "JtenewsGenerated.bin", 1,371,58,23,18,219,71,80,41,6,1,6,1,51,114,93,77,44,99,63,129,55,48,52,149,44,43,1);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<News> newsList, String currentUser, Set<Role> userRoles, String success) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Новости", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				if (success != null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(success);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
				if (newsList.isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
					for (News news : newsList) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
						if (news.getImageUrl() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
							var __jte_html_attribute_0 = news.getImageUrl();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("img", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
							}
							var __jte_html_attribute_1 = news.getTitle();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_1);
								jteOutput.setContext("img", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
							}
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
						} else {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
						if (news.getCategory() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(news.getCategory());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
						jteOutput.setContext("h2", null);
						jteOutput.writeUserContent(news.getTitle());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(news.getContent());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
						if (news.getUser() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(news.getUser().getUsername());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(news.getCreatedAt().toLocalDate().toString());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
			}
		}, currentUser, userRoles, "news");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<News> newsList = (List<News>)params.get("newsList");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		String success = (String)params.getOrDefault("success", null);
		render(jteOutput, jteHtmlInterceptor, newsList, currentUser, userRoles, success);
	}
}
