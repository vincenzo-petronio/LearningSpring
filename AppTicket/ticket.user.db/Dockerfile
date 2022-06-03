FROM mariadb:10.8.3

ENV MYSQL_ROOT_PASSWORD admin
ENV MYSQL_DATABASE appticket

EXPOSE 3307
COPY *.cnf /etc/mysql/conf.d
ADD bootstrap.sql /docker-entrypoint-initdb.d