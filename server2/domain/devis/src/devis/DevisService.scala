package devis

import scala.concurrent.ExecutionContext
import javax.inject.{Inject, Singleton}

@Singleton
class DevisService @Inject() (devisRepository: DevisRepository)(implicit val ec: ExecutionContext) {
  def findAll(): Seq[Devis] = devisRepository.findAll()
}
