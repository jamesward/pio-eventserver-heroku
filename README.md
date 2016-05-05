PredictionIO EventServer for Heroku
-----------------------------------


Run locally:

1. Start a Postgres server
1. Start the event server:

        source bin/env.sh && activator run

1. Create an app:

        source bin/env.sh && activator "runMain io.prediction.tools.console.Console app new <APP NAME>"

1. List apps:

        source bin/env.sh && activator "runMain io.prediction.tools.console.Console app list"


Run on Heroku:

1. Deploy
1. List apps:

        heroku run console app list

1. Create an app:

        heroku run console app new <APP NAME>
