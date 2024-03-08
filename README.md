# Springboot JWT Authentication

This repository contains a sample Spring Boot application demonstrating JWT (JSON Web Token) authentication.

## Features

- User registration and authentication using JWT tokens.
- RESTful API endpoints for user management (registration, login).
- Token-based authentication for accessing protected resources.

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/faisal-sey/Springboot-JWT-Authentication.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Springboot-JWT-Authentication
   ```

3. Build the project:

   ```bash
   mvn clean package
   ```

4. Run the application:

   ```bash
   java -jar target/springboot-jwt-authentication.jar
   ```

5. Access the application at `http://localhost:8080`.

## Usage

### Registration

To register a new user, send a POST request to `/api/v1/auth/register` with the following JSON payload:

```json
{
  "username": "example",
  "email": "example@example.com",
  "password": "password"
}
```

### Authentication

To authenticate a user and obtain a JWT token, send a POST request to `/api/v1/auth/authenticate` with the following JSON payload:

```json
{
  "username": "example",
  "password": "password"
}
```

The response will contain an access token which can be used to access protected resources.

## Dependencies

- Spring Boot
- Spring Security
- JSON Web Tokens (JWT)
- Maven

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
