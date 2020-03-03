# Homeworks

The repository contains source code, example data and description of different coding homeworks.

## Flight delays

Code an application in defined language, which will after startup:

* Download a file **Jan-1988-ontime-test-data.zip** from repository
* Extract data and calculate average delay of flights to Los Angeles airport (LAX)
* Include only realized flights (according to column Cancelled)

## NetBeasns users

Code an application in defined language, which will after startup:

* Download 2019 survey from source **Stack Overflow Annual Developer Survey**
* Extract data and calculate percentage usage of NetBeans IDE (NetBeans IDE, other, not answered)
* Include usage if NetBeans is at least once in the list of IDEs

## GUI for ToDo application

Code a GUI in defined language for included Java application, which provides basic REST endpoints built around ToDo entity (get, create, update, delete). No GUI mocks are provided. Designing UI on your own is a part of the assignment.

### How to run the backend

* Backend in folder **todo-app-backend** is a Maven project and uses JDK 8.
* *mvn package*
* *java -jar target/example-backend-0.0.1-SNAPSHOT.jar*
* Application will listen on *localhost:8080*

### REST API

1. Gets all ToDo entities
   - GET .../api/v1/todo
   - curl localhost:8080/api/v1/todo
2. Gets ToDo entity with ID
   - GET .../api/v1/todo/ID
   - curl localhost:8080/api/v1/todo/1 
3. Creates a new ToDo entry
   - POST .../api/v1/todo with body: {"description": "VALUE"}
   - curl -X POST localhost:8080/api/v1/todo/ -H "Content-Type: application/json" --data '{"description":"xyz"}'
4. Updates an existing ID based on the properties supplied in the JSON body
   - PUT .../api/v1/todo/ID with body: {"description": "VALUE", done: false}
   - curl -X PUT localhost:8080/api/v1/todo/4 -H "Content-Type: application/json" --data '{"done":"true"}'
5. Deletes ToDo entity with ID
   - DELETE .../api/v1/todo/ID
   - curl -X DELETE localhost:8080/api/v1/todo/3

### Notes

* The backend is not secured and does not support authentication. Consider it a single-user application.
* It uses H2 in-memory database, you don't need to have any DB installed or running.
* After each start of the backend, the data structures are re-created and an initial sample dataset is loaded.

## Sources

* [Jan-1988-ontime-test-data.zip](https://www.transtats.bts.gov/OT_Delay/OT_DelayCause1.asp) - Letové informace z ledna 1988
* [Stack Overflow Annual Developer Survey](https://insights.stackoverflow.com/survey) - Ankety Stack Overflow
