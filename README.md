# HNG-stage2
HNG Internship backend task stage two

This is a RESTful API built with Spring Boot that allows you to manage user data.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Testing](#testing)


## Prerequisites
-Java 17 or higher
-Spring boot 3
-Render
-PostgreSQL 15 database
-Maven (for building and managing dependencies)

## Getting Started

### Installation
To get started with this API, follow these steps:

1. Clone the repository to your local machine.
2. Run `mvn clean install` to build the project.

### Configuration

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


### Running the application
1. Package your application in a jar file using

        ```mvn clean package
   
3. Test the package by using the command:
   
        ```java -jar your-application.jar
   

## Usage

This API allows you to perform various operations related to user data.

- Creating a new user: `POST /api`
- Retrieving a user by name: `GET /api/{id}`
- Updating a user's information: `PUT /api/{id}`
- Deleting a user: `DELETE /api/{id}`


## Endpoints

- **Create a new user:**

  - URL: `/api`
  - Method: `POST`
  - Request Body: JSON with a `name` field. e.g

                {
            "name" : "Danny"
                }
    
  - Response: JSON with a success message or error message.

- **Retrieve a user by name:**

  - URL: `/api/{id}`
  - Method: `GET`
  - Response: JSON containing user information or an error message.

- **Update a user's information:**

  - URL: `/api/{id}`
  - Method: `PUT`
  - Request Body: JSON with updated user information. e.g
 
          {
            "name" : "Danny"
            }
  - Response: JSON with a success message or error message.

- **Delete a user:**

  - URL: `/api/{id}`
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



