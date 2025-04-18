
import sttp.shared.Identity
import sttp.tapir.*
import sttp.tapir.files.*
import sttp.tapir.emptyInput
import sttp.tapir.server.ServerEndpoint
import sttp.tapir.server.ServerEndpoint.Full
import sttp.tapir.server.netty.sync.NettySyncServer

import scala.annotation.*

@main
def Main(): Unit =

  val htmlEp = staticFilesGetServerEndpoint[Identity](emptyInput)("src/main/resources/index.html")

  NettySyncServer()
    .port(8080)
    .addEndpoint(htmlEp)
    .startAndWait()
