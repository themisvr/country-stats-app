# Country Stats Application

This is a full-stack web application designed to display country statistics (population, GDP) based on various search criteria, including year ranges and regions. The application consists of an Angular frontend, a Spring Boot backend, and a MariaDB database.

Prerequisites
Before you begin, ensure you have the following installed on your system:

**Docker and Docker compose**

You will also need a .env file at the same directory level as the docker-compose.yml file. The .env must contain the below variables:

```
SPRING_PROFILES_ACTIVE=docker
DB_DATABASE=nation
DB_USERNAME=[username]
DB_PASSWORD=[password]
DB_ROOT_PASSWORD=[a root password for mariadb]
```

Executing the command:

```
docker-compose up --build -d
```

the images will be built and all services will start.

Frontend (Angular): Open your web browser and go to http://localhost:4200

Backend (Spring Boot API): The backend API will be accessible internally within the Docker network at http://spring-backend:8080/api. If you need to access it directly from your host machine (e.g., for testing with Postman), it will be available at http://localhost:8080/api.