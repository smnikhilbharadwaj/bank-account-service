FROM maven:3.6.1-jdk-8 AS build
COPY src /usr/concur/bankaccountservice/src
COPY pom.xml /usr/concur/bankaccountservice
RUN mvn -f /usr/concur/bankaccountservice/pom.xml clean compile package
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:mysql://mysqldb:3306/concur?useSSL=false&allowPublicKeyRetrieval=true","-jar","/usr/concur/bankaccountservice/target/bank-account-service-1.0.0.jar"]