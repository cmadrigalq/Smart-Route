-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Generation Time: Jan 14, 2018 at 02:03 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smart_routes`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `empresa` varchar(20) NOT NULL,
  `ruta1` varchar(5) NOT NULL,
  `ruta2` varchar(5) NOT NULL,
  `descripcion` text NOT NULL,
  `tarifa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `empresa`
--

CREATE TABLE `empresa` (
  `nombre` varchar(20) NOT NULL,
  `telefono` varchar(14) DEFAULT NULL,
  `link` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `horario`
--

CREATE TABLE `horario` (
  `Bus` bigint(20) UNSIGNED NOT NULL,
  `Hora` time NOT NULL,
  `id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `parada`
--

CREATE TABLE `parada` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `puntoGeografico` bigint(20) UNSIGNED NOT NULL,
  `siguienteParada` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `punto`
--

CREATE TABLE `punto` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `punto`
--

INSERT INTO `punto` (`id`, `latitud`, `longitud`) VALUES
(1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ruta`
--

CREATE TABLE `ruta` (
  `nombre` varchar(5) NOT NULL,
  `primeraParada` bigint(20) UNSIGNED NOT NULL,
  `ultimaParada` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `PKempresa` (`empresa`),
  ADD KEY `PKruta1` (`ruta1`),
  ADD KEY `PKruta2` (`ruta2`);

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`nombre`);

--
-- Indexes for table `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `fkBus` (`Bus`);

--
-- Indexes for table `parada`
--
ALTER TABLE `parada`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnext` (`siguienteParada`),
  ADD KEY `FKpunto` (`puntoGeografico`);

--
-- Indexes for table `punto`
--
ALTER TABLE `punto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `ruta`
--
ALTER TABLE `ruta`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `FK1` (`primeraParada`),
  ADD KEY `FK2` (`ultimaParada`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `horario`
--
ALTER TABLE `horario`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `punto`
--
ALTER TABLE `punto`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `PKempresa` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`nombre`),
  ADD CONSTRAINT `PKruta1` FOREIGN KEY (`ruta1`) REFERENCES `ruta` (`nombre`),
  ADD CONSTRAINT `PKruta2` FOREIGN KEY (`ruta2`) REFERENCES `ruta` (`nombre`);

--
-- Constraints for table `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `fkBus` FOREIGN KEY (`Bus`) REFERENCES `bus` (`id`);

--
-- Constraints for table `parada`
--
ALTER TABLE `parada`
  ADD CONSTRAINT `FKnext` FOREIGN KEY (`siguienteParada`) REFERENCES `parada` (`id`),
  ADD CONSTRAINT `FKpunto` FOREIGN KEY (`puntoGeografico`) REFERENCES `punto` (`id`);

--
-- Constraints for table `ruta`
--
ALTER TABLE `ruta`
  ADD CONSTRAINT `FK1` FOREIGN KEY (`primeraParada`) REFERENCES `parada` (`id`),
  ADD CONSTRAINT `FK2` FOREIGN KEY (`ultimaParada`) REFERENCES `parada` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
