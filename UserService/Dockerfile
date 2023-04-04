FROM openjdk

WORKDIR usr/lib

EXPOSE 8081

ENV MONGO_DATABASE=myDB

ENV MONGO_URL=mongodb://localhost:27017/myDB

ADD ./target/UserService-0.0.1-SNAPSHOT.jar /usr/lib/UserService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","UserService-0.0.1-SNAPSHOT.jar"]
