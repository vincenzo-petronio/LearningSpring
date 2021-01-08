# AppTicket

- Eureka disco Server   http://localhost:6500/
- API Gateway           http://localhost:6100/
- Vaadin Web Client     http://localhost:6200/
- Tickets service       http://localhost:6300/
- User service          http://localhost:6400/

solo HTTP!!!

# Setup


# Run
Eseguire la build di ogni project usando gradle:
<br />branch master: `gradlew.bat clean build`
<br />branch jib: `gradlew.bat clean jibDockerBuild`

Eseguire docker compose:<br />
`docker-compose up`
