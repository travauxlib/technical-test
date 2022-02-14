import type { Config } from '@jest/types';

// Objet synchrone
const config: Config.InitialOptions = {
  setupFilesAfterEnv: ['./src/tests/jest.setup.ts'],
  globalSetup: './src/tests/globalSetup.ts',
  globalTeardown: './src/tests/globalTeardown.ts',
  verbose: true,
  preset: 'ts-jest',
  testEnvironment: 'node',
  transform: {
    '^.+\\.tsx?$': 'ts-jest',
  },
};

export default config;
