FROM java:openjdk-8-jdk
ADD /target/api-example-0.0.1-SNAPSHOT.jar /data/api-example-0.0.1-SNAPSHOT.jar
CMD java -jar /data/api-example-0.0.1-SNAPSHOT.jar server
EXPOSE 8080