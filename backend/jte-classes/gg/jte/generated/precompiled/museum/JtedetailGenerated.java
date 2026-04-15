package gg.jte.generated.precompiled.museum;
import com.jvmd.lyceum_backend.model.MuseumExhibit;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtedetailGenerated {
	public static final String JTE_NAME = "museum/detail.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,8,8,14,14,20,20,20,26,26,28,28,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,30,30,32,32,34,34,36,36,38,38,39,39,39,40,40,42,42,46,46,48,48,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,50,50,52,52,54,54,54,57,57,57,57,60,60,62,62,65,65,65,66,66,66,4,5,6,6,6,6};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtedetailGenerated.class, "JtedetailGenerated.bin", 1,311,127,74,33,6,1,6,1,87,44,18,80,44,84,21,18,285,80,41,6,1,6,1,51,117,129,156,152,44,43,1);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MuseumExhibit exhibit, String currentUser, Set<Role> userRoles) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, exhibit.getTitle(), new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(exhibit.getTitle());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				if (!exhibit.getImageUrls().isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					for (String url : exhibit.getImageUrls()) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
						var __jte_html_attribute_0 = url;
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
							jteOutput.setContext("img", "src");
							jteOutput.writeUserContent(__jte_html_attribute_0);
							jteOutput.setContext("img", null);
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
						}
						var __jte_html_attribute_1 = exhibit.getTitle();
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
							jteOutput.setContext("img", "alt");
							jteOutput.writeUserContent(__jte_html_attribute_1);
							jteOutput.setContext("img", null);
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
				if (exhibit.getHtmlContent() != null && !exhibit.getHtmlContent().isBlank()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
					jteOutput.writeUnsafeContent(exhibit.getHtmlContent());
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
				} else if (exhibit.getDescription() != null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(exhibit.getDescription());
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
				if (!exhibit.getRelatedExhibits().isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
					for (MuseumExhibit rel : exhibit.getRelatedExhibits()) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
						if (!rel.getImageUrls().isEmpty()) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
							var __jte_html_attribute_2 = rel.getImageUrls().get(0);
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_2);
								jteOutput.setContext("img", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
							}
							var __jte_html_attribute_3 = rel.getTitle();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_3);
								jteOutput.setContext("img", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
							}
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
						} else {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(rel.getTitle());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(rel.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_28);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_29);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_30);
			}
		}, currentUser, userRoles, "museum");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_31);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MuseumExhibit exhibit = (MuseumExhibit)params.get("exhibit");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, exhibit, currentUser, userRoles);
	}
}
