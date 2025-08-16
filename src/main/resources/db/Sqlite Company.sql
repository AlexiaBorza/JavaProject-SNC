CREATE TABLE Company (
    cui TEXT PRIMARY KEY,
    name TEXT,
    address TEXT,
    county TEXT,
    city TEXT
);

CREATE TABLE Financial_Data (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    year INTEGER,
    cifra_afaceri REAL,
    profit_net REAL,
    profit_brut REAL,
    active_totale REAL,
    capitaluri_proprii REAL,
    datorii_totale REAL,
    numar_angajati INTEGER,
    company_cui TEXT,
    FOREIGN KEY(company_cui) REFERENCES Company(cui)
);
