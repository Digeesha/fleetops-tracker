# FleetOps Tracker

Smart vehicle fleet management and maintenance tracking

FleetOps Tracker is a vehicle fleet management system designed for small logistics companies and delivery services. It tracks vehicle maintenance schedules, fuel consumption, driver assignments, and trip logs in real-time. The application provides dashboards for fleet managers to monitor vehicle health, schedule preventive maintenance, and analyze operational costs. Users can log trips, record fuel purchases, track mileage, and receive automated alerts when vehicles are due for service. The system maintains a complete audit trail of all vehicle activities and generates cost reports per vehicle and per driver.

## Features

- Vehicle registration with make, model, year, VIN, license plate, and current mileage tracking
- Trip logging with driver assignment, start/end odometer readings, route, and duration
- Fuel purchase recording with cost, gallons, station, and automatic MPG calculation
- Maintenance schedule creation with service type, interval (mileage or time-based), and cost tracking
- Automated service due alerts based on mileage thresholds and last service date
- Driver management with license information, assignment history, and performance metrics
- Fleet dashboard showing active vehicles, upcoming maintenance, total fleet mileage, and monthly fuel costs
- Cost analysis reports per vehicle showing total maintenance, fuel, and cost-per-mile metrics
- Service history timeline for each vehicle with parts replaced and labor costs
- Bulk data seeding with realistic fleet data for immediate demonstration

## Tech stack

Java 17, Spring Boot, Thymeleaf, Maven, H2, Spring MVC, Spring Data JPA, H2 Database, Bootstrap 5, Hibernate

## How to run locally
### Prerequisites

- Java 17 or newer and Maven
### Environment variables


Copy `.env.example` to `.env` in the project root before starting the app.

**Windows**

```bash
copy .env.example .env
```

**macOS / Linux**

```bash
cp .env.example .env
```
From the project root:

```bash
mvn spring-boot:run
```

If the repo also has a frontend `package.json`, start that in a second terminal with `npm install` and `npm run dev`.

## Project structure

```
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       ├── example/
│   │   │       │   └── app/
│   │   │       │       ├── api/
│   │   │       │       │   └── ItemApiController.java
│   │   │       │       ├── model/
│   │   │       │       │   └── Item.java
│   │   │       │       ├── service/
│   │   │       │       │   └── ItemService.java
│   │   │       │       ├── web/
│   │   │       │       │   ├── HomeController.java
│   │   │       │       │   └── ItemController.java
│   │   │       │       └── Application.java
│   │   │       └── fleetops/
│   │   │           └── model/
│   │   │               ├── Driver.java
│   │   │               ├── FuelPurchase.java
│   │   │               ├── Trip.java
│   │   │               └── Vehicle.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── styles.css
│   │       ├── templates/
│   │       │   ├── dashboard.html
│   │       │   └── index.html
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── app/
│                       └── ItemServiceTest.java
├── .env.example
├── .gitignore
├── index.html
└── pom.xml
```

---

Generated with [Alviora AI](https://alvioraai.com).
