FROM maven:3.6.3-jdk-8-slim as maven_build

WORKDIR /build/

COPY pom.xml /build/
COPY src /build/src/

RUN mvn clean package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-alpine

LABEL maintainer="husseyn.despaignereyes@gmail.com"

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

VOLUME /tmp

ENV database_host=mysql-for-spring-test
ENV database_port=3306
ENV database_name=persons_database
ENV database_user=root
ENV database_password=test_passw

EXPOSE 8080

ARG DEPENDENCY=/build/target/dependency
COPY --from=maven_build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=maven_build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=maven_build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.spring.mysql.docker.example.Application"]