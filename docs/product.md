# Product API Spec

## Create Product

Endpoint : POST /api/products

Request Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "name" : "iPhone 11 Pro",
  "description" : "Example Description",
  "price" : 10000000
}
```

Response Body (Success) :

```json
{
  "status" : 1,
  "data" : {
    "name" : "iPhone 11 Pro",
    "description" : "Example Description",
    "price" : 10000000
  }
}
```

Response Body (Failed) :

```json
{
  "status" : 0,
  "message" : "Something Wrong ..."
}
```

## Update Product

Endpoint : PUT /api/products/{id}

Request Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "name" : "iPhone 11 Pro",
  "description" : "Example Description",
  "price" : 10000000
}
```

Response Body (Success) :
```json
{
  "status" : 1,
  "data" : {
    "name" : "iPhone 11 Pro",
    "description" : "Example Description",
    "price" : 10000000
  }
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Something Wrong ..."
}
```

## Get Product

Endpoint : GET /api/products/{id}

Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "status" : 1,
  "data" : {
    "name" : "iPhone 11 Pro",
    "description" : "Example Description",
    "price" : 10000000
  }
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Product is not found"
}
```

## Search Product

Endpoint : GET /api/products

Query Param :
- name : string
- page : integer, start from 0, default 0
- size : integer, default 10

Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "status" : 1,
  "data" : [
    {
      "name" : "iPhone 11 Pro",
      "description" : "Example Description",
      "price" : 10000000
    }
  ],
  "paging" : {
    "currentPage" : 0,
    "totalPage": 10,
    "size" : 10
  }
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Unauthorized"
}
```

## Remove Product

Endpoint : DELETE /api/products/{id}

Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "status" : 1,
  "message" : "success"
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Product is not found"
}
```