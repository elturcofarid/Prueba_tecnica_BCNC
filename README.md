# Prueba Técnica BCNC

## 📋 Descripción
API REST para la gestión de precios de productos, implementando una arquitectura hexagonal y siguiendo las mejores prácticas de desarrollo.

## 🛠️ Tecnologías Utilizadas

### Backend Framework
- **Spring Boot** 
  - Spring Web (REST APIs)
  - Spring Data JPA
  - H2 Database (In-memory database)

### Testing Tools
- **JUnit 5** - Framework de testing
- **Mockito** - Framework de mocking
- **MockMvc** - Testing de integración para APIs REST

## 🏗️ Arquitectura

### Arquitectura Hexagonal (Ports and Adapters)
La aplicación está estructurada siguiendo el patrón de arquitectura hexagonal:

```plaintext
src/
├── adapter/
│   ├── in/
│   │   └── rest/    # Adaptadores primarios (REST Controllers)
│   └── out/         # Adaptadores secundarios
├── domain/          # Lógica de negocio
│   ├── model/
│   ├── repository/
│   └── service/
└── infrastructure/  # Implementaciones técnicas
    ├── persistence/
    └── repository/
```


## 📚 API Documentation
### Endpoint: GET /api/producto/precio
Obtiene el precio de un producto según la fecha y cadena especificada.

Parámetros:

- fecha : Fecha de consulta (formato: yyyy-MM-dd-HH.mm.ss)
- idProducto : ID del producto
- idCadena : ID de la cadena
Ejemplo de respuesta:


{
    "precio": 35.50,
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "fechaAplicacion": "2020-06-14-10.00.00"
}


## 🚀 Instalación y Ejecución

# Clonar el repositorio
git clone https://github.com/elturcofarid/Prueba_tecnica_BCNC

# Navegar al directorio
cd Prueba_tecnica_BCNC

# Compilar el proyecto
./mvnw clean install

# Ejecutar la aplicación
./mvnw spring-boot:run


mvn clean verify sonar:sonar \
  -Dsonar.projectKey=Prueba-BCNC2 \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=sqp_d734e25350968beb4627d211e314bf132b147694
