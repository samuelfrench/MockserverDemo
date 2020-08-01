FROM java:8
WORKDIR /
ADD target/mockserver-demo-1.0-SNAPSHOT-jar-with-dependencies.jar mockserver-demo-1.0-SNAPSHOT-jar-with-dependencies.jar
ADD mockserver.properties mockserver.properties
EXPOSE 8080
CMD java -jar mockserver-demo-1.0-SNAPSHOT-jar-with-dependencies.jar
