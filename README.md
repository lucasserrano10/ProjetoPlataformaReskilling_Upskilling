📘 API Upskilling – README
Este projeto contém uma API desenvolvida em Java + Spring Boot, seguindo as boas práticas de desenvolvimento, documentação e tratamento de erros.
O objetivo é disponibilizar endpoints REST para manipulação de usuários, trilhas e competências.
✅ Requisitos Entregues
✔ Estrutura do Projeto
O projeto contém:
Código-fonte organizado por camadas (controller, service, repository, domain).
Arquivo application.properties configurado.
Arquivo README.md com instruções.
⚙️ Pré-requisitos
Antes de rodar o projeto, você precisa ter instalado:
Java 17+
Maven
MySQL (ou H2, se configurado)
🏃 Como executar o projeto
Instale as dependências:
mvn clean install
Configure o banco de dados no arquivo:
src/main/resources/application.properties
Execute o projeto:
mvn spring-boot:run
🗄 Banco de Dados
O banco possui as seguintes tabelas:
usuarios
trilhas
competencias
📌 Exemplos de Requisição (Postman)
➤ Criar Usuário
POST /usuarios
{
  "nome": "Lucas Serrano",
  "email": "lucas@example.com",
  "areaAtuacao": "Tecnologia",
  "nivelCarreira": "Estagiário",
  "dataCadastro": "2025-01-01"
}
➤ Criar Trilha
POST /trilhas
{
  "nome": "Java Backend",
  "descricao": "Trilha completa focada em desenvolvimento backend",
  "nivel": "Intermediário",
  "cargaHoraria": 40,
  "focoPrincipal": "Java + Spring"
}
⚠️ Tratamento de Erros
O sistema captura exceções e retorna mensagens claras para o cliente:
400 – Bad Request → erro de validação
404 – Not Found → recurso não encontrado
422 – Unprocessable Entity → regras de negócio não atendidas
Exemplo de erro de validação:
{
  "erro": "Campo 'email' é obrigatório"
}
🪵 Seeds com Flyway
Arquivo exemplo V2__insert_seeds.sql:
INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro) VALUES
('Maria Silva', 'maria@example.com', 'TI', 'Júnior', '2024-10-10'),
('João Pedro', 'joao@example.com', 'Marketing', 'Pleno', '2024-10-11');

INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal) VALUES
('Frontend React', 'Trilha focada na criação de interfaces', 'Iniciante', 30, 'React'),
('Dados Python', 'Trilha de análise de dados', 'Intermediário', 45, 'Python');
📬 Teste via Postman
Use as URLs:
http://localhost:8080/usuarios
http://localhost:8080/trilhas
http://localhost:8080/competencias
Envie payloads JSON conforme mostrado acima.
Verifique os status HTTP para cada resposta.
