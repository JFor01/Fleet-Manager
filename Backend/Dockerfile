# build stage
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# copy build config first so dependencies are cached
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle* settings.gradle* ./
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

# then the source
COPY src ./src
RUN ./gradlew bootJar --no-daemon -x test

# runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]