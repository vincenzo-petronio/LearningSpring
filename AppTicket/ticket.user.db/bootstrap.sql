--user
CREATE TABLE appticket.user(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

insert into user(name,surname,birthday)
values('admin','admin','2021-01-08');