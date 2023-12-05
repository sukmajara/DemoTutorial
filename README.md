# Demo Tutorial
this is a API to get, create, update, delete Tutorial using spring boot.

## Installation
```bash
git clone <URL GIT> <repository>
```
*make sure you clone in right directory*

make sure you have this requirement running in your system:
java version "1.8.0_251"
PostgreSQL 14.3

in Spring Tool Suite 4
 - Import -> Existing Maven Project 
 - Choose folder from folder you just cloned
 - Update Project to make sure all pom.xml imported
 - Run as Spring Boot App

the app default running on port 8081 for the api and PostgreSQL on 5432

## Usage
this is the endpoint for the servive
- Get All Tutorial 	 [GET]	: http://localhost:8080/api/tutorials
- Get Detail Tutorial 	 [GET]	: http://localhost:8080/api/tutorials/{TutorialID}
- Get Title Tutorial	 [GET]	: http://localhost:8080/api/tutorials?title={Title}
- Get Published Tutorial [GET]	: http://localhost:8080/api/tutorials/published

- Create Tutorial 	 [POST]	: http://localhost:8080/api/tutorials\
  Request:
```json
  {
    "title":"title 1",
    "description":"title 1"
}
```

- Update Tutorial	[PATCH]	: http://localhost:8080/api/tutorials/{TutorialID}\
    Request:
```json
 {
    "title":"title Edited",
    "description":"title Edited",
    "published": true
}
```
- Delete All Tutorial 	[DELETE]: http://localhost:8080/api/tutorials 
- Delete Blog 		[DELETE]: http://localhost:8080/api/tutorials/453
    Request:

*make adjusment in application.properties if needed*

