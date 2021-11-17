INSERT INTO CATEGORY(titel) VALUES ('Administratives');
INSERT INTO CATEGORY(titel) VALUES ('Planung');
INSERT INTO CATEGORY(titel) VALUES ('Implementierung');
INSERT INTO CATEGORY(titel) VALUES ('Testen');
INSERT INTO CATEGORY(titel) VALUES ('Finanzen');

INSERT INTO PROJECT(titel) VALUES ('225');
INSERT INTO PROJECT(titel) VALUES ('783');
INSERT INTO PROJECT(titel) VALUES ('155');
INSERT INTO PROJECT(titel) VALUES ('532');
INSERT INTO PROJECT(titel) VALUES ('622');


INSERT INTO USER(firstname, lastname, username, password, USERROLE) VALUES ('Test', 'User', 'testUser', 'secret', 'User');
INSERT INTO USER(firstname, lastname, username, password, USERROLE) VALUES ('Zoe', 'Galeuchet', 'zgaleuchet', 'passwort', 'Admin');

INSERT INTO ENTRY(checkIn, checkOut, Category) VALUES ('')
