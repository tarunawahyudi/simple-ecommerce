# User API Spec

## Register User
Endpoint : POST /api/users

Request Body :
```json
{
  "username" : "taruna",
  "password" : "secret",
  "name" : "Taruna Wahyudi"
}
```

Response Body (Success) :

```json
{
  "status" : 1 
}
```

Response Body (Failed) :

```json
{
  "status" : 0,
  "message" : "Username must not blank, ???"
}
```

## Login User
Endpoint : POST /api/auth/login

Request Body :
```json
{
  "username" : "taruna",
  "password" : "secret"
}
```

Response Body (Success) :

```json
{
  "status" : 1,
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 1234567 // Miliseconds
  }
}
```

Response Body (Failed, 401) :

```json
{
  "status" : 0,
  "message": "Username or password wrong"
}
```

## Get User
Endpoint : GET /api/users/current

Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "status" : 1,
  "data" : {
    "username" : "taruna",
    "name" : "Taruna Wahyudi"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "status" : 0,
  "message": "Unauthorized"
}
```

## Update User
Endpoint : PATCH /api/users/current

Request Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "name" : "Taruna Wahyudi", // put if only want to update name
  "password" : "New Password" // put if only want to update password
}
```

Response Body (Success) :

```json
{
  "status" : 1,
  "data" : {
    "username" : "taruna",
    "name" : "Taruna Wahyudi"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "status" : 0,
  "message": "Unauthorized"
}
```

## Logout User
Endpoint : DELETE /api/auth/logout

Request Header :
- X-API-TOKEN : Token (Mandatory)
  Response Body (Failed, 401) :

Response Body (Success) :

```json
{
  "status" : 1,
  "message": "Success"
}
```