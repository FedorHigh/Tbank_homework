FROM node:23

WORKDIR /app

COPY . .

RUN ./gradlew clean build -x test

FROM node:23

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
