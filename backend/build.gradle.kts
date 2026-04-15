plugins {
	java
	id("org.springframework.boot") version "4.0.5"
	id("io.spring.dependency-management") version "1.1.7"
	id("gg.jte.gradle") version "3.2.3"
}

group = "com.jvmd"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

extra["springAiVersion"] = "2.0.0-M4"

dependencies {
	implementation("gg.jte:jte-spring-boot-starter-4:3.2.3")
	implementation("me.paulschwarz:springboot3-dotenv:5.1.0")
	implementation("software.amazon.awssdk:s3:2.27.0")
	implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("io.jsonwebtoken:jjwt-api:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("org.springframework.boot:spring-boot-starter-websocket")
	implementation("org.springframework.ai:spring-ai-starter-model-ollama")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
//	runtimeOnly("org.springframework.boot:spring-boot-docker-compose")
	testCompileOnly("org.projectlombok:lombok")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testAnnotationProcessor("org.projectlombok:lombok")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.ai:spring-ai-bom:${property("springAiVersion")}")
	}
}

jte {
	contentType = gg.jte.ContentType.Html
	binaryStaticContent = true
}

tasks.compileJava {
	dependsOn(tasks.generateJte)
}

tasks.bootJar {
	dependsOn(tasks.precompileJte)
	from(fileTree("jte-classes") { include("**/*.class") }) {
		into("BOOT-INF/classes")
	}
	from(fileTree("build/generated-resources/jte") { include("**/*.bin") }) {
		into("BOOT-INF/classes")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
