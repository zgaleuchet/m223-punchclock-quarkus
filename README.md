#PunchClock

###Projekt laufen lassen:
Backend:
```shell script
./mvnw compile quarkus:dev
```

Frontend:
````shell script
ng serve
````

###Github Repository
Backend:
https://github.com/zgaleuchet/m223-punchclock-quarkus.git

Frontend:
https://github.com/zgaleuchet/punchClock.git

###Default Daten
Es wurden default Kategorien, Projekte, Userrollen, User und Entries erstellt.

####User: 
username: testUser

passwort: secret

####Admin:
username: zgaleuchet

passwort: passwort

###JPQL Query
Im Tab User kann man unten nach einem username suchen

###Abweichung zur planung
1. Ich habe user-forms und user-overview, wie auch entry-forms und entry-overview 
zusammengefügt, da es in der Realisierung einfacher war. 
2. Im frontend kamen zu den Components und den Models noch die Services dazu.
3. Projekte konnte ich nicht mehr richtig hinzufügen, da die Zeit zu knapp war.
4. Ich habe mit dem Login begonne konnte es aber nicht fertig machen, da die Zeit zu knapp war.
Ich bekomme ein JWT Token vom backend, wenn ich mich mit einem richtigen Login einlogge. 
Da das Login nicht richtig funktioniert, sind alle Funktionen für alle User zugänglich.
