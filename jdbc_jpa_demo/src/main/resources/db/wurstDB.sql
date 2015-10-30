-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 30. Okt 2015 um 15:12
-- Server-Version: 10.0.17-MariaDB
-- PHP-Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `wurstDB`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `wurst`
--

CREATE TABLE `wurst` (
  `plu` int(11) NOT NULL,
  `bezeichnung` varchar(30) NOT NULL,
  `kilopreis` double(10,2) NOT NULL,
  `kilobestand` double(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `wurst`
--

INSERT INTO `wurst` (`plu`, `bezeichnung`, `kilopreis`, `kilobestand`) VALUES
(1, 'Wurstaufschnitt', 9.50, 148.600),
(2, 'Bierschinken', 10.36, 23.140),
(999, 'Ullis Schwarzgeld', 0.00, 9999999.999);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `wurst`
--
ALTER TABLE `wurst`
  ADD PRIMARY KEY (`plu`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
