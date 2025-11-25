FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

COPY . .

# Gradle Wrapper 실행 권한
RUN chmod +x ./gradlew

# Wrapper가 자동으로 Gradle 8.14 이상 다운로드해줌
RUN ./gradlew clean bootJar -x test

FROM eclipse-temurin:17-jre-alpine AS runner
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
