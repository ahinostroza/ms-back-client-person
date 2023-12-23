FROM arm64v8/amazoncorretto:17
ARG arg_api_port
ENV ENV_API_PORT=$arg_api_port
EXPOSE $ENV_API_PORT

ENV LANG en_US.UTF-8
ENV LC_ALL en_US.UTF-8
ENV TZ=America/Bogota
VOLUME /tmp
ADD app/build/libs/app-service.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=America/Bogota","-jar","/app.jar"]