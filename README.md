PredictionIO EventServer for Heroku
-----------------------------------

Run locally:

1. Start a Postgres server
1. Start the event server:

        source bin/env.sh && ./sbt run

1. Create an app:

        source bin/env.sh && ./sbt "runMain io.prediction.tools.console.Console app new <APP NAME>"

1. List apps:

        source bin/env.sh && ./sbt "runMain io.prediction.tools.console.Console app list"

1. Add some demo data:
```
export ACCESS_KEY=<YOUR ACCESS KEY>
for i in {1..5}; do curl -i -X POST http://localhost:7070/events.json?accessKey=$ACCESS_KEY -H "Content-Type: application/json" -d "{ \"event\" : \"\$set\", \"entityType\" : \"user\", \"entityId\" : \"u$i\" }"; done

for i in {1..50}; do curl -i -X POST http://localhost:7070/events.json?accessKey=$ACCESS_KEY -H "Content-Type: application/json" -d "{ \"event\" : \"\$set\", \"entityType\" : \"item\", \"entityId\" : \"i$i\", \"properties\" : { \"categories\" : [\"c1\", \"c2\"] } }"; done

for i in {1..5}; do curl -i -X POST http://localhost:7070/events.json?accessKey=$ACCESS_KEY -H "Content-Type: application/json" -d "{ \"event\" : \"view\", \"entityType\" : \"user\", \"entityId\" : \"u$i\",  \"targetEntityType\" : \"item\", \"targetEntityId\" : \"i$(( ( RANDOM % 50 )  + 1 ))\" }"; done
```

1. Check out the demo data:

    http://localhost:7070/events.json?accessKey=<YOUR ACCESS KEY>&limit=-1


Run on Heroku:

1. Deploy: [![Deploy on Heroku](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)
1. List apps:

        heroku run console app list

1. Create an app:

        heroku run console app new <APP NAME>
