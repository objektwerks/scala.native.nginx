package objektwerks

import java.time.Instant

import snunit.{SyncServerBuilder, Headers, send, StatusCode}

object NowServer:
  def main(args: Array[String]): Unit =
    SyncServerBuilder
      .setRequestHandler(request =>
        request.send(
          statusCode = StatusCode.OK,
          content = s"*** Now: ${Instant.now().toString}",
          headers = Headers("Content-Type" -> "text/plain")
        )
      )
      .build()