FROM maven:3.9.2-eclipse-temurin AS builder

WORKDIR /opt/company-service

ADD pom.xml .

RUN mvn dependency:resolve

ADD src src

RUN mvn clean install

RUN ls target

RUN pwd

FROM eclipse-temurin AS release

WORKDIR /opt/company-service

COPY --from=builder /opt/company-service/target/company-service-0.0.1-SNAPSHOT.jar company-service.jar

ENTRYPOINT ["java", "-jar", "company-service.jar"]

