--
-- Database: `netflix`
--

-- --------------------------------------------------------

--
-- Table structure for table `aflevering`
--

CREATE TABLE `aflevering` (
  `ID` int(10) NOT NULL,
  `Volgnummer` int(4) DEFAULT NULL,
  `SerieTitel` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aflevering`
--

INSERT INTO `aflevering` (`ID`, `Volgnummer`, `SerieTitel`) VALUES
(1, 101, 'Orange Is The New Black'),
(2, 301, 'House of Cards'),
(4, 206, 'Breaking Bad'),
(9, 102, 'Orange Is The New Black'),
(10, 103, 'Orange Is The New Black'),
(11, 302, 'House of Cards'),
(12, 101, 'Game of Thrones'),
(13, 102, 'Game of Thrones'),
(14, 101, 'Arrow'),
(15, 103, 'Arrow'),
(16, 103, 'The Flash'),
(17, 106, 'The Flash'),
(18, 101, 'Legends of Tomorrow'),
(19, 102, 'Legends of Tomorrow'),
(20, 101, 'Supergirl'),
(21, 102, 'Supergirl'),
(22, 107, 'Supernatural'),
(23, 108, 'Supernatural');

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `ID` int(10) NOT NULL,
  `Genre` varchar(40) DEFAULT NULL,
  `Taal` varchar(20) DEFAULT 'Engels',
  `Leeftijdsindicatie` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`ID`, `Genre`, `Taal`, `Leeftijdsindicatie`) VALUES
(3, 'Misdaad, Komedie', 'Engels', 16),
(5, 'Komedie', 'Engels', 12),
(6, 'Misdaad, Drama', 'Engels', 16),
(7, 'Thriller, Sciencefiction', 'Engels', 12),
(8, 'Animatie, Avontuur', 'Nederlands', 6);

-- --------------------------------------------------------

--
-- Table structure for table `profiel`
--

CREATE TABLE `profiel` (
  `Naam` varchar(20) NOT NULL,
  `Geboortedatum` date DEFAULT NULL,
  `AbonneeNr` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profiel`
--

INSERT INTO `profiel` (`Naam`, `Geboortedatum`, `AbonneeNr`) VALUES
('BatKight', '1993-06-24', 2),
('ChildofDestiny', '1997-02-15', 7),
('DestinyChild', '1997-02-15', 7),
('Devonator', '1993-06-24', 2),
('Gman Martina', '1992-12-18', 8),
('Henkie', '1967-08-07', 6),
('HenkLover107', '1998-11-11', 6),
('HenkSlayer', '1990-02-02', 6),
('Kerstman', '1802-12-31', 3),
('Luka Skywalker', '1998-11-11', 10),
('MartinaMan', '1992-12-18', 8),
('PAINintheAss', '1993-10-05', 1),
('RageObiTwan', '1992-01-21', 9),
('SinterClass', '1994-03-18', 3),
('StoereJoost2008', '2008-08-12', 5),
('Sven902', '1999-07-31', 4),
('Wolfhunter82', '2005-11-01', 2);

-- --------------------------------------------------------

--
-- Table structure for table `programma`
--

CREATE TABLE `programma` (
  `ID` int(10) NOT NULL,
  `Titel` varchar(40) DEFAULT NULL,
  `Tijdsduur` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `programma`
--

INSERT INTO `programma` (`ID`, `Titel`, `Tijdsduur`) VALUES
(1, 'Orange Is The New Black S01E01', '01:30:00'),
(2, 'House of Cards S03E01', '00:50:00'),
(3, 'The Wolf Of Wallstreet', '03:00:00'),
(4, 'Breaking Bad S02E06', '00:55:00'),
(5, 'Superbad', '01:43:00'),
(6, 'The Godfather', '02:48:00'),
(7, 'Inception', '02:28:00'),
(8, 'Up', '01:36:00'),
(9, 'Orange Is The New Black S01E02', '01:30:00'),
(10, 'Orange Is The New Black S01E03', '01:30:00'),
(11, 'House of Cards S03E02', '00:47:00'),
(12, 'Game of Thrones S01E01', '00:52:00'),
(13, 'Game of Thrones S01E02', '00:52:00'),
(14, 'Arrow S01E01', '00:42:00'),
(15, 'Arrow S01E02', '00:42:00'),
(16, 'The Flash S01E01', '00:42:00'),
(17, 'The Flash S01E02', '00:42:00'),
(18, 'Legends of Tomorrow S01E01', '00:45:00'),
(19, 'Legends of Tomorrow S01E02', '00:45:00'),
(20, 'Supergirl S01E01', '00:43:00'),
(21, 'Supergirl S01E02', '00:43:00'),
(22, 'Supernatural S01E01', '00:44:00'),
(23, 'Supernatural S01E01', '00:44:00');

-- --------------------------------------------------------

--
-- Table structure for table `serie`
--

CREATE TABLE `serie` (
  `Titel` varchar(40) NOT NULL,
  `Genre` varchar(40) DEFAULT NULL,
  `Taal` varchar(20) DEFAULT 'Engels',
  `Leeftijdsindicatie` int(2) DEFAULT NULL,
  `Gerelateerd` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serie`
--

INSERT INTO `serie` (`Titel`, `Genre`, `Taal`, `Leeftijdsindicatie`, `Gerelateerd`) VALUES
('Arrow', 'Action, Adventure, Crime', 'Engels', 12, 'The Flash'),
('Breaking Bad', 'Drama, Misdaad', 'Engels', 17, NULL),
('Game of Thrones', 'Adventure, Drama, Fantasy', 'Engels', 16, NULL),
('House of Cards', 'Drama, Politiek Thriller', 'Engels', 16, 'House of Cards'),
('Legends of Tomorrow', 'Action, Adventure, Drama', 'Engels', 12, 'Arrow'),
('Orange Is The New Black', 'Komedie, Drama, Misdaad', 'Engels', 18, NULL),
('Supergirl', 'Action, Adventure, Drama', 'Engels', 12, 'The Flash'),
('Supernatural', 'Drama, Fantasy, Horror', 'Engels', 16, NULL),
('The Flash', 'Action, Drama, Adventure', 'Engels', 12, 'Arrow');

-- --------------------------------------------------------

--
-- Table structure for table `voortgang`
--

CREATE TABLE `voortgang` (
  `Profielnaam` varchar(20) NOT NULL,
  `AbonneeNr` int(10) NOT NULL,
  `ProgrammaID` int(10) NOT NULL,
  `BekekenPercentage` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voortgang`
--

INSERT INTO `voortgang` (`Profielnaam`, `AbonneeNr`, `ProgrammaID`, `BekekenPercentage`) VALUES
('BatKight', 2, 12, 100),
('BatKight', 2, 16, 100),
('ChildofDestiny', 7, 20, 58),
('Devonator', 2, 14, 100),
('Devonator', 2, 18, 100),
('Gman Martina', 8, 4, 78),
('Henkie', 6, 2, 87),
('HenkLover107', 6, 9, 58),
('Luka Skywalker', 10, 18, 74),
('PAINintheAss', 1, 22, 78),
('RageObiTwan', 9, 15, 95),
('Sinterclass', 3, 1, 100),
('Sinterclass', 3, 9, 98),
('Sinterclass', 3, 10, 12),
('StoereJoost2008', 5, 4, 34),
('Sven902', 4, 3, 20),
('Sven902', 4, 4, 10),
('Sven902', 4, 5, 98),
('Wolfhunter82', 2, 23, 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aflevering`
--
ALTER TABLE `aflevering`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `SerieTitel` (`SerieTitel`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `profiel`
--
ALTER TABLE `profiel`
  ADD PRIMARY KEY (`Naam`,`AbonneeNr`),
  ADD KEY `AbonneeNr` (`AbonneeNr`);

--
-- Indexes for table `programma`
--
ALTER TABLE `programma`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`Titel`),
  ADD KEY `Gerelateerd` (`Gerelateerd`);

--
-- Indexes for table `voortgang`
--
ALTER TABLE `voortgang`
  ADD PRIMARY KEY (`Profielnaam`,`AbonneeNr`,`ProgrammaID`),
  ADD KEY `AbonneeNr` (`AbonneeNr`),
  ADD KEY `ProgrammaID` (`ProgrammaID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aflevering`
--
ALTER TABLE `aflevering`
  ADD CONSTRAINT `aflevering_ibfk_1` FOREIGN KEY (`SerieTitel`) REFERENCES `serie` (`Titel`) ON UPDATE CASCADE,
  ADD CONSTRAINT `aflevering_ibfk_2` FOREIGN KEY (`ID`) REFERENCES `programma` (`ID`) ON UPDATE CASCADE;

--
-- Constraints for table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `programma` (`ID`) ON UPDATE CASCADE;

--
-- Constraints for table `profiel`
--
ALTER TABLE `profiel`
  ADD CONSTRAINT `profiel_ibfk_1` FOREIGN KEY (`AbonneeNr`) REFERENCES `abonnement` (`AbonneeNr`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `serie`
--
ALTER TABLE `serie`
  ADD CONSTRAINT `serie_ibfk_1` FOREIGN KEY (`Gerelateerd`) REFERENCES `serie` (`Titel`) ON UPDATE CASCADE;

--
-- Constraints for table `voortgang`
--
ALTER TABLE `voortgang`
  ADD CONSTRAINT `voortgang_ibfk_1` FOREIGN KEY (`Profielnaam`) REFERENCES `profiel` (`Naam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `voortgang_ibfk_2` FOREIGN KEY (`AbonneeNr`) REFERENCES `profiel` (`AbonneeNr`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `voortgang_ibfk_3` FOREIGN KEY (`ProgrammaID`) REFERENCES `programma` (`ID`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
