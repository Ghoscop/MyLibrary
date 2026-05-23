## Requisitos Funcionais

### RF01 - Gerenciar Categorias
CRUD de categorias com nome e descrição. O sistema bloqueia a exclusão de categorias com livros vinculados.

### RF02 - Gerenciar Livros
CRUD de livros vinculados a categorias, com status inicial `DISPONIVEL`.

### RF03 - Sistema de Empréstimos
Permite emprestar livros disponíveis e registrar devoluções, alterando automaticamente o status do livro.

### RF04 - Busca e Filtros
Permite buscar livros por título ou autor, além de filtrar por categoria e status.

### RF05 - Dashboard
Exibe estatísticas do acervo, como total de livros, disponíveis, emprestados e empréstimos ativos.

### RF06 - Relatório de Atrasados
Lista empréstimos com data prevista vencida e ainda não devolvidos.