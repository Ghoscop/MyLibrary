# MyLibrary

Sistema completo de gerenciamento de biblioteca desenvolvido com Spring Boot e Angular 17.

O projeto permite o gerenciamento de categorias, livros, empréstimos e devoluções, além de possuir dashboard administrativo, relatório de atrasos e pipeline CI/CD com GitHub Actions.

---

# Tecnologias Utilizadas

## Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- H2 Database

## Frontend
- Angular 17
- TypeScript
- HTML5
- CSS3
- Standalone Components

## DevOps & Qualidade
- GitHub Actions
- Git Flow
- Conventional Commits
- CI/CD
- Versionamento Semântico

---

# Funcionalidades

## RF01 - Gerenciamento de Categorias
- Cadastro de categorias
- Exclusão protegida
- Interface moderna
- Atualização automática da tela

## RF02 - Gerenciamento de Livros
- Cadastro de livros
- Controle de status
- Busca por título e autor
- Filtros por categoria e status
- Validação de duplicidade
- Exclusão protegida

## RF03 - Sistema de Empréstimos
- Registro de empréstimos
- Registro de devoluções
- Controle automático de disponibilidade
- Validação de campos obrigatórios
- Prazo automático de devolução

## RF04 - Busca e Filtros
- Busca textual
- Filtros por status
- Filtros por categoria
- Atualização dinâmica dos resultados

## RF05 - Dashboard
- Total de livros
- Livros disponíveis
- Livros emprestados
- Empréstimos ativos
- Últimos empréstimos

## RF06 - Relatório de Atrasados
- Empréstimos vencidos
- Destaque visual
- Atualização em tempo real

---

# Interface do Sistema

## Dashboard
- Cards estatísticos
- Layout moderno
- Visual responsivo

## Livros
- Cadastro e gerenciamento visual
- Busca dinâmica
- Mensagens de sucesso e erro

## Empréstimos
- Controle completo de circulação
- Relatório de atrasos
- Validações automáticas

---

# Como Executar o Projeto

## Backend

Entre na pasta do backend:

```bash
cd mylibrary-backend
mvn spring-boot:run
```

## Frontend

Entre na pasta do frontend:

```bash
cd mylibrary-frontend
npm install
ng serve
```

---

# Links Disponiveis

## Backend

```bash
http://localhost:8080
```

## Console H2

```bash
http://localhost:8080/h2-console
```

## Frontend

```bash
http://localhost:4200
```
