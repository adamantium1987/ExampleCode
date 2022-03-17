INSERT INTO APPLICATION_USERS values (1 ,'Administrator'			,'$2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC' ,'admin');
INSERT INTO APPLICATION_USERS values (2 ,'AdministratorReadOnly'	,'$2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC' ,'adminrro');
INSERT INTO APPLICATION_USERS values (3 ,'Manager'					,'$2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC' ,'manager');
INSERT INTO APPLICATION_USERS values (4 ,'ManagerReadOnly'			,'$2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC' ,'managerro');
INSERT INTO APPLICATION_USERS values (5 ,'Employee'					,'$2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC' ,'employee');
INSERT INTO APPLICATION_USERS values (6 ,'EmployeeReadOnly'			,'$2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC' ,'employeero');
INSERT INTO APPLICATION_USERS values (7 ,'Customer'					,'$2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC' ,'customer');
INSERT INTO APPLICATION_USERS values (8 ,'CustomerReadOnly'			,'$2a$12$gluwkDnuiEawB5g/ohUGDeV3IeGl3oUxPQmmWVkocZlp360MG91TC' ,'customerro');


INSERT INTO ROLE values (1,'ROLE_ADMINISTRATOR');
INSERT INTO ROLE values (2,'ROLE_ADMINISTRATOR_READONLY');
INSERT INTO ROLE values (3,'ROLE_MANAGER');
INSERT INTO ROLE values (4,'ROLE_MANAGER_READONLY');
INSERT INTO ROLE values (5,'ROLE_EMPLOYEE');
INSERT INTO ROLE values (6,'ROLE_EMPLOYEE_READONLY');
INSERT INTO ROLE values (7,'ROLE_CUSTOMER');
INSERT INTO ROLE values (8,'ROLE_CUSTOMER_READONLY');

INSERT INTO APPLICATION_USERS_ROLES values (1, 1);
INSERT INTO APPLICATION_USERS_ROLES values (2, 2);
INSERT INTO APPLICATION_USERS_ROLES values (3, 3);
INSERT INTO APPLICATION_USERS_ROLES values (4, 4);
INSERT INTO APPLICATION_USERS_ROLES values (5, 5);
INSERT INTO APPLICATION_USERS_ROLES values (6, 6);
INSERT INTO APPLICATION_USERS_ROLES values (7, 7);
INSERT INTO APPLICATION_USERS_ROLES values (8, 8);