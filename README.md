# JSF Inventory Management - JDBC & PostgreSQL

Aplicación web desarrollada con **JSF puro** y **JDBC**, que implementa funcionalidades de gestión de productos, inventario y reportes de ventas sobre una base de datos PostgreSQL. Ideal para demostración de habilidades en Java web clásico y acceso a datos.

## Resumen

Esta aplicación permite:

- Buscar productos por nombre, categoría o precio mínimo.  
- Consultar detalles de un producto.  
- Listar productos con bajo stock.  
- Generar reportes de productos más vendidos por mes.

Está desarrollada con JSF puro, sin Spring ni JPA. La persistencia se realiza mediante JDBC directo sobre PostgreSQL.

## Requisitos

- Java 17  
- Maven 3.8+  
- Docker y Docker Compose  
- Apache Tomcat 10+ o Payara Server  
- PostgreSQL JDBC Driver (configurado en `pom.xml`)

## Base de datos

Para levantar la base de datos:

```bash
cd db
docker compose up -d
```

El contenedor expone el puerto 5433 en el host.
Credenciales por defecto:
```text
USER: admin
PASSWORD: admin123
DB: rendimiento_sophyfarm_db
```

Para inicializar los datos:
```bash
python db/initdb/seed.py
Configuración de conexión JDBC
```

Archivo: src/main/resources/db.properties
```properties
db.url=jdbc:postgresql://localhost:5433/rendimiento_sophyfarm_db
db.user=admin
db.password=admin123
db.driver=org.postgresql.Driver
```

Clase de conexión (ConexionDB.java):
```java
Connection conn = DriverManager.getConnection(url, user, pass);
```

## Ejecución del proyecto
1. Levantar la base de datos
```bash
cd db
docker compose up -d
```
2. Poblar la base de datos
```bash
python db/initdb/seed.py
```

3. Compilar el proyecto
```bash
mvn clean package
```
Generará un archivo .war en:
target/Escenario2-Rendimiento.war


4. Desplegar en Tomcat
```cmd
copy Escenario2-Rendimiento\target\Escenario2-Rendimiento-1.0-SNAPSHOT.war Escenario2-Rendimiento\apache-tomcat-10.1.8\bin
Escenario2-Rendimiento\apache-tomcat-10.1.8\bin\startup.bat
```

Acceder desde el navegador:

```arduino
http://localhost:8080/Escenario2-Rendimiento/
```

Para detener Tomcat:
```cmd
Escenario2-Rendimiento\apache-tomcat-10.1.8\bin\shutdown.bat
```
