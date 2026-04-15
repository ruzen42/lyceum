package gg.jte.generated.precompiled;
import com.jvmd.lyceum_backend.model.Achievement;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteachievementsGenerated {
	public static final String JTE_NAME = "achievements.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,9,9,15,15,25,25,30,30,32,32,35,35,35,35,36,36,36,38,38,38,39,39,39,41,41,41,42,42,42,46,46,46,47,47,47,52,52,54,54,57,57,57,58,58,58,5,6,7,7,7,7};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteachievementsGenerated.class, "JteachievementsGenerated.bin", 1,444,223,71,187,43,116,92,139,54,358,58,189,44,43,1);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Achievement> achievements, String currentUser, Set<Role> userRoles) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Достижения", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				if (achievements.isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					for (Achievement a : achievements) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
						jteOutput.setContext("div", "class");
						jteOutput.writeUserContent(a.getLevel().toLowerCase().contains("золот") || a.getLevel().equalsIgnoreCase("gold") || a.getLevel().equals("1") ? "level-gold" : a.getLevel().toLowerCase().contains("серебр") || a.getLevel().equalsIgnoreCase("silver") || a.getLevel().equals("2") ? "level-silver" : a.getLevel().toLowerCase().contains("бронз") || a.getLevel().equalsIgnoreCase("bronze") || a.getLevel().equals("3") ? "level-bronze" : "level-other");
						jteOutput.setContext("div", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(a.getLevel());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(a.getTitle());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(a.getDescription());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(a.getCategory());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(a.getYear());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
						jteOutput.setContext("strong", null);
						jteOutput.writeUserContent(a.getStudentName());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(a.getPlace());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
			}
		}, currentUser, userRoles, "achievements");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Achievement> achievements = (List<Achievement>)params.get("achievements");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, achievements, currentUser, userRoles);
	}
}
