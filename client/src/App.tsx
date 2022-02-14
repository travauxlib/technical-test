import * as React from 'react';
import { AppProvider } from './provider/app';
import { AppRoutes } from './routes';

export const App: React.FC = () => (
  <AppProvider>
    <AppRoutes />
  </AppProvider>
);
