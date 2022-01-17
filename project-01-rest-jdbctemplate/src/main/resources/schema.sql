
DROP TABLE `articles` IF EXISTS;

CREATE TABLE `articles` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(70) NOT NULL,
    `body` TEXT(2000) NOT NULL,
    `updated_at` TIMESTAMP,
    `created_at` TIMESTAMP
);

CREATE TABLE `comments` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `body` TEXT(2000) NOT NULL,
    `modified_at` TIMESTAMP,
    `created_at` TIMESTAMP,
    `article_id` int DEFAULT NULL,
    FOREIGN KEY(`article_id`) REFERENCES `articles`(`id`) ON DELETE SET NULL
);
