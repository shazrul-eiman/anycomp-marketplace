# Anycomp Marketplace API

Spring Boot marketplace application developed for ST COMP Holdings backend developer assessment.

## Project Overview

This project implements a RESTful API for a marketplace platform where buyers can purchase items from sellers. The application demonstrates advanced Spring Boot development with comprehensive business logic, validation, and documentation.

## Features

### Core Functionality

- **Buyer Management** - Complete CRUD operations for buyer accounts
- **Seller Management** - Complete CRUD operations for seller accounts
- **Item Management** - Product catalog with inventory tracking
- **Purchase Transactions** - Secure purchase processing with automatic inventory management

### Advanced Features

- ✅ **Input Validation** - Bean validation with custom business rules
- ✅ **DTOs** - Clean API contracts with PurchaseRequest and ItemDTO
- ✅ **Inventory Management** - Automatic stock deduction and validation
- ✅ **Error Handling** - Comprehensive error responses
- ✅ **Database Relationships** - Proper JPA entity relationships

## 🛠 Technology Stack

- **Java 19** (Compatible with Java 17+)
- **Spring Boot 3.5.3** - Main framework
- **Spring Data JPA** - Data persistence
- **PostgreSQL 17.5** - Database
- **Maven** - Build tool
- **OpenAPI 3.0** - API documentation
- **Bean Validation** - Input validation

## 📊 Database Schema

### Entity Relationships

```
Buyer (1) ←→ (Many) Purchase (Many) ←→ (1) Item (Many) ←→ (1) Seller
```

### Entities

- **Buyer**: id, name, email, purchasedItems
- **Seller**: id, name, email, items
- **Item**: id, name, description, price, quantity, seller
- **Purchase**: id, buyer, item, quantity

## 🔧 Setup Instructions

### Prerequisites

- Java 17 or higher
- PostgreSQL 17.x
- Maven 3.6+

### Database Setup

1. Create PostgreSQL database:

```sql
CREATE DATABASE any_market;
```

2. Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/any_market
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Running the Application

```bash
# Clone the repository
git clone https://github.com/shazrul-eiman/anycomp-marketplace.git
cd anycomp-marketplace

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📖 API Documentation

### Swagger UI

Access API documentation at:

```
http://localhost:8080/swagger-ui/index.html
```

### API Endpoints

#### Buyers

- `GET /buyers` - List all buyers
- `GET /buyers/{id}` - Get buyer by ID
- `POST /buyers` - Create new buyer
- `PUT /buyers/{id}` - Update buyer
- `DELETE /buyers/{id}` - Delete buyer

#### Sellers

- `GET /sellers` - List all sellers
- `GET /sellers/{id}` - Get seller by ID
- `POST /sellers` - Create new seller
- `PUT /sellers/{id}` - Update seller
- `DELETE /sellers/{id}` - Delete seller

#### Items

- `GET /items` - List all items
- `GET /items/{id}` - Get item by ID
- `POST /items` - Create new item
- `PUT /items/{id}` - Update item
- `DELETE /items/{id}` - Delete item

#### Purchases

- `POST /purchase` - Create purchase transaction
- `GET /purchase` - List all purchases
- `GET /purchase/{id}` - Get purchase by ID

### Sample API Calls

#### Create Seller

```bash
curl -X POST http://localhost:8080/sellers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "TechStore Electronics",
    "email": "contact@techstore.com"
  }'
```

#### Create Item

```bash
curl -X POST http://localhost:8080/items \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Gaming Laptop",
    "description": "High-performance gaming laptop",
    "price": 1299.99,
    "quantity": 10,
    "seller": {"id": 1}
  }'
```

#### Make Purchase

```bash
curl -X POST http://localhost:8080/purchase \
  -H "Content-Type: application/json" \
  -d '{
    "buyerId": 1,
    "itemId": 1,
    "quantity": 2
  }'
```

## Architecture

### Project Structure

```
src/main/java/com/example/anycompmarketplace/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── dto/            # Data Transfer Objects
├── model/          # JPA entities
├── repository/     # Data repositories
└── service/        # Business logic
```

### Design Patterns

- **Repository Pattern** - Data access abstraction
- **DTO Pattern** - Clean API contracts
- **Service Layer** - Business logic separation
- **Dependency Injection** - Loose coupling

## Validation & Error Handling

### Input Validation

- Email format validation
- Required field validation
- Numeric range validation
- Custom business rule validation

### Error Responses

- `400 Bad Request` - Invalid input data
- `404 Not Found` - Resource not found
- `500 Internal Server Error` - Server errors

## Business Logic

### Purchase Transaction Flow

1. Validate buyer exists
2. Validate item exists and has sufficient quantity
3. Deduct quantity from item inventory
4. Create purchase record
5. Return purchase confirmation

### Inventory Management

- Automatic stock deduction on purchase
- Quantity validation before transaction
- Error handling for insufficient stock
