# TCC - Minha Rede Social

API para gestão de uma rede social.

## Funcionalidades

- Login: `POST /login`
- Cadastrar usuários: `POST /usuarios`
- Detalhar usuário logado: `GET /usuarios/detalhar`
- Solicitações do usuário logado: `GET /usuarios/solicitacoes`
- Pesquisar usuário por nome ou e-mail: `GET /usuarios/search?texto={texto}`
- Listar amigos do usuário logado: `GET /usuarios/amigos`
- Perfil de um usuário: `GET /usuarios/{id}`
- Editar usuário logado: `PUT /usuarios`
- Logout: `POST /logout`

## Dependências

- Java 11
- PostgreSQL 14
- Criar objetos de banco: `data/schema.sql`
- Carga inicial: `data/inserts.sql`
- Arquivo do insomnia: `data/URLs API`
