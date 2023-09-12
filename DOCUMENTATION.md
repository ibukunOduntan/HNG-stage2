# Zuri API Documentation

This document provides information on how to use the Zuri API. The Zuri API allows you to perform CRUD (Create, Read, Update, Delete) operations on "Person" entities.

## Table of Contents

- [Endpoints](#endpoints)
- [Standard Formats](#standard-formats)
- [Sample Usage](#sample-usage)
- [Limitations and Assumptions](#limitations-and-assumptions)
- [Setting up and Deploying the API](#setting-up-and-deploying-the-api)

## Endpoints

The Zuri API provides the following endpoints:

- `POST /api`: Create a new person.
- `GET /api`: Retrieve a person by their name.
- `PUT /api`: Update a person's name.
- `DELETE /api`: Delete a person by their name.

## Standard Formats

### Request Format

#### Creating a Person (POST /api)

To create a new person, make a POST request to `/api` with the following JSON request body:

    ```json
    {
    "name": "John"
    }

### Retrieving a Person (GET /api)

To retrieve a person by their name, make a GET request to /api with the name query parameter.

### Updating a Person (PUT /api)
To update a person's name, make a PUT request to /api with the name query parameter and the following JSON request body:

    {
      "name": "NewName"
    }

### Deleting a Person (DELETE /api)
To delete a person by their name, make a DELETE request to /api with the name query parameter.

## Response Format
The API responds with JSON for successful requests.

For successful operations (e.g., creation, retrieval, update, deletion), the API returns a JSON response with an HTTP status code of 200 OK. The response includes relevant data pertaining to the operation. Here's an example of a successful response when deleting a person:

    {
    "message": "Person name John deleted successfully"
    }
For error responses (e.g., bad request, not found), the API returns a JSON object with an error message. For instance, in the case of a bad request:

    {
      "error": "Bad Request: Name must be a non-null, non-integer string!"
    }
    

## Sample Usage
### Creating a Person
Request:

    curl -X POST http://https://hng-stage2.onrender.com/api -H "Content-Type: application/json" -d '{"name": "John"}'
    
Response (Success):

    {
    "message": "Person, John created successfully"
    }
Response (Conflict, if a person with the same name already exists.):

      {
    "error": "Person with the same name already exists"
      }
Response (Conflict, if bad input. Thhe same for all requests):

      {
    "error": "Name must be a non-null, non-integer string!"
      }
  
### Retrieving a Person
Request:

    curl -X GET http://https://hng-stage2.onrender.com/api?name=John

Response (Success):

    {
      "id": 1,
      "name": "John"
    }

### Updating a Person
Request:

    curl -X PUT http://https://hng-stage2.onrender.com/api?name=John -H "Content-Type: application/json" -d '{"name": "NewName"}'

Response (Success):

    {
      "id": 1,
      "name": "NewName"
    }

Response (Not Found, if the person does not exist):

    {
      "error": "Person does not exist"
    }
### Deleting a Person
Request:

    curl -X DELETE http://https://hng-stage2.onrender.com/api?name=John

Response (Success):

    {
      "message": "Person name John deleted successfully"
    }

Response (Not Found, if the person does not exist):

    {
      "error": "Person does not exist"
    }

## Limitations and Assumptions
The API assumes that names must be non-null and non-integer strings. It validates this assumption for all endpoints.

The API returns JSON responses for successful and error cases. Error responses include descriptive error messages.

## Setting up and Deploying the API
See README.md



