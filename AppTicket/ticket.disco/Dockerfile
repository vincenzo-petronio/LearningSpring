FROM adoptopenjdk:11.0.8_10-jre-hotspot-bionic
EXPOSE 6500
#EXPOSE 443
WORKDIR /app
COPY ./build/libs/*.jar ./ticket.disco.jar
CMD ["java","-jar","ticket.disco.jar"]