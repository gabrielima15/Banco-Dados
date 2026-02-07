CREATE Table Cidade(
    id serial PRIMARY key,
    nome VARCHAR(40) NOT NULL
);

CREATE Table Tecnico(
    id serial PRIMARY KEY,
    nome VARCHAR(80) NOT NULL
);

CREATE Table Campeonato(
    id serial PRIMARY KEY,
    nome VARCHAR(80) NOT NULL
);

CREATE Table Time_futebol(
    id serial PRIMARY KEY,
    nome VARCHAR(80) not NULL,
    id_cidade INTEGER,
    id_tecnico INTEGER UNIQUE,
    Foreign Key (id_tecnico) REFERENCES Tecnico(id),
    Foreign key (id_cidade) REFERENCES Cidade (id)
);

CREATE Table Jogador(
    id serial PRIMARY key,
    nome VARCHAR(20),
    N_camisa INT,
    posicao INT,
    id_time INTEGER,
    Foreign key(id_time) REFERENCES Time_futebol (id)
);

CREATE Table serie(
    id serial PRIMARY key,
    id_time INTEGER,
    id_campeonato INTEGER,
    Foreign Key (id_time) REFERENCES Time_futebol(id),
    Foreign Key (id_campeonato) REFERENCES Campeonato(id)
);

INSERT INTO Cidade(nome) VALUES ('Espanha'),('Alemanha');
INSERT INTO Campeonato(nome) VALUES('champions');
INSERT INTO Tecnico(nome) VALUES ('Hans-Dieter Flick'),('Álvaro Arbeloa'),('Vincent Kompany');

INSERT INTO serie(nome,id_tecnico,id_cidade) VALUES 
('barcelona',1,1),('Real Madri'2,1),('Bayern'3,2);