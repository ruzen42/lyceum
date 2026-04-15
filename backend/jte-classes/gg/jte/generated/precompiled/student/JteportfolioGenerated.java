package gg.jte.generated.precompiled.student;
import com.jvmd.lyceum_backend.model.Role;
import com.jvmd.lyceum_backend.model.StudentPortfolio;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteportfolioGenerated {
	public static final String JTE_NAME = "student/portfolio.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,10,10,16,16,21,21,22,22,22,23,23,24,24,25,25,25,26,26,36,36,36,36,36,36,36,36,36,42,42,42,42,42,42,42,42,42,47,47,47,48,48,51,51,51,51,51,51,51,51,51,54,54,55,55,57,57,59,59,65,65,65,67,67,69,69,74,74,74,75,75,75,4,5,6,7,8,8,8,8};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteportfolioGenerated.class, "JteportfolioGenerated.bin", 1,472,54,19,13,53,19,525,8,1,316,8,1,173,33,326,7,1,334,25,126,117,322,59,170,90,1);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String currentUser, Set<Role> userRoles, StudentPortfolio portfolio, String success, String error) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Моё портфолио", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				if (success != null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(success);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
				if (error != null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(error);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
				var __jte_html_attribute_0 = portfolio != null ? portfolio.getStudentName() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
				var __jte_html_attribute_1 = portfolio != null ? portfolio.getGrade() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
				jteOutput.setContext("label", null);
				jteOutput.writeUserContent(portfolio != null && portfolio.getFileUrl() != null ? "" : "*");
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
				if (portfolio != null && portfolio.getFileUrl() != null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
					var __jte_html_attribute_2 = portfolio.getFileUrl();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("a", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
				if (portfolio == null || portfolio.getFileUrl() == null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
				jteOutput.setContext("button", null);
				jteOutput.writeUserContent(portfolio != null ? "Сохранить изменения" : "Загрузить портфолио");
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
				if (portfolio != null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
			}
		}, currentUser, userRoles, "portfolio");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String currentUser = (String)params.get("currentUser");
		Set<Role> userRoles = (Set<Role>)params.get("userRoles");
		StudentPortfolio portfolio = (StudentPortfolio)params.getOrDefault("portfolio", null);
		String success = (String)params.getOrDefault("success", null);
		String error = (String)params.getOrDefault("error", null);
		render(jteOutput, jteHtmlInterceptor, currentUser, userRoles, portfolio, success, error);
	}
}
