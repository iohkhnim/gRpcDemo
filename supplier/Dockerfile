FROM java:8u111-jre
COPY target/*.jar supplier-0.0.1-SNAPSHOT.jar
COPY key key
ENTRYPOINT ["java","-jar","/supplier-0.0.1-SNAPSHOT.jar"]