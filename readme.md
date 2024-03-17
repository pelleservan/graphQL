# GraphQl project

Sport teams & players management

## Content

1. [Get & Launch Project](#get--launch-project)
2. [Structure](#structure)
3. [Schemas](#schemas)
3. [Players Queries](#players-queries)
4. [Players Mutations](#players-mutations)
5. [Teams Queries](#teams-queries)
6. [Teams Mutations](#teams-mutations)

## Get & Launch Project

1. First, make sure you have Maven installed on your system.

2. Clone the project from the GitHub repository:

```bash
git clone https://github.com/graphql-java-kickstart/graphql-spring-boot.git
```

3. Navigate to the cloned directory:

```bash
cd graphql-spring-boot
```

4. Run the project using Maven:

```bash
mvn spring-boot:run
``` 

5. Once the server is started, you can access the GraphiQL interface at the following URL: http://localhost:8080/graphiql

6. You can now test your GraphQL queries in the GraphiQL interface. Or use the __node client__ available on the following repository : 
```bash
https://github.com/pelleservan/graphQl_client.git
```

7. An exaustive list of queries and mutation exemple is available bellow.

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

## Schemas

### Player

```graphql
type Player {
    id: ID!
    first_name: String!
    last_name: String!
    date_of_birth: String!
    team_id: String!
}
```

### Team

```graphql
type Team {
    id: ID!
    name: String!
    country: String!
    city: String!
}
```

## Players Queries

1. [GetPlayers](#getplayers)
2. [GetPlayerById](#getplayerbyid)
3. [GetPlayersByFirstName](#getplayersbyfirstname)
4. [GetPlayersByLastName](#getplayersbylastname)
5. [GetPlayersByDateOfBirth](#getplayersbydateofbirth)
6. [GetPlayersByTeamId](#getplayersbyteamid)

## Players Mutations

1. [UpdatePlayerFirstNameById](#updatepayerfirstnamebyid)
2. [UpdatePlayerLasstNameById](#updateplayerlastnamebyid)
3. [UpdatePlayerDateOfBirthById](#updateplayerdateofbirthbyid)
4. [UpdatePlayerTeamIdById](#updateplayerteamidbyid)
5. [DeletePlayerById](#deleteplayerbyplayerid)

## Teams Queries

1. [GetTeams](#getteams)
1. [GetTeamById](#getteambyid)
2. [GetTeamByName](#getteambyname)
3. [GetTeamsByCountry](#getteambycountry)
4. [GetTeamsByCity](#getteambycity)

## Teams Mutations

1. [UpdateTeamNameById](#updateteamnamebyid)
2. [UpdateTeamCountryById](#updateteamcountrybyid)
3. [UpdateTeamCityById](#updateteamcitybyid)
4. [DeleteTeamById](#deleteteambyid)

### GetPLayers

```graphql
query GetPLayers {
    getPlayers {
        id
        first_name
        last_name
        date_of_birth
        team_id
    }
}
```

```bash
{
  "data": {
    "getPlayers": [
      {
        "id": "0",
        "first_name": "First Name 0",
        "last_name": "Last Name 0",
        "date_of_birth": "Date of Birth 0",
        "team_id": "2"
      },
      {
        "id": "1",
        "first_name": "First Name 1",
        "last_name": "Last Name 1",
        "date_of_birth": "Date of Birth 1",
        "team_id": "2"
      }
    ]
  }
}
```

### GetPlayerById

```graphql
query getPlayerById	{
    getPlayerById(id: "2") {
        id
    		first_name
    		last_name
    		date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "getPlayerById": {
      "id": "2",
      "first_name": "First Name 2",
      "last_name": "Last Name 2",
      "date_of_birth": "Date of Birth 2",
      "team_id": "2"
    }
  }
}
```

### GetPlayersByTeamId

```graphql
 query getPlayersByTeamId	{
    getPlayersByTeamId(teamId: "2") {
        id
    		first_name
    		last_name
    		date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "getPlayers": [
      {
        "id": "0",
        "first_name": "First Name 0",
        "last_name": "Last Name 0",
        "date_of_birth": "Date of Birth 0",
        "team_id": "2"
      },
      {
        "id": "1",
        "first_name": "First Name 1",
        "last_name": "Last Name 1",
        "date_of_birth": "Date of Birth 1",
        "team_id": "2"
      }
    ]
  }
}
```

### UpdatePayerFirstNameById

```graphql
mutation UpdatePlayerFirstNameById {
    updatePlayerFirstNameById(id: "1", first_name: "Updated First Name") {
        id
        first_name
        last_name
        date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "updatePlayerFirstNameById": {
      "id": "1",
      "first_name": "Updated First Name",
      "last_name": "Last Name 1",
      "date_of_birth": "Date of Birth 1",
      "team_id": "2"
    }
  }
}
``` 

### GetPlayersByFirstName

```graphql
query getPlayerByFirstName	{
    getPlayerByFirstName(first_name: "First Name 1") {
        id
    		first_name
    		last_name
    		date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "getPlayerByFirstName": [
      {
        "id": "1",
        "first_name": "First Name 1",
        "last_name": "Last Name 1",
        "date_of_birth": "Date of Birth 1",
        "team_id": "2"
      }
    ]
  }
}
```

### GetPlayersByLastName

```graphql
query getPlayerByLastName	{
    getPlayerByLastName(last_name: "Last Name 1") {
        id
    		first_name
    		last_name
    		date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "getPlayerByLastName": [
      {
        "id": "1",
        "first_name": "First Name 1",
        "last_name": "Last Name 1",
        "date_of_birth": "Date of Birth 1",
        "team_id": "2"
      }
    ]
  }
}
```

### GetPlayersByDateOfBirth

```graphql
query getPlayersByDateOfBirth	{
    getPlayerByDateOfBirth(date_of_birth: "Date of Birth 1") {
        id
    		first_name
    		last_name
    		date_of_birth
    		team_id
    }
}
````

```bash
{
  "data": {
    "getPlayerByDateOfBirth": [
      {
        "id": "1",
        "first_name": "First Name 1",
        "last_name": "Last Name 1",
        "date_of_birth": "Date of Birth 1",
        "team_id": "2"
      }
    ]
  }
}
```

### UpdatePlayerFirstNameById

```graphql
mutation UpdatePlayerFirstNameById {
    updatePlayerFirstNameById(id: "1", first_name: "Updated First Name") {
        id
        first_name
        last_name
        date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "updatePlayerFirstNameById": {
      "id": "1",
      "first_name": "Updated First Name",
      "last_name": "Last Name 1",
      "date_of_birth": "Date of Birth 1",
      "team_id": "2"
    }
  }
}
```

### UpdatePlayerLastNameById 

```graphql
mutation UpdatePlayerLastNameById {
    updatePlayerLastNameById(id: "2", last_name: "Updated Last Name") {
        id
        first_name
        last_name
        date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "updatePlayerLastNameById": {
      "id": "2",
      "first_name": "First Name 2",
      "last_name": "Updated Last Name",
      "date_of_birth": "Date of Birth 2",
      "team_id": "2"
    }
  }
}
```

### UpdatePlayerDateOfBirthById

```graphql
mutation UpdatePlayerDateOfBirthById {
    updatePlayerDateOfBirthById(id: "1", date_of_birth: "Updated Date of Birth") {
        id
        first_name
        last_name
        date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "updatePlayerDateOfBirthById": {
      "id": "1",
      "first_name": "First Name 1",
      "last_name": "Last Name 1",
      "date_of_birth": "Updated Date of Birth",
      "team_id": "2"
    }
  }
}
```

### UpdatePlayerTeamIdById

```graphql
mutation UpdatePlayerTeamIdById {
    updatePlayerTeamIdById(id: "1", team_id: "3") {
        id
        first_name
        last_name
        date_of_birth
    		team_id
    }
}
```

```bash
{
  "data": {
    "updatePlayerTeamIdById": {
      "id": "1",
      "first_name": "First Name 1",
      "last_name": "Last Name 1",
      "date_of_birth": "Updated Date of Birth",
      "team_id": "3"
    }
  }
}
```

### DeletePlayerById



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

```bash
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

### GetTeamById

```graphql
query GetTeamById {
    getTeamById(id: "1") {
        id
        name
        country
        city
    }
}
```

```bash
{
  "data": {
    "getTeamById": {
      "id": "1",
      "name": "Name 1",
      "country": "Country 1",
      "city": "City 1"
    }
  }
}
```

### GetTeamByName

```graphql
query GetTeamByName {
    getTeamByName(name: "Name 1") {
      id
      name
      country
      city
    }
}
```

```bash
{
  "data": {
    "getTeamByName": {
      "id": "1",
      "name": "Name 1",
      "country": "Country 1",
      "city": "City 1"
    }
  }
}
```

### GetTeamByCity

```graphql
query GetTeamByCity {
    getTeamByCity(city: "City 1") {
      id
      name
      country
      city
    }
}
```

```bash
{
  "data": {
    "getTeamByCity": [
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

### GetTeamByCountry

```graphql
query GetTeamBCountry {
    getTeamByCountry(country: "Country 1") {
      id
      name
      country
      city
    }
}
```

```bash
{
  "data": {
    "getTeamByCountry": [
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

### UpdateTeamNameById

```graphql
mutation {
    updateTeamNameById(id: "1", name: "Updated Name") {
        id
        name
        country
        city
    }
}
```

```bash
{
  "data": {
    "updateTeamNameById": {
      "id": "1",
      "name": "Updated Name",
      "country": "Country 1",
      "city": "City 1"
    }
  }
}
```

### UpdateTeamCountryById

```graphql
mutation UpdateTeamCountryById {
    updateTeamCountryById(id: "1", country: "Updated Country") {
        id
        name
        country
    		city
    }
}
```

```bash
{
  "data": {
    "updateTeamCountryById": {
      "id": "1",
      "name": "Name 1",
      "country": "Updated Country",
      "city": "City 1"
    }
  }
}
```

### UpdateTeamCityById

```graphql
mutation UpdateTeamCityById {
    updateTeamCityById(id: "1", city: "Updated City") {
        id
        name
        country
    		city
    }
}
```

```bash
{
  "data": {
    "updateTeamCityById": {
      "id": "1",
      "name": "Name 1",
      "country": "Updated Country",
      "city": "Updated City"
    }
  }
}
```

### DeleteTeamById

```bash
mutation deleteTeamById {
  deleteTeamById(id: "1") 
}
```