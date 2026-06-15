# gRPC Product Service

## Overview

This project demonstrates the implementation of a client-server architecture using **Java**, **Spring Boot**, and **gRPC**.

The application exposes a Product microservice that allows clients to:

- Retrieve a product by its identifier.
- Retrieve multiple products in a single request.
- Exchange data efficiently through Protocol Buffers (Protobuf).

This project was developed as part of a study project focused on distributed systems and microservice communication.

---

## Architecture

```
grpc-product-service
│
├── tp5-server
│   ├── Spring Boot Application
│   ├── gRPC Product Service
│   └── Product Repository
│
└── tp5-client
    ├── Spring Boot Client
    └── gRPC Requests
```

---

## Technologies

- Java 17
- Spring Boot
- gRPC
- Protocol Buffers (Protobuf)
- Maven

---

## Features

### Get Product

Retrieve a product using its ID.

Example:

```text
ID: 1
Name: Product 1
Price: 10.0
```

### List Products

Retrieve multiple products in a single request.

Example:

```text
IDs: [1,2,3]
```

Returns:

```text
Product 1
Product 2
Product 3
```

---

## Project Structure

### Server

Contains:

- Product entity
- ProductMicroService implementation
- gRPC endpoints
- Spring Boot configuration

### Client

Contains:

- gRPC client configuration
- Requests to server services
- Response processing

---

## Build

```bash
mvn clean install
```

---

## Run Server

```bash
cd tp5-server
mvn spring-boot:run
```

---

## Run Client

```bash
cd tp5-client
mvn spring-boot:run
```

---

## Learning Objectives

- Build a microservice with gRPC.
- Use Protocol Buffers for service definitions.
- Implement client-server communication.
- Integrate gRPC with Spring Boot.

---

## Author

Chayma Mrait
