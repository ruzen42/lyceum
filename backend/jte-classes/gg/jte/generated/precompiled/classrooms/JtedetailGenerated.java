package gg.jte.generated.precompiled.classrooms;
import com.jvmd.lyceum_backend.model.Classroom;
import com.jvmd.lyceum_backend.model.Material;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtedetailGenerated {
	public static final String JTE_NAME = "classrooms/detail.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,9,9,15,15,21,21,21,29,29,31,31,33,33,38,38,38,41,41,46,46,47,47,51,51,51,52,52,53,53,53,54,54,55,55,57,57,57,57,57,57,59,59,62,62,64,64,65,65,65,65,65,65,65,65,65,66,66,68,68,70,70,71,71,81,81,81,85,85,85,93,93,93,94,94,94,5,6,7,7,7,7};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtedetailGenerated.class, "JtedetailGenerated.bin", 1,321,263,222,60,329,71,321,33,302,54,125,53,49,187,4,108,139,122,55,7,1,105,92,76,29,856,321,207,1);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Classroom classroom, String currentUser, Set<Role> userRoles) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, classroom.getTitle(), new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(classroom.getTitle());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				if (classroom.getHtmlContent() != null && !classroom.getHtmlContent().isBlank()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					jteOutput.writeUnsafeContent(classroom.getHtmlContent());
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(classroom.getMaterials().size());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
				if (classroom.getMaterials().isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
					for (Material m : classroom.getMaterials()) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
						jteOutput.setContext("h4", null);
						jteOutput.writeUserContent(m.getTitle());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
						if (m.getDescription() != null && !m.getDescription().isBlank()) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
							jteOutput.setContext("p", null);
							jteOutput.writeUserContent(m.getDescription());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
						if (m.getAuthor() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
							jteOutput.setContext("div", null);
							jteOutput.writeUserContent(m.getAuthor().getUsername());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
							jteOutput.setContext("div", null);
							jteOutput.writeUserContent(m.getCreatedAt().toLocalDate().toString());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
						if (!m.getFileUrls().isEmpty()) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
							for (String url : m.getFileUrls()) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
								var __jte_html_attribute_0 = url;
								if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
									jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
									jteOutput.setContext("a", "href");
									jteOutput.writeUserContent(__jte_html_attribute_0);
									jteOutput.setContext("a", null);
									jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
								}
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
							}
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(classroom.getTitle());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(classroom.getMaterials().size());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_28);
			}
		}, currentUser, userRoles, "classrooms");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_29);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Classroom classroom = (Classroom)params.get("classroom");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, classroom, currentUser, userRoles);
	}
}
