# Flight Search API

This repository contains the backend API for a Flight Search application. The goal is to develop a robust backend capable of handling flight information, airports, and providing efficient search functionality.

## Project Overview

### Data Modeling

Design and model the information to be stored in the database. Any relational (SQL) or NoSQL database can be utilized.

#### Flight Information
- ID
- Departure Airport
- Arrival Airport
- Departure Date/Time
- Return Date/Time
- Price

#### Airports
- ID
- City

### CRUD Operations

Implement a CRUD (Create, Read, Update, Delete) structure for the database. This ensures the consistent and organized management of data.

#### CRUD Resources
- Flights
- Airports

### Search API

Create an API endpoint that lists flights based on the provided departure location, arrival location, departure date, and return date (if applicable).

- One-way flights should display a single set of flight information.
- Round-trip flights should display two sets of flight information.

### RESTful Service

Expose services using the REST architecture to facilitate easy data exchange and system integration.

### Authentication

Implement an authentication structure to verify user identity and grant authorization. Choose an appropriate authentication architecture for enhanced security.

### Scheduled Background Jobs

Set up a scheduled job that daily requests a mock third-party API to retrieve flight information and stores it in the database.

### Documentation

Create API documentation using Swagger.

You can access the API through the following link: [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/).

You can provide authorization by using "John Doe" as the name and "password1" as the password or another user from database.
