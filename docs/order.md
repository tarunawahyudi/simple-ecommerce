# Order API Spec

## Create Order

Endpoint : POST /api/orders

Request Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "product_id" : 1,
  "quantity" : 2
}
```

Response Body (Success) :
```json
{
  "status" : 1,
  "message" : "OK"
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Detail error message..."
}
```

## Get All Order

Endpoint : GET /api/orders
Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "status" : 1,
  "data" : [
    {
      "id" : 1,
      "total" : 200000,
      "order_date" : "10-10-2023 10:23:33"
    }
  ]
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Detail error message..."
}
```

## Get Order Detail
Endpoint : GET /api/orders/{id}
Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "status" : 1,
  "data" : [
    {
      "id" : 1,
      "order_id" : 2,
      "product_id" : 1,
      "user_id" : 3,
      "qty" : 4,
      "sub_total" : 450000
    }
  ]
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Detail error message..."
}
```

## Remove Order

Endpoint : DELETE /api/orders/{id}
Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "status" : 1,
  "message" : "OK"
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Error Detail Message"
}
```