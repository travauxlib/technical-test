package devis

import play.api.libs.json.{Format, Json}

import java.util.UUID

case class Devis(
  uuid: UUID = UUID.randomUUID()
)

object Devis {
  implicit val format: Format[Devis] = Json.format[Devis]
}
