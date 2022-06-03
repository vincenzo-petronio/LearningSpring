USE appticket

--ticket
CREATE TABLE `ticket` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`code` UUID NOT NULL,
	`created` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `code` (`code`) USING BTREE
)
ENGINE=InnoDB
;


insert into ticket(code)
values(UUID());