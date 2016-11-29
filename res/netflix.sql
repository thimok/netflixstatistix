-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2016 at 05:39 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `netflix`
--

-- --------------------------------------------------------

--
-- Table structure for table `abonoment`
--

CREATE TABLE `abonoment` (
  `AbonneeNummer` int(11) NOT NULL,
  `Naam` varchar(20) DEFAULT NULL,
  `Adres` varchar(20) DEFAULT NULL,
  `Woonplaats` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `abonoment`
--

INSERT INTO `abonoment` (`AbonneeNummer`, `Naam`, `Adres`, `Woonplaats`) VALUES
(1, 'Desteny LongHart', 'Middensaw 104', 'Rotterdam'),
(2, 'Devon Marsham', 'Hindersteinstraat 1', 'Rotterdam'),
(3, 'Jon Snow', 'Westeros 12', 'Amsterdam'),
(4, 'Sven blondhaar', 'Pelletroad 2112', 'Kanto Region');

-- --------------------------------------------------------

--
-- Table structure for table `aflevering`
--

CREATE TABLE `aflevering` (
  `ID` varchar(20) DEFAULT NULL,
  `Volgnummer` varchar(20) DEFAULT NULL,
  `SerieTitel` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `ID` varchar(20) DEFAULT NULL,
  `Genre` varchar(20) DEFAULT NULL,
  `Taal` varchar(20) DEFAULT NULL,
  `Leeftijdsindicatie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `profiel`
--

CREATE TABLE `profiel` (
  `Naam` varchar(20) NOT NULL,
  `Geboortedatum` date DEFAULT NULL,
  `AbonneeNummer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `programma`
--

CREATE TABLE `programma` (
  `ID` varchar(20) NOT NULL,
  `Titel` varchar(20) DEFAULT NULL,
  `Tijdsduur` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `serie`
--

CREATE TABLE `serie` (
  `Titel` varchar(20) NOT NULL,
  `Genre` varchar(20) DEFAULT NULL,
  `Taal` varchar(20) DEFAULT NULL,
  `Leeftijdsindicatie` varchar(20) DEFAULT NULL,
  `Gerelateerd` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `voortgang`
--

CREATE TABLE `voortgang` (
  `Profielnaam` varchar(20) NOT NULL,
  `ProgrammaID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `abonoment`
--
ALTER TABLE `abonoment`
  ADD PRIMARY KEY (`AbonneeNummer`);

--
-- Indexes for table `aflevering`
--
ALTER TABLE `aflevering`
  ADD KEY `Aflevering` (`ID`),
  ADD KEY `SerieTitel` (`SerieTitel`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD KEY `Film` (`ID`);

--
-- Indexes for table `profiel`
--
ALTER TABLE `profiel`
  ADD PRIMARY KEY (`Naam`,`AbonneeNummer`),
  ADD KEY `Profiel` (`AbonneeNummer`);

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
  ADD KEY `Seri` (`Gerelateerd`);

--
-- Indexes for table `voortgang`
--
ALTER TABLE `voortgang`
  ADD PRIMARY KEY (`Profielnaam`,`ProgrammaID`),
  ADD KEY `ProgrammaID` (`ProgrammaID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aflevering`
--
ALTER TABLE `aflevering`
  ADD CONSTRAINT `Aflevering` FOREIGN KEY (`ID`) REFERENCES `programma` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aflevering_ibfk_1` FOREIGN KEY (`SerieTitel`) REFERENCES `serie` (`Titel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `Film` FOREIGN KEY (`ID`) REFERENCES `programma` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `profiel`
--
ALTER TABLE `profiel`
  ADD CONSTRAINT `Profiel` FOREIGN KEY (`AbonneeNummer`) REFERENCES `abonoment` (`AbonneeNummer`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `serie`
--
ALTER TABLE `serie`
  ADD CONSTRAINT `Seri` FOREIGN KEY (`Gerelateerd`) REFERENCES `serie` (`Titel`);

--
-- Constraints for table `voortgang`
--
ALTER TABLE `voortgang`
  ADD CONSTRAINT `Voortgang` FOREIGN KEY (`Profielnaam`) REFERENCES `profiel` (`Naam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `voortgang_ibfk_1` FOREIGN KEY (`ProgrammaID`) REFERENCES `programma` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
