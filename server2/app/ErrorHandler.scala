import javax.inject._
import play.api._
import play.api.http.{DefaultHttpErrorHandler, HeaderNames}

import play.api.mvc.Results._
import play.api.mvc._
import play.api.routing.Router

import scala.concurrent._

@Singleton
class ErrorHandler @Inject() (
  env: Environment,
  config: Configuration,
  sourceMapper: OptionalSourceMapper,
  router: Provider[Router],
) extends DefaultHttpErrorHandler(env, config, sourceMapper, router)
    with Logging {

  override def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] = {
    logger.warn(
      s"Erreur client $statusCode ${request.toString()} : $message from ${request.headers.get(HeaderNames.REFERER).getOrElse("no referer")}"
    )
    Future.successful(
      Status(statusCode)(s"Erreur : $message")
    )
  }

  override def onDevServerError(request: RequestHeader, exception: UsefulException): Future[Result] = {
    Future.successful(
      InternalServerError(s"Erreur serveur ${request.toString()} : ${exception.getMessage}")
    )
  }

  override def onProdServerError(request: RequestHeader, exception: UsefulException): Future[Result] = {
    Future.successful(InternalServerError)
  }

  override def onForbidden(request: RequestHeader, message: String): Future[Result] = {
    Future.successful(
      Forbidden("You're not allowed to access this resource.")
    )
  }

  override def logServerError(request: RequestHeader, usefulException: UsefulException): Unit = logger.error(
    "@%s - Internal server error for %s %s".format(usefulException.id, request.method, request.uri),
    usefulException,
  )

}
