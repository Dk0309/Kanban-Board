FROM openjdk

WORKDIR usr/lib

EXPOSE 8083

ENV MONGO_DATABASE=workspacedb

ENV MONGO_URL=mongodb://localhost:27017/workspacedb

ADD ./target/LayOutService-0.0.1-SNAPSHOT.jar /usr/lib/LayOutService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","LayOutService-0.0.1-SNAPSHOT.jar"]
