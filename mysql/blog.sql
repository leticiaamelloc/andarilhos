
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE latin1_bin NOT NULL,
  `senha` varchar(255) COLLATE latin1_bin NOT NULL,
  `nome` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `cpf` varchar(14) COLLATE latin1_bin NOT NULL,
  `papel` tinyint(1) NOT NULL,
  `cadastro_aprovado` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `artigo`;
CREATE TABLE `artigo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_usuario` int(10) unsigned NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `titulo` varchar(255) COLLATE latin1_bin NOT NULL,
  `conteudo` text COLLATE latin1_bin DEFAULT NULL,
  `liberar` char(1) COLLATE latin1_bin NOT NULL,
  `aprovado` char(1) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_usuario_idx` (`id_usuario`),
  KEY `fk_id_categoria_idx` (`id_categoria`),
  CONSTRAINT `fk_id_categoria_idx` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_usuario_idx` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `comentario`;
CREATE TABLE `comentario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `comentario` text COLLATE latin1_bin NOT NULL,
  `id_artigo` int(10) unsigned NOT NULL,
  `id_usuario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_artigo_idx` (`id_artigo`),
  KEY `fk_id_usuario_idx_1` (`id_usuario`),
  CONSTRAINT `fk_id_artigo_idx` FOREIGN KEY (`id_artigo`) REFERENCES `artigo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_usuario_idx_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (email, senha, nome, cpf, papel) VALUES ('teste@teste.com', '111', 'Teste', '249.252.810-38', 1)



