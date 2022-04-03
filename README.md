# User API

User API permite la creación de usuarios y consultar todos los usuarios registrados. Está escrito en Java 11 y utiliza spring boot.

## Descargar

Descargar las fuentes desde el repositorio:

```bash
git clone https://github.com/rix158/test-user-api.git
```
## Database
La base de datos embebida es una H2 (memoria) que se levanta junto con el proyecto

## Uso
Ingresar al directorio de las fuentes
```java
cd ../../user
maven package

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
## Configuración de parámetros (expresiones regulares)

Se puede parametrizar en el archivo application.properties
Por ejemplo parametrizar el valor de la expresión:

```java
app.pass.valid.regex=^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()?[{}]:;',?/*~$^+=<>]).{5,10}$
```


## Desarrollador
Ricardo Armijos
