FROM java:openjdk-8-jdk
ADD /data/jenkins/workspace/happy-family-api-test_dale_v2/target/api-example-0.0.1-SNAPSHOT.jar /data/api-example-0.0.1-SNAPSHOT.jar
CMD java -jar /data/api-example-0.0.1-SNAPSHOT.jar server
EXPOSE 8080