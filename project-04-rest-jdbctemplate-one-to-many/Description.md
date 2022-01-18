# spring-boot-rest


Spring Boot REST project using H2 database.

For testing application use [Postman](https://www.getpostman.com/) or [Insomnia](https://insomnia.rest/).

You can import project as Maven project.

Method | URL | description 
-------|---- | ------------
GET       |/articles                            | get all articles             
GET       |/articles/{id}                       | get article                  
POST      |/articles                            | create new article           
PATCH     |/articles/{id}                       | update article               
DELETE    |/articles/{id}                       | delete article               
GET       |/articles/{articleId}comments        | get comments for article           
POST      |/articles/{articleId}/comments       | create new comment           
DELETE    |/articles/{articleId}/comments/{id}  | delete comment               


JSON format when adding new article:
```
{
    "title": "Java Spring",
    "body": "Place some text here"	
}
```

JSON format when adding new comment:
```
{
    "body": "Place some text here"	
}
```


When updating, you can ommit some properties. For example, if you want to update article:
```
{
	"title": "Spring"
}
```


Tables
```

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


```