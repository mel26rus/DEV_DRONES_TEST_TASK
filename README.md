# DRONES solution

### Prerequisites

To run the application, you need to have it installed on your machine:

- Java 17
- Maven
- My SQL

### Build and run

To build and run the application go to the project root and execute the next Maven command in your terminal:

```
mvn spring-boot:run
```

You may check that application is running by opening the link:
http://localhost:8080/drones


## Documentation

For check all drones open that link
http://localhost:8080/drones/all

For check all medications open that link
http://localhost:8080/medic

#The service allow:
For registering a drone use POST request
with link and JSON body
http://localhost:8080/drones/register
```json
{
    "serial_number": "009",
    "droneModelScheme": {
        "id": 3,
        "title": "Cruiserweight"
    },
    "weight_limit": 300,
    "battery": 50,
    "droneStateScheme": {
        "id": 1,
        "title": "IDLE"
    }
}
```

For load a drone with medication use POST request
with link and JSON body
http://localhost:8080/load
```json
{
    "droneScheme": {
        "id": 10,
        "serial_number": "Mavic007",
        "model": {
            "id": 4,
            "title": "Heavyweight"
        },
        "weight_limit": 500,
        "battery": 100,
        "state": {
            "id": 1,
            "title": "IDLE"
        }
    },
    "medicationScheme": {
        "id": 2,
        "name": "NUMB",
        "weight": 100,
        "code": "NU66",
        "image": "numb.png"
    }
}
```

For check all loaded medication items for a given drone use GET request with param "drone_id"
http://localhost:8080/load/{id}

For check available drones for loading use GET request
http://localhost:8080/drones/available

For check drone battery level for a given drone use GET request with param "drone_id"
http://localhost:8080/drones/{id}
you can see all data about given drone

#№№№ DRONES FINISH solution
Вход. Запуск TPerformTasksThread