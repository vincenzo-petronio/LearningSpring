CREATE TABLE appticket.ticket(
    id INT PRIMARY KEY NOT NULL,
    code INT NOT NULL,
    created DATETIME NOT NULL
);
insert into ticket(id,code,created)
values(1,111222333,'2020-10-18T16:00:00.00000');
insert into ticket(id,code,created)
values(2,444555666,'2020-11-20T17:00:00.00000');
insert into ticket(id,code,created)
values(3,777888999,'2020-12-22T18:00:00.00000');
insert into ticket(id,code,created)
values(4,651423789,'2020-12-24T18:00:00.00000');