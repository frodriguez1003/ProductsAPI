# ProductsAPI

ProductsAPI is a simple spring boot API that retrieves products.

This API uses an embedded H2 database in which data is loaded from resources/schema.sql file

## Compilation

Use gradle to compile the project.

```bash
gradle clean build
```

## Running Application
```bash
gradle bootRun
```

## Usage

Go to http://localhost:8080/productsapi-swagger.html, it is possible to find the API definition there.

Bear in mind that the API has pagination, which starts from 0.