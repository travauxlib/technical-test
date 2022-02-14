export type DevisLigne = {
  id: number,
  description: string,
  prixUnitaireHt: number,
  tva: number,
  quantite: number,
  unite: string,
}

export type Devis = {
  id: number,
  title: string,
  codeSms: string;
  lignes?: DevisLigne[],
}
