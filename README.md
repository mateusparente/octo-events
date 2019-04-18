# Octo Events
Octo Events is an application that listens to Github Events via webhooks and expose by an api for later use. Kotlin + Koin + Javalin + MongoDB

## Technology stack

- Kotlin
- Javalin
- Koin
- Maven
- JUnit
- MongoDB (Embedded)
- Khttp

## Endpoints

**POST** `/api/v1/issues`

**GET** `/api/v1/issues/{numberIssue}/events`

## Running
I used the flapdoodle to have the mongodb embedded.

```bash
$ git clone https://github.com/mateusparente/octo-events.git
$ cd octo-events
$ mvn clean install
```

```
http://localhost:7000
```

**MongoDB Details**
```
The embedded MongoDB in Application run on port 27017
```
