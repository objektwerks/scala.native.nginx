package objektwerks

import java.time.Instant

import snunit.*

object NowServer:
  def main(args: Array[String]): Unit =
    AsyncServerBuilder
      .setRequestHandler(request =>
        request.send(
          statusCode = StatusCode.OK,
          content = s"*** Now: ${Instant.now().toString}",
          headers = Seq("Content-Type" -> "text/plain")
        )
      )
      .build()