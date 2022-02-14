import { useState, useMemo } from 'react';
import { Devis } from '../types';

export const useGetAllDevis = () => {
  const [devis, setDevis] = useState<Devis[] | undefined>();

  useMemo(async () => {
    const response = await fetch('http://127.0.0.1:3001/devis');
    const json = await response.json();
    setDevis(json);
  }, [setDevis]);

  return devis;
};
