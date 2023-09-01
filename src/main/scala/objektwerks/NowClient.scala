package objektwerks

import sttp.client4.*
import sttp.client4.curl.*
import sttp.client4.Response
import sttp.model.Uri

object NowClient:
  def main(args: Array[String]): Unit =
    // See config.json for server listeners.
    val url = if args.isEmpty then uri"http://localhost:7474/" else Uri(args(0))
    println( s"*** Now Client sending request to: ${url.toString}" )

    val backend = CurlBackend()
    val response: Response[String] = quickRequest
      .get(url)
      .send(backend)
    
    println( s"*** Now Client response: ${response.body}" )