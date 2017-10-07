-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 15-Abr-2016 às 05:37
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bdbio`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbusuario`
--

CREATE TABLE IF NOT EXISTS `tbusuario` (
  `codUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(100) NOT NULL,
  `emailUsuario` varchar(100) NOT NULL,
  `senhaUsuario` varchar(100) NOT NULL,
  `pontoUsuario` int(11) NOT NULL,
  `nivel1` int(11) NOT NULL,
  `nivel2` int(11) NOT NULL,
  `nivel3` int(11) NOT NULL,
  `nivel4` int(11) NOT NULL,
  `nivel5` int(11) NOT NULL,
  PRIMARY KEY (`codUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Extraindo dados da tabela `tbusuario`
--

INSERT INTO `tbusuario` (`codUsuario`, `nomeUsuario`, `emailUsuario`, `senhaUsuario`, `pontoUsuario`, `nivel1`, `nivel2`, `nivel3`, `nivel4`, `nivel5`) VALUES
(7, 'igor500', 'seila@', '40F62D6632389BEAD18557052B2CE73D7B1B49523C4B2FFAC0CFF106E5C7F673', 0, 0, 0, 0, 0, 0),
(9, 'igor300', 'igor@gmail.com', 'AAE7252D9AE30EED80E5EDFE630CF3A5028AE2A93ADF164C94CE8399210DEDD3', 515480, 1, 1, 1, 1, 1),
(11, 'welvister', 'sjahvcsah@chhvccha.net', '24E86250BDA0E300AA230E4B8F3D3610F2AAEC54C23347B8EC97462C74DE9CC6', 32155, 0, 0, 0, 0, 0),
(15, 'kaka12', 'kaka@gmail.com', '9ED202C4C3DF24F0483523160638CE6F8412A242C4D58813B417522EEC6B1A7D', 0, 0, 0, 0, 0, 0),
(16, 'fabbie', 'fabiolars2009@hotmail.com', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', 29420, 1, 1, 0, 0, 0),
(17, 'Ester.C', 'ester-cel@hotmail.com', '8D7822E4C7112E41C7B67301246218D2C5DE23471618D6F04E674A38F7FF9765', 0, 0, 0, 0, 0, 0),
(18, 'aline10', 'aline@gmail.com', '25DAFD62F6CAD9313F8CA32A9DECD53B9C75EB97DA97EC6E4D90994413D3164C', 9440, 1, 0, 0, 0, 0),
(19, 'Karol', 'ka_alm@hotmail.com', 'EF797C8118F02DFB649607DD5D3F8C7623048C9C063D532CC95C5ED7A898A64F', 0, 0, 0, 0, 0, 0),
(20, 'agnes', 'agnes.bittencourt.sanches@gmail.com', '00C70F7827FADEAEB5B3A3FE735CBF962D9A517383531A68B7876C478D8F94BC', -130, 1, 0, 0, 0, 0),
(21, 'caue10', 'caue@gmai.com', 'AAE7252D9AE30EED80E5EDFE630CF3A5028AE2A93ADF164C94CE8399210DEDD3', 22470, 1, 1, 0, 0, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
