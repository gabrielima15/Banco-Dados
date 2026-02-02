CREATE Table Time_futebol(
    id serial PRIMARY KEY,
    nome VARCHAR(80) not NULL,
    cidade VARCHAR(80) NOT NULL,
    id_tecnico INTEGER,
    Foreign Key (id_tecnico) REFERENCES Tecnico(id)
);

CREATE Table Tecnico(
    id serial PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    id_time INTEGER,
    Foreign Key (id_time) REFERENCES Time_futebol(id)
);

CREATE Table Campeonato(
    id serial PRIMARY KEY,
    nome VARCHAR(80) NOT NULL
);

CREATE Table serie(
    id serial PRIMARY key,
    nome VARCHAR(80) NOT NULL,
    id_time INTEGER,
    id_campeonato INTEGER,
    Foreign Key (id_time) REFERENCES Time_futebol(id),
    Foreign Key (id_campeonato) REFERENCES Campeonato(id)
);

INSERT INTO Time_futebol(nome,cidade) VALUES 
('barcelona','Espanha'),('Real Madri','Espanha'),('Bayern','Alemanha');

INSERT INTO Campeonato(nome) VALUES('champions')('champions')('champions');
INSERT INTO Tecnico(nome) VALUES ('Hans-Dieter Flick'),('Álvaro Arbeloa'),('Vincent Kompany');