FROM adoptopenjdk:11.0.8_10-jre-hotspot-bionic
EXPOSE 6100
#EXPOSE 443
WORKDIR /app
COPY ./build/libs/*.jar ./ticket.api.jar
CMD ["java","-jar","ticket.api.jar"]