-- Tabela de usuários da plataforma
CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    area_atuacao VARCHAR(100),
    nivel_carreira VARCHAR(50), -- Ex: 'Junior', 'Pleno', 'Senior', 'Em transição'
    data_cadastro DATE NOT NULL
);

-- Tabela de trilhas de aprendizagem
CREATE TABLE trilhas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    descricao TEXT,
    nivel VARCHAR(50) NOT NULL, -- Ex: 'INICIANTE', 'INTERMEDIARIO', 'AVANCADO'
    carga_horaria INT NOT NULL, -- horas
    foco_principal VARCHAR(100) -- Ex: 'IA', 'Dados', 'Soft Skills', 'Green Tech'
);

-- Tabela de competências (skills)
CREATE TABLE competencias (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100), -- Ex: 'Tecnologia', 'Humana', 'Gestão'
    descricao TEXT
);