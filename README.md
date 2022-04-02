# User API

User API permite la creación de usuarios y consultar todos los usuarios registrados. Está escrito en Java 11 y utiliza spring boot.

## Descargar

Descargar las fuentes desde el repositorio:

```bash
git clone https://github.com/rix158/test-user-api.git
```

## Uso
Ingresar al directorio de las fuentes
```java
cd ../../user

# Ejecutar
mvn spring-boot:run

# O ejecutar
./mvnw spring-boot:run

# Verificar localmente en:
http://localhost:8089/api/user/swagger-ui/index.html

# Testear los métodos
POST /api/create
GET /api/retrieve
```

## Datos de prueba
```json
{
"name": "Pedro Perez",
"email": "pprez@gmail.com",
"password": "Mundoc#o1",
"phones": [
{
"number": "099099234",
"cityCode": "7",
"countryCode": "593"
}
]
}
```


## Desarrollador
Ricardo Armijos
