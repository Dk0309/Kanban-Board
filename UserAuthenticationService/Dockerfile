FROM openjdk

WORKDIR usr/lib

EXPOSE 9091

ENV SQL_DATABASE = usersDB

ENV SQL_URL = jdbc:mysql://localhost:3306/usersDB

ADD ./target/UserAuthenticationService-0.0.1-SNAPSHOT.jar /usr/lib/UserAuthenticationService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","UserAuthenticationService-0.0.1-SNAPSHOT.jar"]