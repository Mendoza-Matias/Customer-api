# Customer/Api

This is a simple application designed for practicing with Spring Boot. It implements a basic CRUD (Create, Read, Update, Delete) functionality for customers. With this application, you can create a new customer, edit customer details, display a list of all customers, and delete a customer.

## Quick use

- Create the customer database.
- Connect the database to the Spring application.
- Use Postman to test the API.

1. **Get all customers:**
   - Endpoint: `http://localhost:8080/api/customer`
   - Method: `GET`
   - Description: Retrieves all customers.
   - Example response:
   
     ```json
      {
        "name": "example",
        "lastName": "lastNameExample"
      }
     ```

2. **Create a new customer:**
   - Endpoint: `http://localhost:8080/api/customer`
   - Method: `POST`
   - Description: Creates a new customer.
   
   - Example Body:
     ```json
      {
        "name": "example",
        "lastName": "lastNameExample",
        "age": 20,
        "tel": 1170001025
      }
     ```

3. **Update a customer:**
   - Endpoint: `http://localhost:8080/api/customer/{customerId}`
   - Method: `PUT`
   - Description: Updates customer information.
   
   - Example Body:
     ```json
      {
        "name": "newexample",
        "lastName": "newlastNameExample",
        "age": 35,
        "tel": 1140802182
      }
     ```

4. **Delete a customer:**
   - Endpoint: `http://localhost:8080/api/{customerId}`
   - Method: `DELETE`
   - Description: Deletes a customer.
   
   - Example Body:
     ```json
      {
        "name": "newexample",
        "lastName": "newlastNameExample",
        "age": 35,
        "tel": 1140802182
      }
     ``` 
