# Crear una persona
http://localhost:8080/api/person

[
    {
        "dni": "1234abcd",
        "firstName": "Carlos",
        "lastName": "Ortiz",
        "age": 25,
        "address": "Calle 12 #45-67",
        "emailAddress": "carlos.ortiz@mail.com",
        "cellNumber": 3104567890,
        "createAt": null
    },
    {
        "dni": "5678efgh",
        "firstName": "Lucia",
        "lastName": "Ramirez",
        "age": 28,
        "address": "Carrera 15 #8-23",
        "emailAddress": "lucia.ramirez@mail.com",
        "cellNumber": 3145671234,
        "createAt": null
    },
    {
        "dni": "9101ijkl",
        "firstName": "Daniel",
        "lastName": "Mendez",
        "age": 32,
        "address": "Avenida 9 #24-80",
        "emailAddress": "daniel.mendez@mail.com",
        "cellNumber": 3206549871,
        "createAt": null
    },
    {
        "dni": "1121mnop",
        "firstName": "Sofia",
        "lastName": "Gomez",
        "age": 30,
        "address": "Calle 8A #12-34",
        "emailAddress": "sofia.gomez@mail.com",
        "cellNumber": 3187654321,
        "createAt": null
    },
    {
        "dni": "3141qrst",
        "firstName": "Miguel",
        "lastName": "Lopez",
        "age": 40,
        "address": "Carrera 7 #6-78",
        "emailAddress": "miguel.lopez@mail.com",
        "cellNumber": 3134567890,
        "createAt": null
    }
]


#Actualizar nombre y apellido

PUT http://localhost:8080/api/person

{
    "id": "123e4567e89b12d3a4564266",
    "dni": "1234abcd",
    "firstName": "Carlos",
    "lastName": "Martinez",
    "age": 25,
    "address": "Calle 12 #45-67",
    "emailAddress": "carlos.ortiz@mail.com",
    "cellNumber": 3104567890,
    "createAt": null
}

#Actualizar parcialmente

http://localhost:8080/api/person/PartialUpdate

{
    "id": "123e4567e89b12d3a4564266",
    "fieldsToUpdate": {
        "firstName": "Carlos",
        "lastName": "Martinez"
    }
}


#Búsqueda parcial

http://localhost:8080/api/person/Search

{
    "criteria": "Ram",
    "field": "lastName",
    "results": [
        {
            "dni": "5678efgh",
            "firstName": "Lucia",
            "lastName": "Ramirez",
            "age": 28,
            "address": "Carrera 15 #8-23",
            "emailAddress": "lucia.ramirez@mail.com",
            "cellNumber": 3145671234,
            "createAt": null
        }
    ]
}


# Actualizar Celular.

http://localhost:8080/api/person

{
  "id":"441c3a18e664b291cd35ab1c",
  "dni":"",
 "firstName":"",
 "lastName":"",
 "age":"" ,
 "address":"",
  "emailAddress":"",
  "cellNumber": 3004871325,
    "createAt":null
}


# Actualizar Dirección.

http://localhost:8080/api/person/Address


{
    "dni": "321lkj",
    "firstName": "Fabian",
    "lastName": "Acosta",
    "age": 37,
    "address": "Calle 5 # 5 - 76",
    "emailAddress": "fabian@outlook.com",
    "cellNumber": 3212038796,
    "createAt": null
}

# Actualizar Correo

http://localhost:8080/api/person/Email

{
        "id": "247a4b96a982c7418ff32483",
        "dni": "7845frog",
        "firstName": "Alonso",
        "lastName": "Marin",
        "age": 34,
        "address": "Avenida siempre viva",
        "emailAddress": "alonso@correo.com",
        "cellNumber": 3006587447,
        "createAt": null
}


# Eliminar una persona

Con el siguiente http del metodo `DELETE` `http://localhost:8080/api/person/

{
        "dni": "6548hgt",
        "firstName": "Jerry",
        "lastName": "Kravit",
        "age": 46,
        "address": "Calle 90 # 57c - 43",
        "emailAddress": "jekra@correo.com",
        "cellNumber": 3234512989,
        "createAt": null
}


#Buscar por ID.
http://localhost:8080/person/1234abcd

{
    "id": "123e4567e89b12d3a4564266",
    "dni": "1234abcd",
    "firstName": "Carlos",
    "lastName": "Martinez",
    "age": 25,
    "address": "Calle 12 #45-67",
    "emailAddress": "carlos.ortiz@mail.com",
    "cellNumber": 3104567890,
    "createAt": "2024-12-01T10:30:00Z"
}


#Buscar y reemplazar todos los nombre en mayúsculas.
http://localhost:8080/api/person/AllUpperCase

[
    {
        "id": "123e4567e89b12d3a4564266",
        "dni": "1234abcd",
        "firstName": "CARLOS",
        "lastName": "MARTINEZ",
        "age": 25,
        "address": "Calle 12 #45-67",
        "emailAddress": "carlos.ortiz@mail.com",
        "cellNumber": 3104567890,
        "createAt": "2024-12-01T10:30:00Z"
    },
    {
        "id": "321e4567e89b12d3a4561234",
        "dni": "5678efgh",
        "firstName": "XIMENA",
        "lastName": "GAMBOA",
        "age": 29,
        "address": "Calle 43",
        "emailAddress": "ximega@gmail.com",
        "cellNumber": 3206081037,
        "createAt": "2024-12-01T10:35:00Z"
    }
    // Otros registros seguirán igual pero con nombres y apellidos en mayúsculas
]


#Buscar y poner todos los nombre en mayúsculas y repertir las letras.
http://localhost:8080/api/person/AllUpperCaseRepeat

[
    {
        "id": "123e4567e89b12d3a4564266",
        "dni": "1234abcd",
        "firstName": "CCCAARRLLOOSS",
        "lastName": "MMAARRTTIINNEEZZ",
        "age": 25,
        "address": "Calle 12 #45-67",
        "emailAddress": "carlos.ortiz@mail.com",
        "cellNumber": 3104567890,
        "createAt": "2024-12-01T10:30:00Z"
    },
    {
        "id": "321e4567e89b12d3a4561234",
        "dni": "5678efgh",
        "firstName": "XXIIMMEEENNAA",
        "lastName": "GGAAMMBBooAA",
        "age": 29,
        "address": "Calle 43",
        "emailAddress": "ximega@gmail.com",
        "cellNumber": 3206081037,
        "createAt": "2024-12-01T10:35:00Z"
    }
    // Otros registros seguirán igual pero con los cambios en el nombre y apellido
]

