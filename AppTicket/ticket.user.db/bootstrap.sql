USE appticket

--user
CREATE TABLE `user` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`surname` VARCHAR(100) NOT NULL,
	`birthday` DATE NOT NULL,
	`created` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE
)
ENGINE=InnoDB
;

CREATE TABLE `contact` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` INT(10) UNSIGNED NOT NULL,
	`type` ENUM('EMAIL','FAX','TELEPHONE','MOBILE','IM','OTHER') NOT NULL,
	`value` VARCHAR(200) NOT NULL,
	`created` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_contact_user` (`user_id`) USING BTREE,
	CONSTRAINT `FK_contact_user` FOREIGN KEY (`user_id`) REFERENCES `appticket`.`user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
ENGINE=InnoDB
;

CREATE TABLE `address` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` INT(10) UNSIGNED NOT NULL,
	`type` ENUM('PERMANENT','TEMPORARY','DOMICILE','POSTAL','OTHER') NOT NULL,
	`value` VARCHAR(250) NOT NULL,
	`created` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_address_user` (`user_id`) USING BTREE,
	CONSTRAINT `FK_address_user` FOREIGN KEY (`user_id`) REFERENCES `appticket`.`user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
ENGINE=InnoDB
;


insert into user(name,surname,birthday)
values('admin','admin','2021-01-08');