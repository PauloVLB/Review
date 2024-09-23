FROM maven:3.9.9-amazoncorretto-21-al2023 AS builder
COPY . /usr/src/app/
WORKDIR /usr/src/app/
## FIXME Num servidor, trocar para esse
# RUN bash mvnw clean package -Dmaven.test.skip

RUN mvn clean package -DskipTests

FROM amazoncorretto:21.0.4-alpine3.20
ENV TZ="America/Recife"
COPY --from=builder /usr/src/app/target/*jar /usr/src/app/app.jar
WORKDIR /usr/src/app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]