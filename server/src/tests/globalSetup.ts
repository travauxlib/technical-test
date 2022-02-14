import { buildFastify } from '../app';

export default async function () {
  const app = await buildFastify();

  await app.ready();

  (global as any).app = app;
}
