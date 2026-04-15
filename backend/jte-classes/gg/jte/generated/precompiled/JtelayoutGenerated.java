package gg.jte.generated.precompiled;
import gg.jte.Content;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,15,15,15,15,32,32,32,32,32,32,32,32,32,33,33,33,33,33,33,33,33,33,34,34,34,34,34,34,34,34,34,35,35,35,35,35,35,35,35,35,36,36,36,36,36,36,36,36,36,37,37,37,37,37,37,37,37,37,38,38,38,38,38,38,38,38,38,39,39,39,39,39,39,39,39,39,42,42,43,43,45,45,47,47,49,49,49,51,51,53,53,67,67,68,68,70,70,72,72,73,73,75,75,80,80,80,118,118,118,4,5,6,7,8,8,8,8};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtelayoutGenerated.class, "JtelayoutGenerated.bin", 154,842,8,1,47,8,1,55,8,1,58,8,1,56,8,1,51,8,1,49,8,1,54,8,1,92,17,101,126,151,46,98,606,13,84,88,9,53,55,1422);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content content, String currentUser, Set<Role> userRoles, String activePage) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
		var __jte_html_attribute_0 = activePage.equals("home") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
		var __jte_html_attribute_1 = activePage.equals("news") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		var __jte_html_attribute_2 = activePage.equals("achievements") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		var __jte_html_attribute_3 = activePage.equals("portfolio") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_3);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
		var __jte_html_attribute_4 = activePage.equals("vacancies") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_4);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
		var __jte_html_attribute_5 = activePage.equals("museum") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_5);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
		var __jte_html_attribute_6 = activePage.equals("classrooms") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_6)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_6);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
		var __jte_html_attribute_7 = activePage.equals("admission") ? "active" : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_7)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
			jteOutput.setContext("a", "class");
			jteOutput.writeUserContent(__jte_html_attribute_7);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
		if (currentUser != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
			if (userRoles != null && (userRoles.contains(Role.ROLE_ADMIN) || userRoles.contains(Role.ROLE_TEACHER))) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
			} else if (userRoles != null && userRoles.contains(Role.ROLE_STUDENT)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_28);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_29);
			jteOutput.setContext("button", null);
			jteOutput.writeUserContent(currentUser);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_30);
		} else {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_31);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_32);
		if (currentUser != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_33);
			if (userRoles != null && (userRoles.contains(Role.ROLE_ADMIN) || userRoles.contains(Role.ROLE_TEACHER))) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_34);
			} else if (userRoles != null && userRoles.contains(Role.ROLE_STUDENT)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_35);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_36);
		} else {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_37);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_38);
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_39);
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
