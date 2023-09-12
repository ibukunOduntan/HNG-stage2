# API Documentation

## Overview

This document provides information on how to use the API endpoints, standard request and response formats, sample usage, and instructions for setting up and deploying the API.

### Base URL

```
https://hng-stage2.onrender.com/api
```

## Endpoints

### 1. Create a Person

#### Endpoint

```
POST /
```

#### Request Format

- **Request Body:**

```json
{
  "name": "John Doe",
}
```

#### Response Format

- **Success Response (HTTP Status Code: 201 Created):**

```json
{
  "id": 1,
  "name": "John Doe",
}
```

- **Error Response (HTTP Status Code: 400 Bad Request):**

```json
{
  "error": "Name must be a non-null, non-integer string!"
}
```

### 2. Get a Person by ID

#### Endpoint

```
GET /{id}
```

#### Request Format

- **URL Parameters:**

  - `id` (integer) - The ID of the person to get.

#### Response Format

- **Success Response (HTTP Status Code: 200 OK):**

```json
{
  "id": 1,
  "name": "John Doe",
}
```

- **Error Response (HTTP Status Code: 404 Not Found):**

```json
{
  "error": "Person not found"
}
```

### 3. Update a Person by ID

#### Endpoint

```
PUT /{id}
```

#### Request Format

- **URL Parameters:**

  - `id` (integer) - The ID of the person to update.

- **Request Body:**

```json
{
  "name": "Updated Name",
}
```

#### Response Format

- **Success Response (HTTP Status Code: 200 OK):**

```json
{
  "message": "Person updated successfully",
  "updatedDetails": {
    "id": 1,
    "name": "Updated Name",
  }
}
```

- **Error Response (HTTP Status Code: 404 Not Found):**

```json
{
  "error": "Person not found"
}
```

### 4. Delete a Person by ID

#### Endpoint

```
DELETE /{id}
```

#### Request Format

- **URL Parameters:**

  - `id` (integer) - The ID of the person to delete.

#### Response Format

- **Success Response (HTTP Status Code: 200 OK):**

```json
{
  "message": "User deleted successfully",
  "deleted_user": {
    "id": 1,
    "name": "Updated Name",
  }
}
```

- **Error Response (HTTP Status Code: 404 Not Found):**

```json
{
  "error": "Person not found"
}
```

## Sample Usage

Here are some sample requests and expected responses using postman:

### Create a Person

**Request:**

```http
POST https://hng-stage2.onrender.com/api

Content-Type: raw/json

{
  "name": "John Doe",
}
```

**Response (201 Created):**

```json
{
  "id": 1,
  "name": "John Doe",
}
```

### Get a Person by ID

**Request:**

```http
GET https://hng-stage2.onrender.com/api/1
```

**Response (200 OK):**

```json
{
  "id": 1,
  "name": "John Doe",
}
```

### Update a Person by ID

**Request:**

```http
PUT https://hng-stage2.onrender.com/api/1
Content-Type: raw/json

{
  "name": "Updated Name",
}
```

**Response (200 OK):**

```json
{
  "message": "Person updated successfully",
  "updatedDetails": {
    "id": 1,
    "name": "Updated Name",
  }
}
```

### Delete a Person by ID

**Request:**

```http
DELETE https://hng-stage2.onrender.com/api/1
```

**Response (200 OK):**

```json
{
  "message": "User deleted successfully",
  "deleted_user": {
    "id": 1,
    "name": "Updated Name",
  }
}
```

## Known Limitations

- This API does not include authentication and authorization mechanisms. Consider implementing them for production use.

## Setup and Deployment

### Prerequisites
-Java 17 or higher
-Spring boot 3
-PostgreSQL 15 database
-Maven (for building and managing dependencies)


To set up and deploy the API locally or on a server, follow these steps:

1. Clone the repository: `git clone https://github.com/ibukunOduntan/HNG-stage2.git`

2. Build the project: `mvn clean install`

3. Configure the application

The configuration for this API is stored in the `application.properties` file. To configure the API or make changes to its behavior, you can edit this file. Here's how:

1. Navigate to the directory where the `application.properties` file is located.

2. Open `application.properties` in a text editor of your choice.

3. Modify the configuration settings as needed. Common configurations include database connection details, server port, or API secret keys.

Example `application.properties`:

```properties
 server.port= PORT
    # Database configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.datasource.username=username
    spring.datasource.password=password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
  
   

4. Run the API by using the application jar file in the target folder: `java -jar target/application-name.jar`

5. The API will be accessible at `http://localhost:PORT`, where `PORT` is the port you specified in your application.properties file.

