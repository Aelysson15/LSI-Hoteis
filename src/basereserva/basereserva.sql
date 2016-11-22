-- Database: basereserva

-- DROP DATABASE basereserva;

CREATE DATABASE basereserva
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
    CREATE TABLE IF NOT EXISTS cliente (
      idpessoa int NOT NULL,
      codigo_cliente varchar(10) NOT NULL,
      PRIMARY KEY (idpessoa),
      CONSTRAINT codigo_cliente_UNIQUE UNIQUE(codigo_cliente)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO cliente (idpessoa, codigo_cliente) VALUES
(2, '1');

CREATE TABLE IF NOT EXISTS despesa (
  iddespesa int(11) NOT NULL AUTO_INCREMENT,
  idreserva int(11) NOT NULL,
  idservico int(11) NOT NULL,
  quantidade decimal(7,2) NOT NULL,
  preco_venda decimal(7,2) NOT NULL,
  estado varchar(15) NOT NULL,
  PRIMARY KEY (iddespesa),
  KEY fk_consumo_servico_idx (idservico),
  KEY fk_consumo_reserva_idx (idreserva)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

INSERT INTO despesa (iddespesa, idreserva, idservico, quantidade, preco_venda, estado) VALUES
(3, 2, 2, '3.00', '1.00', 'Aceito'),
(4, 2, 1, '2.00', '3.00', 'Aceito');

CREATE TABLE IF NOT EXISTS quarto (
  idquarto int(11) NOT NULL,
  numero varchar(4) NOT NULL,
  andar varchar(2) NOT NULL,
  descricao varchar(255) DEFAULT NULL,
  caracteristicas varchar(512) DEFAULT NULL,
  preco_diario decimal(7,2) NOT NULL,
  estado varchar(15) NOT NULL,
  tipo_quarto varchar(20) NOT NULL,
  PRIMARY KEY (idquarto)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

INSERT INTO quarto (idquarto, numero, andar, descricao, caracteristicas, preco_diario, estado, tipo_quarto) VALUES
(1, '101', '1', 'Quarto Casal', 'Duas camas, banho propio, bar.', '50.00', 'Disponivel', 'Individual');

CREATE TABLE IF NOT EXISTS pagamento (
  idpagamento int(11) NOT NULL,
  idreserva int(11) NOT NULL,
  tipo_comprovante varchar(20) NOT NULL,
  num_comprovante varchar(20) NOT NULL,
  total_pagamento decimal(7,2) NOT NULL,
  PRIMARY KEY (idpagamento),
  KEY fk_pago_reserva_idx (idreserva)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

INSERT INTO pagamento (idpagamento, idreserva, tipo_comprovante, num_comprovante, total_pago) VALUES
(1, 1, 'Factura', '0001-00001', '100.00'),
(2, 2, 'Factura', '0001-0002', '109.00');

CREATE TABLE IF NOT EXISTS pessoa (
  idpessoa int NOT NULL,
  nome varchar(20) NOT NULL,
  tipo_documento varchar(15) NOT NULL,
  num_documento varchar(8) NOT NULL,
  endereco varchar(100) DEFAULT NULL,
  telefone varchar(8) DEFAULT NULL,
  email varchar(25) DEFAULT NULL,
  CONSTRAINT email_UNIQUE UNIQUE(email),
  CONSTRAINT telefone_UNIQUE UNIQUE (telefone),
  PRIMARY KEY (idpessoa)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

INSERT INTO pessoa (idpessoa, nome, tipo_documento, num_documento, endereco, telefone, email) VALUES
(1, 'Phulano', 'RG', '123456', 'CG', '8388334455', 'teste@teste.com');

CREATE TABLE IF NOT EXISTS servico (
  idservico int(11) NOT NULL,
  nome varchar(45) NOT NULL,
  descricao varchar(255) DEFAULT NULL,
  medida varchar(20) NOT NULL,
  preco_venda decimal(7,2) NOT NULL,
  PRIMARY KEY (idservico)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

INSERT INTO servico (idservico, nome, descricao, medida, preco_venda) VALUES
(1, 'Agua Mineral', 'Agua de mesa.', 'UND', '3.00'),
(2, 'Galeto assado', 'Galetos', 'UND', '1.00');

CREATE TABLE IF NOT EXISTS reserva (
  idreserva int(11) NOT NULL,
  idquarto int(11) NOT NULL,
  idcliente int(11) NOT NULL,
  idfuncionario int(11) NOT NULL,
  tipo_reserva varchar(20) NOT NULL,
  data_reserva date NOT NULL,
  data_entrada date NOT NULL,
  data_saida date NOT NULL,
  custo_alojamiento decimal(7,2) NOT NULL,
  estado varchar(15) NOT NULL,
  PRIMARY KEY (idreserva),
  KEY fk_reserva_habitacion_idx (idquarto),
  KEY fk_reserva_cliente_idx (idcliente),
  KEY fk_reserva_trabajador_idx (idfuncionario)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;


INSERT INTO reserva (idreserva, idquarto, idcliente, idfuncionario, tipo_reserva, data_reserva, data_entrada, data_saida, custo_alojamiento, estado) VALUES
(1, 1, 2, 1, 'Aluguel', '2016-02-16', '2016-02-16', '2016-02-16', '100.00', 'Paga'),
(2, 1, 2, 1, 'Reserva', '2016-07-16', '2016-07-16', '2016-07-16', '100.00', 'Paga');

CREATE TABLE IF NOT EXISTS funcionario (
  idpessoa int(11) NOT NULL,
  salario decimal(7,2) NOT NULL,
  acesso varchar(15) NOT NULL,
  login varchar(15) NOT NULL,
  senha varchar(20) NOT NULL,
  estado varchar(1) NOT NULL,
  PRIMARY KEY (idpessoa),
  CONSTRAINT login_UNIQUE UNIQUE(login)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO funcionario (idpessoa, salario, acesso, login, senha, estado) VALUES
(1, '5000.00', 'Administrador', 'admin', 'admin', 'A');


ALTER TABLE cliente
  ADD CONSTRAINT fk_pessoa_cliente FOREIGN KEY (idpessoa) REFERENCES pessoa (idpessoa) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE despesa
  ADD CONSTRAINT fk_consumo_servico FOREIGN KEY (idservico) REFERENCES servico (idservico) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_consumo_reserva FOREIGN KEY (idreserva) REFERENCES reserva (idreserva) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE pagamento
  ADD CONSTRAINT fk_pago_reserva FOREIGN KEY (idreserva) REFERENCES reserva (idreserva) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE reserva
  ADD CONSTRAINT fk_reserva_cliente FOREIGN KEY (idcliente) REFERENCES cliente (idpessoa) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_reserva_quarto FOREIGN KEY (idquarto) REFERENCES quarto (idquarto) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_reserva_funcionario FOREIGN KEY (idfuncionario) REFERENCES funcionario (idpessoa) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE funcionario
  ADD CONSTRAINT fk_pessoa_funcionario FOREIGN KEY (idpessoa) REFERENCES pessoa (idpessoa) ON DELETE NO ACTION ON UPDATE NO ACTION;
