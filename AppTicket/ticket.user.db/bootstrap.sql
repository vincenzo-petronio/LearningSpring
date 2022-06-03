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
	`type` ENUM('EMAIL','FAX','TELEPHONE','MOBILE','IM','OTHER') NOT NULL,
	`value` VARCHAR(200) NOT NULL,
	`created` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE
)
ENGINE=InnoDB
;

CREATE TABLE `address` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`type` ENUM('PERMANENT','TEMPORARY','DOMICILE','POSTAL','OTHER') NOT NULL,
	`value` VARCHAR(250) NOT NULL,
	`created` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE
)
ENGINE=InnoDB
;

CREATE TABLE `user_contact` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` INT(10) UNSIGNED NOT NULL,
	`contact_id` INT(10) UNSIGNED NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_user_contact_user` (`user_id`) USING BTREE,
	INDEX `FK_user_contact_contact` (`contact_id`) USING BTREE,
	CONSTRAINT `FK_user_contact_contact` FOREIGN KEY (`contact_id`) REFERENCES `appticket`.`contact` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FK_user_contact_user` FOREIGN KEY (`user_id`) REFERENCES `appticket`.`user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
ENGINE=InnoDB
;

CREATE TABLE `user_address` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` INT(10) UNSIGNED NOT NULL,
	`address_id` INT(10) UNSIGNED NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK__user` (`user_id`) USING BTREE,
	INDEX `FK__address` (`address_id`) USING BTREE,
	CONSTRAINT `FK__address` FOREIGN KEY (`address_id`) REFERENCES `appticket`.`address` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FK__user` FOREIGN KEY (`user_id`) REFERENCES `appticket`.`user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
ENGINE=InnoDB
;


insert into user(name,surname,birthday)
values('admin','admin','2021-01-08');