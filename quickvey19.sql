-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2020 a las 14:20:43
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `quickvey19`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_encuestas`
--

CREATE TABLE `tbl_encuestas` (
  `iIdEncuesta` int(11) NOT NULL,
  `cNombreEncuesta` varchar(100) NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_encuestasactivas`
--

CREATE TABLE `tbl_encuestasactivas` (
  `iIdEncuestaActiva` int(11) NOT NULL,
  `iIdEncuesta` int(11) NOT NULL,
  `dtInicioVigencia` date NOT NULL,
  `dtFinVigencia` date NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_encuestasrealizadas`
--

CREATE TABLE `tbl_encuestasrealizadas` (
  `iIdEncuestaRealizada` int(11) NOT NULL,
  `iIdEncuestaActiva` int(11) NOT NULL,
  `iIdUsuario` int(11) NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_perfiles`
--

CREATE TABLE `tbl_perfiles` (
  `iIdPerfil` int(11) NOT NULL,
  `cNombrePerfil` varchar(50) NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_personas`
--

CREATE TABLE `tbl_personas` (
  `iIdPersona` int(11) NOT NULL,
  `cPrimerApellido` varchar(50) NOT NULL,
  `cSegundoApellido` varchar(50) NOT NULL,
  `cNombre` varchar(100) NOT NULL,
  `dtFechaNacimiento` date NOT NULL,
  `cSexo` enum('H','M') NOT NULL,
  `cCorreoElectronico` varchar(100) NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_preguntas`
--

CREATE TABLE `tbl_preguntas` (
  `iIdPregunta` int(11) NOT NULL,
  `cPregunta` varchar(300) NOT NULL,
  `bActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_rel_encuestaspreguntas`
--

CREATE TABLE `tbl_rel_encuestaspreguntas` (
  `iIdEncuesta` int(11) DEFAULT NULL,
  `iIdPregunta` int(11) DEFAULT NULL,
  `lActivo` bit(1) DEFAULT NULL,
  `dtAlta` datetime DEFAULT NULL,
  `dtModificacion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_rel_perfilesusuarios`
--

CREATE TABLE `tbl_rel_perfilesusuarios` (
  `iIdUsuario` int(11) NOT NULL,
  `iIdPerfil` int(11) NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_rel_preguntasrespuestas`
--

CREATE TABLE `tbl_rel_preguntasrespuestas` (
  `iIdPregunta` int(11) NOT NULL,
  `iIdRespuesta` int(11) NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_respuestas`
--

CREATE TABLE `tbl_respuestas` (
  `iIdRespuesta` int(11) NOT NULL,
  `cRespuesta` varchar(100) NOT NULL,
  `iPuntaje` int(11) NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_respuestasencuestarealizada`
--

CREATE TABLE `tbl_respuestasencuestarealizada` (
  `iIdEncuestaRealizada` int(11) NOT NULL,
  `iIdPregunta` int(11) NOT NULL,
  `iIdRespuesta` int(11) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `iIdUsuario` int(11) NOT NULL,
  `iIdPersona` int(11) NOT NULL,
  `cNombreUsuario` varchar(100) NOT NULL,
  `cPassword` varchar(50) NOT NULL,
  `lActivo` bit(1) NOT NULL,
  `dtAlta` datetime NOT NULL,
  `dtModificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_encuestas`
--
ALTER TABLE `tbl_encuestas`
  ADD PRIMARY KEY (`iIdEncuesta`);

--
-- Indices de la tabla `tbl_encuestasactivas`
--
ALTER TABLE `tbl_encuestasactivas`
  ADD PRIMARY KEY (`iIdEncuestaActiva`),
  ADD KEY `iIdEncuesta` (`iIdEncuesta`);

--
-- Indices de la tabla `tbl_encuestasrealizadas`
--
ALTER TABLE `tbl_encuestasrealizadas`
  ADD PRIMARY KEY (`iIdEncuestaRealizada`),
  ADD KEY `iIdEncuestaActiva` (`iIdEncuestaActiva`) USING BTREE,
  ADD KEY `iIdUsuario` (`iIdUsuario`) USING BTREE;

--
-- Indices de la tabla `tbl_perfiles`
--
ALTER TABLE `tbl_perfiles`
  ADD PRIMARY KEY (`iIdPerfil`);

--
-- Indices de la tabla `tbl_personas`
--
ALTER TABLE `tbl_personas`
  ADD PRIMARY KEY (`iIdPersona`);

--
-- Indices de la tabla `tbl_preguntas`
--
ALTER TABLE `tbl_preguntas`
  ADD PRIMARY KEY (`iIdPregunta`);

--
-- Indices de la tabla `tbl_rel_encuestaspreguntas`
--
ALTER TABLE `tbl_rel_encuestaspreguntas`
  ADD UNIQUE KEY `iIdPregunta` (`iIdPregunta`),
  ADD KEY `iIdEncuesta` (`iIdEncuesta`);

--
-- Indices de la tabla `tbl_rel_perfilesusuarios`
--
ALTER TABLE `tbl_rel_perfilesusuarios`
  ADD KEY `iIdUsuario` (`iIdUsuario`),
  ADD KEY `iIdPerfil` (`iIdPerfil`);

--
-- Indices de la tabla `tbl_rel_preguntasrespuestas`
--
ALTER TABLE `tbl_rel_preguntasrespuestas`
  ADD KEY `iIdPregunta` (`iIdPregunta`),
  ADD KEY `iIdRespuesta` (`iIdRespuesta`);

--
-- Indices de la tabla `tbl_respuestas`
--
ALTER TABLE `tbl_respuestas`
  ADD PRIMARY KEY (`iIdRespuesta`);

--
-- Indices de la tabla `tbl_respuestasencuestarealizada`
--
ALTER TABLE `tbl_respuestasencuestarealizada`
  ADD KEY `iIdEncuestaRealizada` (`iIdEncuestaRealizada`),
  ADD KEY `iIdPregunta` (`iIdPregunta`),
  ADD KEY `iIdRespuesta` (`iIdRespuesta`);

--
-- Indices de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`iIdUsuario`),
  ADD UNIQUE KEY `iIdPersona` (`iIdPersona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_encuestas`
--
ALTER TABLE `tbl_encuestas`
  MODIFY `iIdEncuesta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_encuestasactivas`
--
ALTER TABLE `tbl_encuestasactivas`
  MODIFY `iIdEncuestaActiva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_encuestasrealizadas`
--
ALTER TABLE `tbl_encuestasrealizadas`
  MODIFY `iIdEncuestaRealizada` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_perfiles`
--
ALTER TABLE `tbl_perfiles`
  MODIFY `iIdPerfil` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_personas`
--
ALTER TABLE `tbl_personas`
  MODIFY `iIdPersona` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_preguntas`
--
ALTER TABLE `tbl_preguntas`
  MODIFY `iIdPregunta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_respuestas`
--
ALTER TABLE `tbl_respuestas`
  MODIFY `iIdRespuesta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `iIdUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_encuestasactivas`
--
ALTER TABLE `tbl_encuestasactivas`
  ADD CONSTRAINT `iIdEncuesta` FOREIGN KEY (`iIdEncuesta`) REFERENCES `tbl_encuestas` (`iIdEncuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD CONSTRAINT `iIdPersona` FOREIGN KEY (`iIdPersona`) REFERENCES `tbl_personas` (`iIdPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
