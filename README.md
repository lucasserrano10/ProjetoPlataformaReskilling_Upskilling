# 📘 API Upskilling – Plataforma de Educação

Este projeto contém uma API desenvolvida em **Java + Spring Boot**, seguindo boas práticas de arquitetura, documentação, migrations e tratamento de erros.  
O objetivo é disponibilizar endpoints REST para manipulação de **usuários, trilhas e competências**.

---

## ✅ Requisitos Entregues

### ✔ Estrutura do Projeto
O projeto está organizado em camadas:

- **controller** – Endpoints REST  
- **service** – Regras de negócio  
- **repository** – Acesso ao banco de dados  
- **domain/model** – Entidades da aplicação  

Também inclui:

- `application.properties` configurado  
- `README.md` instrutivo  

---

## ⚙️ Pré-requisitos

Antes de rodar o projeto, instale:

- **Java 17+**
- **Maven**
- **MySQL** 

---

## 🏃 Como Executar o Projeto

### 1️⃣ Instalar dependências
```bash
mvn clean install

## Exemplos de Requisição

POST /usuarios

{
  "nome": "Lucas Serrano",
  "email": "lucas@example.com",
  "areaAtuacao": "Tecnologia",
  "nivelCarreira": "Estagiário",
  "dataCadastro": "2025-01-01"
}

POST /trilhas

{
  "nome": "Java Backend",
  "descricao": "Trilha completa focada em desenvolvimento backend",
  "nivel": "Intermediário",
  "cargaHoraria": 40,
  "focoPrincipal": "Java + Spring"
}
