# MyLibrary

Sistema completo de gerenciamento de biblioteca desenvolvido com Spring Boot e Angular.

## Tecnologias

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

### Frontend
- Angular 17
- TypeScript
- CSS

### DevOps
- GitHub Actions
- Git Flow
- Conventional Commits

---

## Funcionalidades

### RF01 - Gerenciar Categorias
- Cadastro de categorias
- Exclusão protegida
- Interface moderna

### RF02 - Gerenciar Livros
- Cadastro de livros
- Controle de status
- Busca e filtros
- Validação de duplicidade

### RF03 - Sistema de Empréstimos
- Registrar empréstimos
- Registrar devoluções
- Controle automático de disponibilidade

### RF04 - Busca e Filtros
- Busca por título
- Busca por autor
- Filtro por status
- Filtro por categoria

### RF05 - Dashboard
- Estatísticas do sistema
- Livros disponíveis
- Livros emprestados
- Empréstimos ativos
- Últimos empréstimos

### RF06 - Relatório de Atrasados
- Empréstimos vencidos
- Destaque visual

---

## Como executar

### Backend

```bash
cd mylibrary-backend
mvn spring-boot:run