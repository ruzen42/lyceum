FROM gradle:8-jdk21 AS deps
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
RUN gradle dependencies --no-daemon || true

FROM gradle:8-jdk21 AS build
WORKDIR /app
COPY --from=deps /root/.gradle /root/.gradle
COPY . .
RUN ./gradlew bootJar --no-daemon -x test

FROM eclipse-temurin:21-jre-alpine AS runner
WORKDIR /app
RUN addgroup --system --gid 1001 spring && adduser --system --uid 1001 --ingroup spring spring
COPY --from=build --chown=spring:spring /app/build/libs/*.jar app.jar
USER spring
EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
