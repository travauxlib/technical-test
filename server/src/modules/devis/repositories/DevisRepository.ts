import { Devis } from '../domain/Devis';
import { knex } from '../../../knex';

// eslint-disable-next-line
export class DevisRepository {
  public async all(): Promise<Devis[]> {
    return knex<Devis>('devis')
      .select('*');
  }
}
