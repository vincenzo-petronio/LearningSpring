FROM adoptopenjdk:11.0.8_10-jre-hotspot-bionic
EXPOSE 6200
#EXPOSE 443
WORKDIR /app
COPY ./build/libs/*.jar ./ticket.web.jar
CMD ["java","-jar","ticket.web.jar"]