// @GENERATOR:play-routes-compiler
// @SOURCE:bff/client/conf/client.routes

package client

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._


class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  DevisController_0: javax.inject.Provider[bff.client.DevisController],
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    DevisController_0: javax.inject.Provider[bff.client.DevisController]
  ) = this(errorHandler, DevisController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    client.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, DevisController_0, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """devis""", """@bff.client.DevisController@.getAllDevis()"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:2
  private lazy val bff_client_DevisController_getAllDevis0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("devis")))
  )
  private lazy val bff_client_DevisController_getAllDevis0_invoker = createInvoker(
    DevisController_0.get.getAllDevis(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "client",
      "bff.client.DevisController",
      "getAllDevis",
      Nil,
      "GET",
      this.prefix + """devis""",
      """# Devis""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case bff_client_DevisController_getAllDevis0_route(params@_) =>
      call { 
        bff_client_DevisController_getAllDevis0_invoker.call(DevisController_0.get.getAllDevis())
      }
  }
}
