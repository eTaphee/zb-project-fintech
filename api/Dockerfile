FROM openjdk:11
RUN mkdir -p deploy
WORKDIR /deploy
COPY ./build/libs/api-0.0.1.jar api.jar

# dockerlize
ENV DOCKERIZE_VERSION v0.7.0
RUN apt update \
    && apt install -y wget openssl \
    && wget -O - https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz | tar xzf - -C /usr/local/bin \
    && apt remove -y wget

ENTRYPOINT ["dockerize", "-wait", "tcp://mysql:3306", "-timeout", "20s"]
ENTRYPOINT ["dockerize", "-wait", "tcp://redis:6379", "-timeout", "20s"]
ENTRYPOINT ["dockerize", "-wait", "tcp://kafka:9092", "-timeout", "20s"]
ENTRYPOINT ["java", "-jar", "/deploy/api.jar", "--spring.profiles.active=dev"]
