# 018 Basketball Camp Management System

> A multi-role training-camp system for camps, people, bookings, matches, forums, and file uploads.

## Problem

Camp registration, schedules, people, and match content are often scattered across spreadsheets and chats.

## Demo

~~~mermaid
flowchart LR
 A[Vue client] --> C[Spring Boot API]
 B[Vue admin] --> C
 C --> D[MySQL]
 C --> E[Training / bookings / matches / forum]
~~~

Users and administrators work on the same training-camp data model.

## Highlights

- Vue customer surface and Vue admin console.
- Spring Boot/MyBatis Java backend.
- MySQL scripts and file upload.
- Camp, people, bookings, matches, and forum modules.

## Tech

`Vue · Java 8 · Spring Boot · MyBatis · MySQL`

## Reproduce from ZIP

1. Extract the ZIP and prepare JDK, Maven, Node.js, and MySQL.
2. Import the database script, copy example configuration, and fill in a local connection.
3. Run `mvn spring-boot:run` in the backend.
4. Start the client and admin console separately, then verify training and booking flows with test accounts.

**Expected result:** After these steps, you should see the project's page, window, device output, or test result.

## Scope and Safety

Use local test configuration for database, storage, and accounts; do not connect uploads to unauthorized production materials.

## Contact

Open to technical exchange.
