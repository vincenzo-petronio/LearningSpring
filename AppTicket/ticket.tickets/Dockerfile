FROM adoptopenjdk:11.0.8_10-jre-hotspot-bionic
EXPOSE 6300
#EXPOSE 443
WORKDIR /app
COPY ./build/libs/*.jar ./ticket.tickets.jar
CMD ["java","-jar","ticket.tickets.jar"]