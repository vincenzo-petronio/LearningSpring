USE appticket

--ticket
CREATE TABLE `ticket` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`code` TINYTEXT NOT NULL,
	`created` DATETIME NOT NULL DEFAULT current_timestamp(),
	`title` TINYTEXT NOT NULL,
	`description` TEXT NULL DEFAULT NULL,
	`organization` TINYTEXT NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	`location` TINYTEXT NULL DEFAULT NULL,
	`online` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0',
	`url` TEXT NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `code` (`code`) USING HASH
)
ENGINE=InnoDB
;



insert into ticket(code,title)
values(UUID(),'my first ticket');