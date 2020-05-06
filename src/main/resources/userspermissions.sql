insert into tb_permission (codigo, nome) values
	(1, 'ROLE_PAGINA_CLIENTES')
	, (2, 'ROLE_PAGINA_TASKS')
;

insert into tb_user (codigo, nome, login, senha, ativo) values
	(1, 'Felipe', 'felipe', '$2a$10$9nZoehqLRq8Kw5wuhXm8WeZwl2p2w1gD5//vEcHKqnz2ac/wFJV7m', true)
	, (2, 'Rodrigo', 'rodrigo', '$2a$10$7.DNDWLFQZX2NhFy/f2NGecxMoN/sPwtfyxYDrTmFuU9fW068HyQS', true)
;

insert into tb_user_permission (codigo_tb_user, codigo_tb_permission) values
	(1, 1)
	, (1, 2)
	, (2, 2)
;

insert into tb_group (codigo, nome) values
	(1, 'DIRETOR')
	, (2, 'GERENTE')
;

insert into tb_user_group (codigo_tb_user, codigo_tb_group) values
	(1, 2)
	, (2, 1)
;

insert into tb_group_permission (codigo_tb_group, codigo_tb_permission) values
	(1, 2)
	, (2, 1)
	, (2, 2)
;