# HNG-stage2
HNG Internship backend task stage two

This is a RESTful API built with Spring Boot that allows you to manage user data.

## Table of Contents

- [Getting Started](#getting-started)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Testing](#testing)

- [Configuration](#configuration)

## Getting Started

To get started with this API, follow these steps:

1. Clone the repository to your local machine.
2. Install Java and Maven if not already installed.
3. Run `mvn clean install` to build the project.
4. Start the API using `mvn spring-boot:run`.

## Usage

This API allows you to perform various operations related to user data.

- Creating a new user: `POST /api`
- Retrieving a user by name: `GET /api?name=John`
- Updating a user's information: `PUT /api?name=John`
- Deleting a user: `DELETE /api?name=John`

Here's an example of creating a new user:

    curl -X POST http://localhost:8080/api -H "Content-Type: application/json" -d '{"name": "John"}'


## Endpoints

- **Create a new user:**

  - URL: `/api`
  - Method: `POST`
  - Request Body: JSON with a `name` field.
  - Response: JSON with a success message or error message.

- **Retrieve a user by name:**

  - URL: `/api?name=John`
  - Method: `GET`
  - Response: JSON containing user information or an error message.

- **Update a user's information:**

  - URL: `/api?name=John`
  - Method: `PUT`
  - Request Body: JSON with updated user information.
  - Response: JSON with a success message or error message.

- **Delete a user:**

  - URL: `/api?name=John`
  - Method: `DELETE`
  - Response: JSON with a success message or error message.

## Testing

You can use the provided Python test script (`test.py`) to test the API. Follow these steps to run the tests:

1. Make sure you have Python installed on your system.

2. Open a terminal and navigate to the directory containing `test.py`.

3. Modify the script if needed to specify the API endpoint or any test data.

4. Run the script using the following command:

   ```bash
   python test.py

## Configuration

The configuration for this API is stored in the `application.properties` file. To configure the API or make changes to its behavior, you can edit this file. Here's how:

1. Navigate to the directory where the `application.properties` file is located.

2. Open `application.properties` in a text editor of your choice.

3. Modify the configuration settings as needed. Common configurations include database connection details, server port, or API secret keys.

Example `application.properties`:

```properties
# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Server port
server.port=8080

# API secret key
api.secret.key=mysecretkey


