package gg.jte.generated.precompiled.museum;
import com.jvmd.lyceum_backend.model.MuseumExhibit;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtelistGenerated {
	public static final String JTE_NAME = "museum/list.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,9,9,15,15,25,25,30,30,32,32,34,34,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,36,36,38,38,40,40,40,41,41,42,42,42,43,43,44,44,46,46,46,48,48,51,51,51,51,52,52,53,53,53,54,54,57,57,59,59,62,62,62,63,63,63,5,6,7,7,7,7};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtelistGenerated.class, "JtelistGenerated.bin", 1,376,241,71,80,41,6,1,6,1,51,117,129,42,62,41,37,146,100,151,92,108,44,99,44,43,1);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<MuseumExhibit> exhibits, String currentUser, Set<Role> userRoles) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Школьный музей", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				if (exhibits.isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					for (MuseumExhibit e : exhibits) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
						if (!e.getImageUrls().isEmpty()) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
							var __jte_html_attribute_0 = e.getImageUrls().get(0);
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("img", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
							}
							var __jte_html_attribute_1 = e.getTitle();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(__jte_html_attribute_1);
								jteOutput.setContext("img", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
							}
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
						} else {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(e.getTitle());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
						if (e.getDescription() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
							jteOutput.setContext("p", null);
							jteOutput.writeUserContent(e.getDescription().length() > 100 ? e.getDescription().substring(0, 100) + "..." : e.getDescription());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
						if (!e.getImageUrls().isEmpty()) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(e.getImageUrls().size());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(e.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
						if (!e.getRelatedExhibits().isEmpty()) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
							jteOutput.setContext("span", null);
							jteOutput.writeUserContent(e.getRelatedExhibits().size());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
			}
		}, currentUser, userRoles, "museum");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<MuseumExhibit> exhibits = (List<MuseumExhibit>)params.get("exhibits");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, exhibits, currentUser, userRoles);
	}
}
