# Wallet API Spec

## Create Wallet

Endpoint : POST /api/wallets

Request Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "name" : "Gopay",
  "balance" : 200000,
  "user_id" : 1
}
```

Response Body (Success) :
```json
{
  "status" : 1,
  "data" : {
    "name" : "OVO",
    "balance" : 300000,
    "user_id" : 2
  }
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Insert is not valid..."
}
```

## Update Wallet

Endpoint : PUT /api/wallets/{id}
Request Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "name" : "ShoppePay",
  "balance" : 250000,
  "user_id" : 4
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

## Get Wallet

Endpoint : GET /api/wallets/{id}
Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "status" : 1,
  "data" : {
    "name" : "ShoppePay",
    "balance" : 250000,
    "user_id" : 3
  }
}
```

Response Body (Failed) :
```json
{
  "status" : 0,
  "message" : "Detail error message..."
}
```

## Remove Wallet

Endpoint : DELETE /api/wallets/{id}
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