CREATE TABLE `abonnement` (
  `AbonneeNr` int(11) PRIMARY KEY,
  `Naam` varchar(20) DEFAULT NULL,
  `Adres` varchar(20) DEFAULT NULL,
  `Woonplaats` varchar(20) DEFAULT NULL
);

INSERT INTO abonnement (AbonneeNr, Naam, Adres, Woonplaats) VALUES
(1, 'Destiny LongHart', 'Middensaw 104', 'Rotterdam'),
(2, 'Devon Marsham', 'Hindersteinstraat 1', 'Rotterdam'),
(3, 'Jon Snow', 'Westeros 12', 'Amsterdam'),
(4, 'Sven blondhaar', 'Pelletroad 2112', 'Kanto Region'),
(5, 'Joost Kalen', 'Kerkstraat 18', 'Enschede'),
(6, 'Henk Pietersen', 'Dijkje 1', 'Groningen');

CREATE TABLE `profiel` (
  `Naam` varchar(20),
  `Geboortedatum` date DEFAULT NULL,
  `AbonneeNr` int(11),

  CONSTRAINT
    PRIMARY KEY (Naam, AbonneeNr),

  CONSTRAINT
    FOREIGN KEY (AbonneeNr) REFERENCES `abonnement` (AbonneeNr)
      ON UPDATE CASCADE
      ON DELETE RESTRICT
);

INSERT INTO profiel (Naam, Geboortedatum, AbonneeNr) VALUES
('StoereJoost2008', '2008-08-12', 5),
('Sven902', '1999-07-31', 4),
('Henkie', '1990-02-02', 1),
('Henkie2', '1990-02-02', 1),
('Kerstman', '1802-12-31', 3),
('SinterClass', "1994-03-18", 3),
('DikkeBMW', '1998-02-19', 2),
('Wolfhunter82', '2005-11-01', 2);

CREATE TABLE `programma` (
  `ID` varchar(20) PRIMARY KEY,
  `Titel` varchar(40) DEFAULT NULL,
  `Tijdsduur` time DEFAULT NULL
);

INSERT INTO programma (ID, Titel, Tijdsduur) VALUES
(1, 'Orange Is The New Black', '01:30:00'),
(2, 'House of Cards', '00:50:00'),
(3, 'The Wolf Of Wallstreet', '03:00:00'),
(4, 'Breaking Bad', '00:55:00'),
(5, 'Superbad', '01:43:00'),
(6, 'The Godfather', '02:48:00'),
(7, 'Inception', '02:28:00'),
(8, 'Up', '01:36:00');

CREATE TABLE `serie` (
  `Titel` varchar(40) PRIMARY KEY,
  `Genre` varchar(20) DEFAULT NULL,
  `Taal` varchar(20) DEFAULT NULL,
  `Leeftijdsindicatie` varchar(20) DEFAULT NULL,
  `Gerelateerd` varchar(20) DEFAULT NULL,

  CONSTRAINT
    FOREIGN KEY (Gerelateerd) REFERENCES  `Serie` (Titel)
      ON UPDATE CASCADE
      ON DELETE RESTRICT
);

CREATE TABLE `aflevering` (
  `ID` varchar(20) PRIMARY KEY,
  `Volgnummer` varchar(20) DEFAULT NULL,
  `SerieTitel` varchar(40) DEFAULT NULL,

  CONSTRAINT
    FOREIGN KEY (Serietitel) REFERENCES `serie` (Titel)
      ON UPDATE CASCADE
      ON DELETE RESTRICT,

  CONSTRAINT
    FOREIGN KEY (ID) REFERENCES `programma` (ID)
      ON UPDATE CASCADE
      ON DELETE RESTRICT
);

CREATE TABLE `film` (
  `ID` varchar(20) PRIMARY KEY,
  `Genre` varchar(20) DEFAULT NULL,
  `Taal` varchar(20) DEFAULT 'Engels',
  `Leeftijdsindicatie` int(2) DEFAULT NULL,

  CONSTRAINT
    FOREIGN KEY (ID) REFERENCES `programma` (ID)
      ON UPDATE CASCADE
      ON DELETE RESTRICT
);

INSERT INTO film (ID, Genre, Taal, Leeftijdsindicatie) VALUES
(3, 'Misdaad, Komedie', 'Engels', 16),
(5, 'Komedie', 'Engels', 12),
(6, 'Misdaad, Drama', 'Engels', 16),
(7, 'Thriller, Sciencefiction', 'Engels' 12),
(8, 'Animatie, Avontuur', 'Nederlands', 6);

CREATE TABLE `voortgang` (
  `Profielnaam` varchar(20),
  `AbonneeNr` int(11),
  `ProgrammaID` varchar(20),

  CONSTRAINT
    PRIMARY KEY (Profielnaam, AbonneeNr, ProgrammaID),

  CONSTRAINT
    FOREIGN KEY (Profielnaam) REFERENCES `profiel` (Naam)
      ON UPDATE CASCADE
      ON DELETE RESTRICT,
  CONSTRAINT
    FOREIGN KEY (AbonneeNr) REFERENCES `profiel` (AbonneeNr)
      ON UPDATE CASCADE
      ON DELETE RESTRICT,
  CONSTRAINT
    FOREIGN KEY (ProgrammaID) REFERENCES `programma` (ID)
      ON UPDATE CASCADE
      ON DELETE RESTRICT
);
