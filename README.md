# ExampleCode
Quick and dirty instructions.
To use:
Clone the repo.
Import into ide.
Run as spring application.
navigate to localhost:8080/swagger-ui.html to view the API documentation

H2 Database Credentials
H2 URL: /console
Username: sa
Password:  // password for database is empty


Application Credentials (User are setup via data.sql passwords are hased using Bcrypt)
ROLE                    | Username     | Hashed Password                                              | Plain textpassword
Administrator			| admin        | $2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC | 1234
AdministratorReadOnly'	| adminrro     | $2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC | 1234
Manager				    | manager      | $2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC | 1234
ManagerReadOnly	    	| managerro    | $2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC | 1234
Employee				| employee     | $2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC | 1234
EmployeeReadOnly		| employeero   | $2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC | 1234
Customer				| customer     | $2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC | 1234
CustomerReadOnly		| customerro   | $2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC | 1234

To-Do:
Improve readme file
Add Actuator
Add Browser Endpoints for API  (Thymeleaf?)

References 
Security
https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html
https://github.com/getarrays/userservice / https://youtu.be/mYKf4pufQWA
https://github.com/amigoscode/spring-boot-security-course / https://youtu.be/her_7pa0vrg

Swagger/OpenAPI
https://github.com/mgamio/openapi-springboot

