# GraphQl project

Sport teams & players management

## Content

## Get & launch project

## Structure

```text
├── readme.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org.spelle.sport
│   │   │       ├── GraphqlConfiguration.java
│   │   │       ├── Player.java
│   │   │       ├── PlayerController.java
│   │   │       ├── PlayerDao.java
│   │   │       ├── SportApplication.java
│   │   │       ├── Team.java
│   │   │       ├── TeamController.java
│   │   │       └── TeamDao.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── graphql
│   │       │   ├── ops.graphqls
│   │       │   ├── player.graphqls
│   │       │   └── team.graphqls
│   └── test
└── target
```

## Query

### GetPLayers

```graphql
query GetPLayers {
    getPlayers {
        id
        first_name
        last_name
        date_of_birth
    }
}
```

```graphql
{
  "data": {
    "getPlayers": [
      {
        "id": "0",
        "first_name": "First Name 0",
        "last_name": "Last Name 0",
        "date_of_birth": "Date of Birth 0"
      },
      {
        "id": "1",
        "first_name": "First Name 1",
        "last_name": "Last Name 1",
        "date_of_birth": "Date of Birth 1"
      },
    ]
  }
}
```

### GetTeams

```graphql
query GetTeams {
  getTeams {
    id
    name
    country
    city
  }
}
```

```graphql
{
  "data": {
    "getTeams": [
      {
        "id": "0",
        "name": "Name 0",
        "country": "Country 0",
        "city": "City 0"
      },
      {
        "id": "1",
        "name": "Name 1",
        "country": "Country 1",
        "city": "City 1"
      }
    ]
  }
}
```