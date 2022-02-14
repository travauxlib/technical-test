import React from 'react';
import { RouteObject } from 'react-router-dom';
import { DevisLayout } from '../components/DevisLayout';
import { DevisList } from '../components/DevisList';

export const devisRoutes: RouteObject[] = [{
  element: <DevisLayout />,
  path: '/devis',
  children: [
    { element: <DevisList />, index: true },
  ],
}];
