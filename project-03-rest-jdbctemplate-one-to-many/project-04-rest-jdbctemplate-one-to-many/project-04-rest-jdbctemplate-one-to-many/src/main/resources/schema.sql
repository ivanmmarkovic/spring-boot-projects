
CREATE TABLE `article` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(70) NOT NULL,
    `body` TEXT(2000) NOT NULL,
    `modified_at` TIMESTAMP,
    `created_at` TIMESTAMP
);

CREATE TABLE `comment` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `body` TEXT(2000) NOT NULL,
    `modified_at` TIMESTAMP,
    `created_at` TIMESTAMP,
    `article_id` int DEFAULT NULL,
    FOREIGN KEY(`article_id`) REFERENCES `article`(`id`) ON DELETE SET NULL
);