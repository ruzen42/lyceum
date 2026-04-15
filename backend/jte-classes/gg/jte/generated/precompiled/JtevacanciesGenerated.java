package gg.jte.generated.precompiled;
import com.jvmd.lyceum_backend.model.Vacancy;
import com.jvmd.lyceum_backend.model.Role;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public final class JtevacanciesGenerated {
	public static final String JTE_NAME = "vacancies.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,9,9,15,15,25,25,30,30,31,31,35,35,35,36,36,37,37,37,38,38,40,40,40,46,46,47,47,50,50,50,51,51,51,5,6,7,7,7,7};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtevacanciesGenerated.class, "JtevacanciesGenerated.bin", 1,380,240,21,268,42,70,41,178,279,17,43,1);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Vacancy> vacancies, String currentUser, Set<Role> userRoles) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Вакансии", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				if (vacancies.isEmpty()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					for (Vacancy v : vacancies) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
						jteOutput.setContext("h3", null);
						jteOutput.writeUserContent(v.getTitle());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
						if (v.getDescription() != null && !v.getDescription().isBlank()) {
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
							jteOutput.setContext("p", null);
							jteOutput.writeUserContent(v.getDescription());
							jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
						}
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(v.getCreatedAt().toLocalDate().toString());
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			}
		}, currentUser, userRoles, "vacancies");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Vacancy> vacancies = (List<Vacancy>)params.get("vacancies");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Set<Role> userRoles = (Set<Role>)params.getOrDefault("userRoles", null);
		render(jteOutput, jteHtmlInterceptor, vacancies, currentUser, userRoles);
	}
}
