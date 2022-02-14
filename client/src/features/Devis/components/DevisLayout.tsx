import React from 'react';
import { Link, Outlet } from 'react-router-dom';

export function DevisLayout() {
  return (
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/devis">Voir tous les devis</Link>
          </li>
        </ul>
      </nav>
      <Outlet />
    </div>
  );
}
