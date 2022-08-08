ARG DIRECTORY=/home/mktp-app/
ARG APP_ARG=${APP_ARG}
ARG IP_ARG=${IP_ARG}
ARG DB_NAME_ARG=${DB_NAME_ARG}
ARG DB_USERNAME_ARG=${DB_USERNAME_ARG}
ARG DB_PASSWORD_ARG=${DB_PASSWORD_ARG}

FROM gradle:7.1.0-jdk11 AS builder
ARG DIRECTORY
COPY --chown=gradle:gradle . $DIRECTORY
WORKDIR $DIRECTORY
RUN gradle build --no-daemon

FROM openjdk:11.0.15-jre-slim
ARG VERSION=0.0.1-SNAPSHOT
ARG DIRECTORY
ARG APP_ARG
ARG IP_ARG
ARG DB_NAME_ARG
ARG DB_USERNAME_ARG
ARG DB_PASSWORD_ARG
RUN mkdir /app
COPY --from=builder $DIRECTORY/build/libs/purchases-mktp-$VERSION.jar /app/purchases-mktp-api.jar
ENV spring.profiles.active=$APP_ARG
ENV DB_IP=$IP_ARG
ENV DB_NAME=$DB_NAME_ARG
ENV DB_USER=$DB_USERNAME_ARG
ENV DB_PWD=$DB_PASSWORD_ARG
#ENTRYPOINT ["java","-Dspring.config.activate.on-profile=${APP_ENV}","-DDB_IP=${DB_IP_ENV}","-DDB_NAME=${DB_NAME_ENV}","-DDB_USER=${DB_USER_ENV}","-DDB_PWD=${DB_PWD_ENV}","-jar","/app/purchases-mktp-api.jar"]
ENTRYPOINT ["java","-jar","/app/purchases-mktp-api.jar"]
#CMD java -jar -Dspring.profiles.active=dev /app/purchases-mktp-api.jar