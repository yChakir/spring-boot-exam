FROM maven:3.6-jdk-11 as builder

WORKDIR /cigma_shop

COPY . .

RUN mvn clean install

FROM openjdk:11-jre-slim

COPY --from=builder /cigma_shop/target/cigma-shop.jar /target/cigma-shop.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/target/cigma-shop.jar"]