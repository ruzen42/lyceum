package gg.jte.generated.precompiled;
import com.jvmd.lyceum_backend.model.StudentPortfolio;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteportfolioGenerated {
	public static final String JTE_NAME = "portfolio.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,9,9,15,15,25,25,30,30,32,32,38,38,38,39,39,39,43,43,45,45,45,45,45,45,45,45,45,51,51,54,54,54,58,58,60,60,63,63,63,64,64,64,5,6,7,7,7,7};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteportfolioGenerated.class, "JteportfolioGenerated.bin", 1,395,228,71,432,86,135,117,7,1,433,178,149,44,43,1);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<StudentPortfolio> portfolios, String currentUser, Set<Role> userRoles) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Портфолио", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				if (portfolios.isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					for (StudentPortfolio p : portfolios) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(p.getStudentName());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(p.getGrade());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
						if (p.getFileUrl() != null) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
							var __jte_html_attribute_0 = p.getFileUrl();
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(__jte_html_attribute_0);
								jteOutput.setContext("a", null);
								jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
							}
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
						jteOutput.setContext("span", null);
						jteOutput.writeUserContent(p.getCreatedAt().toLocalDate().toString());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
			}
		}, currentUser, userRoles, "portfolio");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<StudentPortfolio> portfolios = (List<StudentPortfolio>)params.get("portfolios");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, portfolios, currentUser, userRoles);
	}
}
