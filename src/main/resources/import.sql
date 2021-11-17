INSERT INTO CATEGORY(titel) VALUES ('Administratives');
INSERT INTO CATEGORY(titel) VALUES ('Planung');
INSERT INTO CATEGORY(titel) VALUES ('Implementierung');
INSERT INTO CATEGORY(titel) VALUES ('Testen');
INSERT INTO CATEGORY(titel) VALUES ('Finanzen');

INSERT INTO PROJECT(titel, category_id) VALUES ('225', 1);
INSERT INTO PROJECT(titel, category_id) VALUES ('783', 1);
INSERT INTO PROJECT(titel, category_id) VALUES ('155', 2);
INSERT INTO PROJECT(titel, category_id) VALUES ('532', 3);
INSERT INTO PROJECT(titel, category_id) VALUES ('622', 4);

INSERT INTO USERROLE(title) VALUES ('Admin');
INSERT INTO USERROLE(title) VALUES ('User');


INSERT INTO USER(firstname, lastname, username, password, userrole_id) VALUES ('Test', 'User', 'testUser', 'secret', 1);
INSERT INTO USER(firstname, lastname, username, password, userrole_id) VALUES ('Zoe', 'Galeuchet', 'zgaleuchet', 'passwort', 2);

INSERT INTO ENTRY(checkIn, checkOut, user_id, category_id) VALUES ('2021-11-17T12:15:00', '2021-11-17T12:15:00', 1, 1);
INSERT INTO ENTRY(checkIn, checkOut, user_id, category_id) VALUES ('2022-11-18T12:19:00', '2022-11-19T16:43:00', 1, 2);
