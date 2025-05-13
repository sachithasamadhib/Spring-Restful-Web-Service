# Spring-RESTFul-Web-Service

### Database Configuration

This project uses MySQL as the database. To configure the database connection:

1. Copy the template configuration file to create your local configuration:

```shellscript
cp src/main/resources/application.properties.template src/main/resources/application.properties
```


2. Edit `src/main/resources/application.properties` with your database credentials:

```plaintext
spring.datasource.url=jdbc:mysql://localhost:3306/<DBNAME>?createDatabaseIfNotExist=true
spring.datasource.username=<yourusername>
spring.datasource.password=<yourpassword>

```


3. Make sure your MySQL server is running and the database exists:

```sql
CREATE DATABASE IF NOT EXISTS <DBNAME>;
```