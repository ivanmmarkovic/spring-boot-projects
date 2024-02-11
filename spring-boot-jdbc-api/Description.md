

# CRUD with MongoDB

Method | URL | description 
-------|---- | ------------
POST      |/api/articles                            | create article
GET       |/api/articles                            | get all articles             
GET       |/api/articles/{id}                       | get article 
PUT       |/api/articles/{id}                       | update article               
DELETE    |/api/articles/{id}                       | delete article            

# Create schema.sql
```
DROP TABLE `articles` IF EXISTS;

CREATE TABLE `articles` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(70) NOT NULL,
    `body` TEXT(2000) NOT NULL,
    `updated_at` TIMESTAMP,
    `created_at` TIMESTAMP
);

```


# Start MySQL
- docker-compose up --build

docker ps
docker exec -it 93fb5594c5f8 mysql -p
- enter password (password is in docker-compose.yaml)
CREATE DATABASE my_db;

### POST 
```
{
    "title": "article title",
    "body": "article body"
}
```

### PUT
```
{
    "title": "new title",
    "body": "new body"
}
```

