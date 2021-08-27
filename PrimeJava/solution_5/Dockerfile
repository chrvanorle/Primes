FROM adoptopenjdk:16-jdk-hotspot

WORKDIR /opt/app

RUN apt-get update && apt-get -y install jasmin-sable

COPY src src
COPY runSolution.sh .
RUN jasmin -d src src/*.j && javac src/*.java

CMD [ "sh", "runSolution.sh" ]
