package objektwerks

import sttp.client4.*
import sttp.client4.curl.*
import sttp.client4.Response

object NowClient:
  def main(args: Array[String]): Unit =
    val backend = CurlBackend()
    val response: Response[String] = quickRequest
      .get(uri"http://localhost:7474/")
      .send(backend)
    println( s"*** Now Client response: ${response.body}" )