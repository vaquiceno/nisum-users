# Uso de las apis:

### Consulta:
http://localhost:8080/api/v1/user/all

Devuelve Todos los usuarios en la base de datos.

Retorna un json con esta estructura:
```json
[
  {
    "id": 1,
    "name": "pep1",
    "email": "pep1@aa.com",
    "password": "xx1",
    "phones": [
      {
        "id": 1,
        "number": "14560279",
        "citycode": "01",
        "countrycode": "01"
      },
      {
        "id": 2,
        "number": "62451458",
        "citycode": "02",
        "countrycode": "01"
      }
    ],
    "created": "2021-09-17T18:24:50.210+00:00",
    "modified": "2021-09-17T18:24:50.210+00:00",
    "last_login": "2021-09-17T18:24:50.210+00:00",
    "token": "token1",
    "isactive": false
  },
  {
    "id": 2,
    "name": "pep2",
    "email": "pep2@aa.com",
    "password": "xx2",
    "phones": [
      {
        "id": 3,
        "number": "3012499",
        "citycode": "03",
        "countrycode": "01"
      },
      {
        "id": 4,
        "number": "75445155",
        "citycode": "04",
        "countrycode": "01"
      }
    ],
    "created": "2021-09-17T18:24:50.220+00:00",
    "modified": "2021-09-17T18:24:50.220+00:00",
    "last_login": "2021-09-17T18:24:50.220+00:00",
    "token": "token2",
    "isactive": false
  },
  {
    "id": 3,
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.orsg",
    "password": "Hunter12",
    "phones": [
      {
        "id": 5,
        "number": "3012499",
        "citycode": "03",
        "countrycode": "01"
      }
    ],
    "created": "2021-09-17T18:24:54.897+00:00",
    "modified": "2021-09-17T18:24:54.897+00:00",
    "last_login": "2021-09-17T18:24:54.897+00:00",
    "token": "dacc7e35-7a94-4d4d-8f58-84c40b8ace3a",
    "isactive": false
  }
]
```

### Creación:
http://localhost:8080/api/v1/user/add

Crea un nuevo usuario en la base de datos.

Se envia un json con esta estructura:
```json
{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.orsg",
  "password": "Hunter12",
  "phones": [
    {
      "number": "3012499",
      "citycode": "03",
      "countrycode": "01"
    }
  ]
}
```
Retorna un json con esta estructura:
```json
{
"id": 3,
"name": "Juan Rodriguez",
"email": "juan@rodriguez.orsg",
"password": "Hunter12",
"phones": [
{
"id": 5,
"number": "3012499",
"citycode": "03",
"countrycode": "01"
}
],
"created": "2021-09-17T18:24:54.897+00:00",
"modified": "2021-09-17T18:24:54.897+00:00",
"last_login": "2021-09-17T18:24:54.897+00:00",
"token": "dacc7e35-7a94-4d4d-8f58-84c40b8ace3a",
"isactive": false
}
```

### Validaciones api de Creación:

Si el correo ya esta mal formado, retorna:
```json
{
  "mensaje": "El correo esta mal formado"
}
```

Si la Clave no cumple con los estándares, retorna:
```json
{
  "mensaje": "La Clave debe tener una mayuscula, letras minusculas y dos numeros"
}
```

Si el correo ya esta registrado, retorna:
```json
{
  "mensaje": "El correo ya registrado"
}
```