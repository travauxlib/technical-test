import { GetAllDevisUseCase } from './GetAllDevisUseCase';

export class GetAllDevisUseCaseController {
  private useCase: GetAllDevisUseCase;

  constructor(useCase: GetAllDevisUseCase) {
    this.useCase = useCase;
  }

  public async execute() {
    const result = await this.useCase.execute();

    if (!result) {
      throw new Error('No devis found');
    }

    return result;
  }
}
