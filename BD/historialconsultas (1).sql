-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-10-2023 a las 23:09:26
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sql9598240`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialconsultas`
--

CREATE TABLE `historialconsultas` (
  `ID` int(11) NOT NULL,
  `ID_MASCOTA` int(11) NOT NULL,
  `NOMBRE_MASCOTA` varchar(50) NOT NULL,
  `FECHA` date DEFAULT NULL,
  `SERVICIO` varchar(50) NOT NULL,
  `PRECIO` float NOT NULL,
  `MOTIVO` varchar(500) NOT NULL,
  `DIAGNOSTICO` varchar(500) NOT NULL,
  `RECETA` varchar(500) NOT NULL,
  `PARAMETROS` varchar(500) NOT NULL,
  `ID_PROPIETARIO` int(11) NOT NULL,
  `MEDICO` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `historialconsultas`
--

INSERT INTO `historialconsultas` (`ID`, `ID_MASCOTA`, `NOMBRE_MASCOTA`, `FECHA`, `SERVICIO`, `PRECIO`, `MOTIVO`, `DIAGNOSTICO`, `RECETA`, `PARAMETROS`, `ID_PROPIETARIO`, `MEDICO`) VALUES
(4, 8, 'Fili', '2023-09-05', 'Cosulta', 300, 'Revision General', '', '', '', 2, 'Mario'),
(6, 3, 'Hanna', '2023-09-12', 'Consulta', 300, 'Revision general', '', '', '', 3, 'Mario'),
(8, 7, 'Frida', '2023-09-05', 'Consulta', 300, 'Revision general', '', '', '', 6, 'Mario'),
(10, 8, 'Fili', '2023-09-18', 'Consulta', 500, 'Consulta basica, solo se requirio la ejecucion de la mascota', '', '', '', 2, 'Mario'),
(11, 8, 'Fili', '2023-09-23', 'Consulta', 300, 'Este es la prueba de fuego para comprobar que no soy un pendejo como el damian, ojala salga bien', '', '', '', 2, 'Mario'),
(12, 8, 'Fili', '2023-09-23', 'Consulta', 1850, 'Jijijiji, si me la pela el pendejo del damian la neta, esta consulta esta cara porque me vale verga todo', '', '', '', 2, 'Mario'),
(13, 8, 'Fili', '2023-09-24', 'Consulta', 250, 'dsasdasdasdasd', '', '', '', 2, 'Mario'),
(14, 8, 'Fili', '2023-09-24', 'Consulta', 1800, 'Salud grave, tuvimos que dormirlo al muy oendejo', '', '', '', 2, 'Admin'),
(15, 8, 'Fili', '2023-09-25', 'Consulta', 500, 'asdasddas', '', '', '', 2, 'Mario'),
(16, 8, 'Fili', '2023-09-25', 'Consulta', 250, 'wdsad2ds', '', '', '', 2, 'Mario'),
(17, 8, 'Manolo', '2023-10-03', 'Consulta', 500, 'dasdasdasdasd', '', '', '', 2, 'Mario'),
(18, 8, 'Manolo', '2023-10-03', 'Consulta', 500, 'Revision de golpe en la trompa', '', '', '', 2, NULL),
(19, 8, 'Manolo', '2023-10-03', 'Consulta', 556, 'ddd', '', '', '', 2, NULL),
(20, 8, 'Fili', '2023-10-04', 'Consulta', 150, 'adsdsadsadasdasasd', '', '', '', 2, 'Mario'),
(21, 8, 'Hanna', '2023-10-04', 'Consulta', 777, 'Esta consulta es una prueba para saber si se le aplica a fili o a hanna\nQue buen vergazo le metio Jose Luis Garcia Delgadillo aka (el michoacano) a Cesar Armando Hernandez Garcia aka (uchiha)\nEl precio es el equivalente al vergazo que dio ayer el michoacano', '', '', '', 2, 'Mario'),
(22, 8, 'Negro', '2023-10-09', 'Consulta', 500, 'kjghghg', '', '', '', 2, 'Mario'),
(23, 3, 'Hanna', '2023-10-11', 'Consulta', 500, 'A\nA\nA\nA\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '', '', '', 3, NULL),
(24, 3, 'Hanna', '2023-10-11', 'Consulta', 100, 'asadadsa', '', '', '', 3, ''),
(25, 3, 'Hanna', '2023-10-11', 'Consulta', 250, 'Diarrea', '', '', '', 3, ''),
(26, 3, 'Hanna', '2023-10-11', 'Consulta', 250, 'dasdasddas', '', '', '', 3, ''),
(27, 3, 'Hanna', '2023-10-11', 'Consulta', 500, 'Diarrea y vomito', 'Parvovirus', 'Grastroprazol 50mg 1tab/24hrs', '18 kg', 3, '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `historialconsultas`
--
ALTER TABLE `historialconsultas`
  ADD PRIMARY KEY (`ID`,`ID_MASCOTA`,`ID_PROPIETARIO`),
  ADD KEY `fk_ID_Mascota` (`ID_MASCOTA`),
  ADD KEY `fk_ID_Propietarioo` (`ID_PROPIETARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historialconsultas`
--
ALTER TABLE `historialconsultas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historialconsultas`
--
ALTER TABLE `historialconsultas`
  ADD CONSTRAINT `fk_ID_Mascota` FOREIGN KEY (`ID_MASCOTA`) REFERENCES `mascota` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ID_Propietarioo` FOREIGN KEY (`ID_PROPIETARIO`) REFERENCES `propietario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
