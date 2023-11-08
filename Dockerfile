# BUILD stage
FROM 289208114389.dkr.ecr.us-east-1.amazonaws.com/maven:3.8.3-openjdk-17-slim AS build
COPY pom.xml .
COPY docker-local/settings.xml .
RUN mvn dependency:go-offline -s settings.xml
COPY src src
RUN mvn package -s settings.xml
#
# RELEASE stage
#
FROM 289208114389.dkr.ecr.us-east-1.amazonaws.com/picpay/graalvm-oraclelinux-slim:21.3-java17 AS release
COPY --from=build /target/*.jar /app.jar
# docker-entrypoint.sh loads the env vars into the app.
# This is considered a safer approach over docker envs
# cause only the app has access to them, not the whole
# container
COPY docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh
ENTRYPOINT ["/docker-entrypoint.sh"]
