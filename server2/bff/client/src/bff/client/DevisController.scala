package bff.client

import devis.DevisService
import play.api.mvc._
import play.api.libs.json.Json

import javax.inject.{Inject, Singleton}

@Singleton
class DevisController @Inject() (devisService: DevisService, components: ControllerComponents)
    extends AbstractController(components) {
  def getAllDevis(): Action[Unit] =
    Action(parse.empty) { _ =>
      {
        val allDevis = devisService.findAll()

        Ok(Json.toJson("data" -> allDevis))
      }
    }
}
