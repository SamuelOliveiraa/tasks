# 🚀 Task Manager API

Esta é a minha primeira aplicação desenvolvida com **Java** e **Spring Boot**. O projeto consiste em uma API REST para gerenciamento de tarefas, permitindo criar, listar, atualizar e deletar registros.

O objetivo deste projeto foi colocar em prática conceitos fundamentais de desenvolvimento Back-end, persistência de dados e arquitetura REST com **Java** e **Spring Boot**

---

## 🛠️ Tecnologias Utilizadas

*   **Java 21** ou superior
*   **Spring Boot 3**
*   **Spring Data JPA** (Persistência de dados)
*   **PostgreSQL** (Banco de dados relacional)
*   **Neon.tech** (Hospedagem de banco de dados Serverless)
*   **Maven** (Gerenciador de dependências)

---

## 🏗️ Funcionalidades e Aprendizados

Neste projeto, implementei as seguintes operações:

*   **Listagem (GET):** Retorna todas as tarefas ordenadas por título.
*   **Criação (POST):** Salva uma nova tarefa com validação de campos obrigatórios.
*   **Atualização Parcial (PUT/PATCH):** Atualiza campos específicos de uma tarefa existente (Título e Descrição) via ID.
*   **Exclusão (DELETE):** Remove uma tarefa do banco de dados através do seu UUID.

### Principais conceitos aplicados:
- **Injeção de Dependências:** Organização entre Controller, Service e Repository.
- **Mapeamento Objeto-Relacional (ORM):** Uso do Hibernate para gerenciar tabelas no PostgreSQL.
- **Tratamento de Exceções:** Uso de `ResponseStatusException` para retornar erros HTTP adequados (404, 400).
- **UUID:** Uso de identificadores únicos universais em vez de IDs sequenciais simples.

---

## ⚙️ Configuração do Banco de Dados

O projeto está configurado para conectar ao **PostgreSQL** via **Neon**. Para rodar localmente, as propriedades no `application.properties` devem seguir este modelo:

```properties
spring.datasource.url=jdbc:postgresql://seu-host-neon.tech/neondb?sslmode=require
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update