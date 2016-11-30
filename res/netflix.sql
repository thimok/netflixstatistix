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
(4, 'Sven blondhaar', 'Pelletroad 2112', 'Kanto Region');

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

CREATE TABLE `programma` (
  `ID` varchar(20) PRIMARY KEY,
  `Titel` varchar(20) DEFAULT NULL,
  `Tijdsduur` date DEFAULT NULL
);

CREATE TABLE `serie` (
  `Titel` varchar(20) PRIMARY KEY,
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
  `SerieTitel` varchar(20) DEFAULT NULL,

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
  `Taal` varchar(20) DEFAULT NULL,
  `Leeftijdsindicatie` int(11) DEFAULT NULL,

  CONSTRAINT
    FOREIGN KEY (ID) REFERENCES `programma` (ID)
      ON UPDATE CASCADE
      ON DELETE RESTRICT
);

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
