import Knex from 'knex';
import path from 'path';

export const knex = Knex({
  client: 'better-sqlite3', // or 'better-  '
  connection: {
    filename: path.resolve(__dirname, 'database.sqlite'),
    debug: true,
  },
  useNullAsDefault: true,
});
