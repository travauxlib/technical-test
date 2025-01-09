CREATE TABLE devis
(
    uuid           UUID PRIMARY KEY,
    title   VARCHAR(255) NOT NULL,
    code_sms VARCHAR(100) NOT NULL
);

CREATE TABLE devis_lignes
(
    uuid           UUID PRIMARY KEY,
    devis_uuid       INTEGER      NOT NULL REFERENCES devis (uuid),
    description    VARCHAR(255) NOT NULL,
    prix_unitaire_ht INTEGER      NOT NULL,
    tva            FLOAT        NOT NULL,
    quantite       INTEGER      NOT NULL,
    unite          VARCHAR(100) NOT NULL
);