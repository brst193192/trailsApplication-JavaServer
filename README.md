# Trails – Hiking Trails Website (Java Server)

The **Java Spring Boot** server implementation of the hiking trails website. It exposes the same REST API as the [.NET server](https://github.com/brst193192/trailsApplication), so the same **React + Redux** client works with either backend.

## Features

- Trails CRUD – list, add, update and delete trails
- Favorites – add / remove a favorite and get a user's favorites
- **Hot trails** – the most popular trails
- User registration and login

## Architecture

```
src/main/java/com/example/server_side/
├── Controllers   # REST controllers: Trail, User, Favorite
├── Service       # Business logic
├── Repository    # Spring Data JPA repositories
├── Models        # JPA entities
├── DTO           # Data transfer objects
└── Converters    # Entity ↔ DTO converters
```

## Tech Stack

- Java 21, Spring Boot 3.4
- Spring Data JPA (Hibernate)
- H2 database (file-based, with the H2 web console)
- Maven

## API

| Method | Endpoint | Description |
|---|---|---|
| GET | `/trails/getAll` | All trails |
| POST | `/trails/add` | Add a trail |
| PUT | `/trails/update` | Update a trail |
| DELETE | `/trails/delete/{id}` | Delete a trail |
| GET | `/favorites/getMyFavorites/{id}` | User's favorite trails |
| PUT | `/favorites/changeStatus/{userId}/{trailId}` | Add / remove a favorite |
| GET | `/favorites/hotTrails` | Most popular trails |
| GET | `/users/all` | All users |
| POST | `/users/register` | Register |
| GET | `/users/login/{email}/{password}` | Login |

## Getting Started

```bash
./mvnw spring-boot:run
```

The database is stored in `./data/testdb`. The H2 console is available at `/h2-console`.
