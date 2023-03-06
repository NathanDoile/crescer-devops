INSERT INTO usuario(nome_completo, email, apelido, data_nascimento, senha, imagem_perfil, serie_preferida, ativo) VALUES
	('Nathan de Souza Doile', 'nathan.doile@cwi.com.br', 'ADMIN', '2004-07-29', 
	 '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 
	 'https://static.ricmais.com.br/uploads/2016/08/nxgwca.jpeg', 'Supernatural', true);
	 
INSERT INTO usuario(nome_completo, email, data_nascimento, senha, serie_preferida, ativo) VALUES
	('Usuario da Silva', 'usuario.silva@cwi.com.br', '1997-03-25', 
	 '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 'The Big Bang Theory', true);

INSERT INTO permissao(nome, usuario_id) VALUES	
	('ADMIN', 1), ('USUARIO', 1), ('USUARIO', 2);
	
INSERT INTO amigo(usuario_id, amigo_id, data_de_amizade, ativo) VALUES
	(1, 2, NOW(), true), (2, 1, NOW(), true);
	
INSERT INTO solicitacao_amizade(usuario_solicitado_id, usuario_solicitante_id, data_pedido, status) VALUES
	(2, 1, '2023-02-23', 'REJEITADA'), (1, 2, NOW(), 'ACEITA');
	
INSERT INTO postagem(id_usuario, data_postagem, privacidade, mensagem, ativo) VALUES
	(2, NOW(), 'PUBLICA', 'Uma mensagem aleatória por uma pessoa aleatória.', true);
	
INSERT INTO curtida(id_postagem, id_usuario_curtiu, ativo) VALUES
	(1, 1, true);
	
INSERT INTO comentario(id_postagem, id_usuario_comentou, ativo, mensagem) VALUES
	(1, 1, true, 'Um comentário aleatório para uma postagem aleatória de uma pessoa aleatória.');