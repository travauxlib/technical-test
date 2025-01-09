package devis

import scalikejdbc._

import java.util.UUID
import javax.inject.{Inject, Singleton}

@Singleton
class DevisRepository @Inject() {
  private val devis = DevisSQLMapping.syntax

  def findAll()(implicit session: DBSession = ReadOnlyAutoSession): Seq[Devis] =
    withSQL {
      selectFrom(DevisSQLMapping as devis)
    }.map(DevisSQLMapping.unserialize(devis.resultName)).list()
}

object DevisSQLMapping extends SQLSyntaxSupport[Devis] {
  override val schemaName: Option[String] = Some("devis")
  override val tableName                  = "devis"

  def unserialize(devis: ResultName[Devis])(rs: WrappedResultSet): Devis = {
    Devis(
      uuid = UUID.fromString(rs.string(devis.uuid))
    )
  }

  def serialize(devis: Devis): Map[SQLSyntax, ParameterBinder] =
    Map(
      column.uuid -> sqls"${devis.uuid}::uuid"
    )
}
