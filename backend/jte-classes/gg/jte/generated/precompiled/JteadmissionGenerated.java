package gg.jte.generated.precompiled;
import com.jvmd.lyceum_backend.model.Role;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JteadmissionGenerated {
	public static final String JTE_NAME = "admission.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,8,8,14,14,24,24,26,26,26,28,28,29,29,31,31,31,33,33,93,93,93,94,94,94,3,4,5,6,6,6,6};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteadmissionGenerated.class, "JteadmissionGenerated.bin", 1,453,83,44,17,82,44,4239,1);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String currentUser, Set<Role> userRoles, String success, String error) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Поступление", new gg.jte.html.HtmlContent() {
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
			}
		}, currentUser, userRoles, "admission");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		String success = (String)params.getOrDefault("success", null);
		String error = (String)params.getOrDefault("error", null);
		render(jteOutput, jteHtmlInterceptor, currentUser, userRoles, success, error);
	}
}
