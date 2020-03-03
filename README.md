# Homeworks

Repozitář obsahuje podkladová data a popis různých druhů "domácích úloh".

## Zpoždění letů:

Napište v definovaném jazyce program, který provede po spuštění následující:

* Stáhne z repozitáře soubor **Jan-1988-ontime-test-data.zip**
* Rozbalí data a provede v nich výpočet průměrné délky zpoždění letů na letiště v Los Angeles (LAX)
* Do statistiky se počítají jen lety, které byly uskutečněné (podle údaje v Cancelled)

## Uživatelé NetBeans IDE:

Napište v definovaném jazyce program, který provede po spuštění následující:

* Stáhne ze zdroje **Stack Overflow Annual Developer Survey** anketu z roku 2019
* Rozbalí data a vypočítá procentuální užití NetBeans IDE (NetBeans IDE, ostatní, neodpověděl)
* Do statistiky se počítá jakékoliv užití NetBeans IDE (pokud se alespoň jedenkrát objeví na seznamu)

## GUI pro ToDo aplikaci

Napište v definovaném jazyce GUI pro přiloženou Java aplikaci, která poskytuje základní REST endpointy pro práci s ToDo entitami (získání, vytvoření, úprava, smazání). Žádné příklady, jak má GUI vypadat, nejsou zadány. Návrh UI je součástí úlohy.

### Spuštění backendu

* Backend ve složce **todo-app-backend** je Maven projekt a používá JDK 8
* *mvn package*
* *java -jar target/example-backend-0.0.1-SNAPSHOT.jar*
* Aplikace poslouchá na *localhost:8080*

### REST API

1. Získat všechny ToDo entity
   - GET .../api/v1/todo
   - curl localhost:8080/api/v1/todo
2. Získat ToDo entitu pomocí ID
   - GET .../api/v1/todo/ID
   - curl localhost:8080/api/v1/todo/1 
3. Vytvořit novou ToDo entitu
   - POST .../api/v1/todo with body: {"description": "VALUE"}
   - curl -X POST localhost:8080/api/v1/todo/ -H "Content-Type: application/json" --data '{"description":"xyz"}'
4. Upravit entitu definovanou ID
   - PUT .../api/v1/todo/ID with body: {"description": "VALUE", done: false}
   - curl -X PUT localhost:8080/api/v1/todo/4 -H "Content-Type: application/json" --data '{"done":"true"}'
5. Smazat entitu pomocí ID
   - DELETE .../api/v1/todo/ID
   - curl -X DELETE localhost:8080/api/v1/todo/3

### Poznámky

* Backend není zabezpečen a nepodporuje autentizaci. Aplikace je pro jednoho uživatele.
* Aplikace používá H2 databázi v paměti. Žádnou databázi nepotřebujete instalovat ani spouštět.
* Při každém startu aplikace se databáze vymaže a nahrají se testovací ToDo entity.

## Zdroje:

* [Jan-1988-ontime-test-data.zip](https://www.transtats.bts.gov/OT_Delay/OT_DelayCause1.asp) - Letové informace z ledna 1988
* [Stack Overflow Annual Developer Survey](https://insights.stackoverflow.com/survey) - Ankety Stack Overflow
