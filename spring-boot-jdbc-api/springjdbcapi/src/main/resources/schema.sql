DROP TABLE `articles` IF EXISTS;

CREATE TABLE `articles` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(70) NOT NULL,
    `body` TEXT(2000) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);