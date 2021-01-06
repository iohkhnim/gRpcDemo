FROM java:8u111-jre
COPY target/*.jar price-0.0.1-SNAPSHOT.jar
COPY key key
ENTRYPOINT ["java","-jar","/price-0.0.1-SNAPSHOT.jar"]