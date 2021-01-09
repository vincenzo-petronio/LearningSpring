--ticket
CREATE TABLE appticket.ticket(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    code BIGINT SIGNED UNIQUE NOT NULL,
    created DATETIME NOT NULL
);
insert into ticket(code,created)
values(111222333,'2020-10-18T16:00:00.00000');
insert into ticket(code,created)
values(444555666,'2020-11-20T17:00:00.00000');
insert into ticket(code,created)
values(777888999,'2020-12-22T18:00:00.00000');
insert into ticket(code,created)
values(651423789,'2020-12-24T18:00:00.00000');