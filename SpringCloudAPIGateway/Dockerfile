FROM openjdk

WORKDIR usr/src

EXPOSE 9000

ADD ./target/SpringCloudAPIGateway-0.0.1-SNAPSHOT.jar /usr/src/SpringCloudAPIGateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","SpringCloudAPIGateway-0.0.1-SNAPSHOT.jar"]
