FROM adoptopenjdk:11.0.8_10-jre-hotspot-bionic
EXPOSE 6400
#EXPOSE 443
WORKDIR /app
COPY ./build/libs/*.jar ./ticket.user.jar
CMD ["java","-jar","ticket.user.jar"]