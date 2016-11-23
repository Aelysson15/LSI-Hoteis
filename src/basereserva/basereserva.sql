-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-02-2016 a las 22:41:33
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de dados: `basereserva`
--

-- --------------------------------------------------------

--
--  `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `idpessoa` int(11) NOT NULL,
  `codigo_cliente` varchar(10) NOT NULL,
  PRIMARY KEY (`idpessoa`),
  UNIQUE KEY `codigo_cliente_UNIQUE` (`codigo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
--  `cliente`
--

INSERT INTO `cliente` (`idpessoa`, `codigo_cliente`) VALUES
(2, '1');

-- --------------------------------------------------------

--
-- `consumo`
--

CREATE TABLE IF NOT EXISTS `despesa` (
  `iddespesa` int(11) NOT NULL AUTO_INCREMENT,
  `idreserva` int(11) NOT NULL,
  `idservico` int(11) NOT NULL,
  `quantidade` decimal(7,2) NOT NULL,
  `preco_venda` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`iddespesa`),
  KEY `fk_despesa_servico_idx` (`idservico`),
  KEY `fk_despesa_reserva_idx` (`idreserva`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- gravando dados `consumo`
--

INSERT INTO `despesa` (`iddespesa`, `idreserva`, `idservico`, `quantidade`, `preco_venda`, `estado`) VALUES
(3, 2, 2, '3.00', '1.00', 'Aceito'),
(4, 2, 1, '2.00', '3.00', 'Aceito');

-- --------------------------------------------------------

--
--  `habitacion`
--

CREATE TABLE IF NOT EXISTS `quarto` (
  `idquarto` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(4) NOT NULL,
  `andar` varchar(2) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `caracteristicas` varchar(512) DEFAULT NULL,
  `preco_diario` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `tipo_quarto` varchar(20) NOT NULL,
  PRIMARY KEY (`idquarto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
--  `quarto`
--

INSERT INTO `quarto` (`idquarto`, `numero`, `andar`, `descricao`, `caracteristicas`, `preco_diario`, `estado`, `tipo_quarto`) VALUES
(1, '101', '1', 'Casal', 'Duas camas, banho, bar.', '50.00', 'Disponivel', 'Individual');

-- --------------------------------------------------------

--
--  `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
  `idpagamento` int(11) NOT NULL AUTO_INCREMENT,
  `idreserva` int(11) NOT NULL,
  `tipo_comprovante` varchar(20) NOT NULL,
  `num_comprovante` varchar(20) NOT NULL,
  `total_pagamento` decimal(7,2) NOT NULL,
  `data_emissao` date NOT NULL,
  `data_pagamento` date NOT NULL,
  PRIMARY KEY (`idpagamento`),
  KEY `fk_pagamento_reserva_idx` (`idreserva`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `pagamento`
--

INSERT INTO `pagamento` (`idpagamento`, `idreserva`, `tipo_comprovante`, `num_comprovante`, `total_pagamento`, `data_emissao`, `data_pagamento`) VALUES
(1, 1, 'Factura', '0001-00001', '100.00', '2016-02-16', '2016-02-16'),
(2, 2, 'Factura', '0001-0002', '109.00', '2016-02-16', '2016-02-16');

-- --------------------------------------------------------

--
--  `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `idpessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `tipo_documento` varchar(15) NOT NULL,
  `num_documento` varchar(8) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `telefone` varchar(8) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idpessoa`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefone_UNIQUE` (`telefone`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- gravando dados `pessoa`
--

INSERT INTO `pessoa` (`idpessoa`, `nome`, `tipo_documento`, `num_documento`, `endereco`, `telefone`, `email`) VALUES 
(1, 'Jose', 'RG', '456123', 'CG', '8398855', 'teste@teste.com'),
(2, 'Joao', 'RG', '485968', 'CG', '9874569', 'user@user.com');


--
--  `servico`
--

CREATE TABLE IF NOT EXISTS `servico` (
  `idservico` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `medida` varchar(20) NOT NULL,
  `preco_venda` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idservico`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- gravando dados `servico`
--

INSERT INTO `servico` (`idservico`, `nome`, `descricao`, `medida`, `preco_venda`) VALUES
(1, 'Agua', 'Mineral.', 'UND', '3.00'),
(2, 'Galeto', 'Galetos', 'UND', '1.00');

-- --------------------------------------------------------

--
--  `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `idquarto` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idfuncionario` int(11) NOT NULL,
  `tipo_reserva` varchar(20) NOT NULL,
  `data_reserva` date NOT NULL,
  `data_entrada` date NOT NULL,
  `data_saida` date NOT NULL,
  `custo_alojamento` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_reserva_quarto_idx` (`idquarto`),
  KEY `fk_reserva_cliente_idx` (`idcliente`),
  KEY `fk_reserva_funcionario_idx` (`idfuncionario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
--  `reserva`
--

INSERT INTO `reserva` (`idreserva`, `idquarto`, `idcliente`, `idfuncionario`, `tipo_reserva`, `data_reserva`, `data_entrada`, `data_saida`, `custo_alojamento`, `estado`) VALUES
(1, 1, 2, 1, 'Alquiler', '2016-02-15', '2016-02-15', '2016-02-16', '100.00', 'Pagada'),
(2, 1, 2, 1, 'Reserva', '2016-02-15', '2016-02-15', '2016-02-16', '100.00', 'Pagada');

-- --------------------------------------------------------

--
--  `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `idpessoa` int(11) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  `acesso` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`idpessoa`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- gravando dados `funcionario`
--

INSERT INTO `funcionario` (`idpessoa`, `salario`, `acesso`, `login`, `senha`, `estado`) VALUES 
(1, 900.00, 'Admin', 'admin', '123', 'pb');

--
-- Restricoes nas tabelas
--

--
-- Filtros  `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_pessoa_cliente` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para  `despesa`
--
ALTER TABLE `despesa`
  ADD CONSTRAINT `fk_despesa_servico` FOREIGN KEY (`idservico`) REFERENCES `servico` (`idservico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_despesa_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para  `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `fk_pagamento_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para  `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_reserva_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reserva_quarto` FOREIGN KEY (`idquarto`) REFERENCES `quarto` (`idquarto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reserva_funcionario` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para  `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_pessoa_funcionario` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
