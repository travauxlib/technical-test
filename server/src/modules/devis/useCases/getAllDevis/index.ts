import { devisRepository } from '../../repositories';
import { GetAllDevisUseCaseController } from './getAllDevisController';
import { GetAllDevisUseCase } from './GetAllDevisUseCase';

const getAllDevisUseCase = new GetAllDevisUseCase(
  devisRepository,
);

// Inject the use case into the controller to create it
const getAllDevisUseCaseController = new GetAllDevisUseCaseController(
  getAllDevisUseCase,
);

export {
  getAllDevisUseCaseController,
};
