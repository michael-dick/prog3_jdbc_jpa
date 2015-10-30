-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 30. Okt 2015 um 15:13
-- Server-Version: 10.0.17-MariaDB
-- PHP-Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `jpaStudentDB`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `KITCARD`
--

CREATE TABLE `KITCARD` (
  `CARD_ID` int(11) NOT NULL,
  `DEPOSIT` double DEFAULT NULL,
  `STUDENT_STUDENT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `KITCARD`
--

INSERT INTO `KITCARD` (`CARD_ID`, `DEPOSIT`, `STUDENT_STUDENT_ID`) VALUES
(1, 20, 1641518);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `SEQUENCE`
--

CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `SEQUENCE`
--

INSERT INTO `SEQUENCE` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '50');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `STUDENT`
--

CREATE TABLE `STUDENT` (
  `STUDENT_ID` int(11) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `KITCARD_CARD_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `STUDENT`
--

INSERT INTO `STUDENT` (`STUDENT_ID`, `EMAIL`, `FIRSTNAME`, `LASTNAME`, `KITCARD_CARD_ID`) VALUES
(1641518, 'ukdyn@student.kit.edu', 'Michael', 'Dick', 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `KITCARD`
--
ALTER TABLE `KITCARD`
  ADD PRIMARY KEY (`CARD_ID`),
  ADD KEY `FK_KITCARD_STUDENT_STUDENT_ID` (`STUDENT_STUDENT_ID`);

--
-- Indizes für die Tabelle `SEQUENCE`
--
ALTER TABLE `SEQUENCE`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indizes für die Tabelle `STUDENT`
--
ALTER TABLE `STUDENT`
  ADD PRIMARY KEY (`STUDENT_ID`),
  ADD KEY `FK_STUDENT_KITCARD_CARD_ID` (`KITCARD_CARD_ID`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `KITCARD`
--
ALTER TABLE `KITCARD`
  ADD CONSTRAINT `FK_KITCARD_STUDENT_STUDENT_ID` FOREIGN KEY (`STUDENT_STUDENT_ID`) REFERENCES `STUDENT` (`STUDENT_ID`);

--
-- Constraints der Tabelle `STUDENT`
--
ALTER TABLE `STUDENT`
  ADD CONSTRAINT `FK_STUDENT_KITCARD_CARD_ID` FOREIGN KEY (`KITCARD_CARD_ID`) REFERENCES `KITCARD` (`CARD_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
