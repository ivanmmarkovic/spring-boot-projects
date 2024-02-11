

# CRUD with MongoDB

Method | URL | description 
-------|---- | ------------
POST      |/api/articles                            | create article
GET       |/api/articles                            | get all articles             
GET       |/api/articles/{id}                       | get article 
PUT       |/api/articles/{id}                       | update article               
DELETE    |/api/articles/{id}                       | delete article            

# Start MongoDb
- docker-compose up --build

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

