import sqlite from 'better-sqlite3';

// this is a top-level await
(async () => {
  // open the database
  const db = sqlite('./src/knex/database.sqlite');

  db.exec(`CREATE TABLE devis
    (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      title  VARCHAR(255) NOT NULL,
      codeSms VARCHAR(100) NOT NULL
    )
    `);

  db.exec(`CREATE TABLE devis_lignes
    (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      devis_id INTEGER NOT NULL REFERENCES devis(id),
      description VARCHAR(255) NOT NULL,
      prixUnitaireHt INTEGER NOT NULL,
      tva FLOAT NOT NULL,
      quantite INTEGER NOT NULL,
      unite VARCHAR(100) NOT NULL
    )
    `);

  const insertDevis = db.prepare('INSERT INTO devis (title, codeSms) VALUES (@title, @codeSms)');

  db.transaction(() => {
    insertDevis.run({ title: 'Construction garage', codeSms: 'beton-123-rouge' });
    insertDevis.run({ title: 'Travaux divers dans la maison', codeSms: 'chene-456-bleu' });
  })();

  const insertLine = db.prepare(`INSERT INTO devis_lignes (devis_id, description, prixUnitaireHt, tva, quantite, unite)
                                  VALUES (@devis_id, @description, @prixUnitaireHt, @tva, @quantite, @unite)`);

  db.transaction(() => {
    insertLine.run({
      devis_id: 1, description: 'Terrassement', prixUnitaireHt: 10, tva: 10, quantite: 1, unite: 'unite',
    });
    insertLine.run({
      devis_id: 1, description: 'Fourniture et pose de parpaing', prixUnitaireHt: 37, tva: 10, quantite: 100, unite: 'm2',
    });
    insertLine.run({
      devis_id: 1, description: 'Fondations', prixUnitaireHt: 89, tva: 5.5, quantite: 100, unite: 'm2',
    });
  })();

  db.transaction(() => {
    insertLine.run({
      devis_id: 2, description: 'Protection sol', prixUnitaireHt: 3, tva: 10, quantite: 30, unite: 'm2',
    });
    insertLine.run({
      devis_id: 2, description: 'Carrelage', prixUnitaireHt: 18, tva: 10, quantite: 30, unite: 'm2',
    });
    insertLine.run({
      devis_id: 2, description: "Fourniture et pose d'une baignoire", prixUnitaireHt: 837, tva: 20, quantite: 1, unite: 'unite',
    });
    insertLine.run({
      devis_id: 2, description: 'Enlèvement des gravat', prixUnitaireHt: 5, tva: 5.5, quantite: 100, unite: 'm2',
    });
  })();
})();
