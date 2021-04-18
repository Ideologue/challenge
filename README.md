# challenge
**Run app testing**

``` ./mvnw test ```

**Run the application**

``` ./mvnw spring-boot:run ```

**Test add user**

``` 
curl --location --request POST 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA==' \
--data-raw '{
    "name":"Mohammed",
    "email":"az@az.az",
    "age":20,
    "addresses":[
        {"address":"address1"},
        {"address":"address2"},
        {"address":"address3"}
    ]
}'
```

**Test Get ALl users**

```
curl --location --request GET 'http://localhost:8080/users'

```

**Test update User**

```
curl --location --request PUT 'http://localhost:8080/users/24' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA==' \
--data-raw '{
    "name":"mohammed",
    "email":"az@az.az",
    "age":20,
    "addresses":[
        {"address":"address1"},
        {"address":"address2"},
        {"address":"address3"}
    ]
}'
```

**test Get User***

```
curl --location --request GET 'http://localhost:8080/users/1'
```

**Test Delete User**

```
curl --location --request DELETE 'http://localhost:8080/users/1'
```
