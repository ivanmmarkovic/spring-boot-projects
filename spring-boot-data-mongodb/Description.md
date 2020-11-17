

# CRUD with MongoDB

Method | URL | description 
-------|---- | ------------
POST      |/api/articles                            | create article
GET       |/api/articles                            | get all articles             
GET       |/api/articles/{id}                       | get article 
PATCH     |/api/articles/{id}                       | update article               
DELETE    |/api/articles/{id}                       | delete article            


### POST 
```
{
    "title": "article title",
    "body": "article body"
}
```

### PATCH
- you can update only title or body, or both
```
{
    "title": "new title",
    "body": "new body"
}
```

## TODO
- error handling
- validate input data