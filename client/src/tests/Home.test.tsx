import React from 'react';
import { render, screen } from '@testing-library/react';
import { Home } from '../components/Home';

describe('<Home />', () => {
  test('Should display a welcome message', () => {
    render(<Home />);

    expect(screen.getByText('Bienvenue')).toBeVisible();
  });
});
