CREATE SCHEMA IF NOT EXISTS `blogdb`;

USE `blogdb`;

CREATE TABLE IF NOT EXISTS `moblog`(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `heading` TINYTEXT,
    `description` MEDIUMTEXT
);