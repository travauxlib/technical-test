import { DevisRepository } from '../../repositories/DevisRepository';

export class GetAllDevisUseCase {
  private devisRepository: DevisRepository;

  constructor(devisRepository: DevisRepository) {
    this.devisRepository = devisRepository;
  }

  execute() {
    return this.devisRepository.all();
  }
}
