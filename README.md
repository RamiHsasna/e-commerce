# E-Commerce Project

This project is a full-stack e-commerce application designed to provide a comprehensive shopping platform. It utilizes Angular for the front-end, Spring Boot for the back-end, and PostgreSQL for database management.

## Features

- User authentication and authorization
- Product listing with search and filter capabilities
- Shopping cart and checkout process
- Order history and tracking

## Technologies

- **Front-End:** Angular
- **Back-End:** Spring Boot
- **Database:** PostgreSQL
- **Security:** JWT for authentication
- **API Documentation:** Swagger

## Getting Started

### Prerequisites

- Node.js and npm
- Java JDK 11 or later
- PostgreSQL

### Setting Up the Development Environment

1. **Clone the repository**

git clone https://github.com/ramihsasna/e-commerce.git

2. **Access the front end**

cd front-end
npm install
ng serve

3. **Access the back end**

cd ../back-end
./mvnw package
./mvnw spring-boot:run

4. **Database setup**

Ensure PostgreSQL is running and create a database named ecommerce. Update the application.properties file in the Spring Boot project with your database credentials.

Accessing the Application
The front-end application will be available at http://localhost:4200
The back-end API can be accessed at http://localhost:8080
