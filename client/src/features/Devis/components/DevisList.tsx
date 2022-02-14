import React from 'react';
import { useGetAllDevis } from '../api/getAllDevis';

export function DevisList() {
  const devisList = useGetAllDevis();
  return devisList ? (
    <>
      {devisList.map((devis) => (
        <div key={devis.id}>
          <div>{devis.title}</div>
        </div>
      ))}
    </>
  )
    : <div>Loading</div>;
}
