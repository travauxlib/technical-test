import fastify, { FastifyInstance } from 'fastify';
import fastifyCors from 'fastify-cors';
import { getAllDevisUseCaseController } from './modules/devis/useCases/getAllDevis';

export const buildFastify = () => {
  const app = fastify({ logger: true });

  app.register(fastifyCors, {
    origin: '*',
  });

  // Declare a route
  app.get('/devis', async () => getAllDevisUseCaseController.execute());

  return app;
};

export const start = async (app: FastifyInstance) => {
  try {
    await app.listen(3001);
  } catch (err) {
    app.log.error(err);
    process.exit(1);
  }
};
