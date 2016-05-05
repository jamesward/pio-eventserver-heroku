import io.prediction.data.api.{EventServer, EventServerConfig}

object EventServerApp extends App {

  val port = sys.env.getOrElse("PORT", "7070").toInt

  EventServer.createEventServer {
    EventServerConfig(ip = "0.0.0.0", port = port)
  }

}
