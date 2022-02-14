import { buildFastify } from '../../../app';

describe('Devis module', () => {
  test('[GET] /devis', async () => {
    const app = buildFastify();

    const response = await app.inject({
      method: 'GET',
      url: '/devis',
    });

    const data = await response.json();

    expect(data.length).toBe(2);
  });
});
