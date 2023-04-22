package objektwerks

import java.time.Instant

import snunit.*
import snunit.routes.*

import trail.*

object NowServer:
  def main(args: Array[String]): Unit =
    val route  = Root / "now"
    AsyncServerBuilder()
      .withRequestHandler(
        _.withMethod(Method.GET)
          .withRoute(route) { case (request, _) =>
            request.send(
              statusCode = StatusCode.OK,
              content = s"*** Now: ${Instant.now().toString}",
              headers = Seq("Content-Type" -> "text/plain")
            )
          }
      )
      .build()
    ()