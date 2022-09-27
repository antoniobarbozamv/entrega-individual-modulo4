/* modelo-logico: */

CREATE TABLE Compra (
    id_compra INTEGER PRIMARY KEY,
    data_compra DATE,
    valor_compra NUMERIC,
    desconto NUMERIC,
    horario VARCHAR (5),
    fk_Cliente_id_cliente INTEGER
);

CREATE TABLE Cliente (
    nome_cliente VARCHAR (40),
    cpf VARCHAR (11),
    email VARCHAR (40),
    contato VARCHAR (30),
    id_cliente INTEGER PRIMARY KEY
);

CREATE TABLE Pacote (
    id_pacote INTEGER PRIMARY KEY,
    nome_pacote VARCHAR (40),
    descricao VARCHAR (400),
    pais VARCHAR (30),
    valor_pacote NUMERIC
);

CREATE TABLE comprado (
    fk_Pacote_id_pacote INTEGER,
    fk_Compra_id_compra INTEGER
);
 
ALTER TABLE Compra ADD CONSTRAINT FK_Compra_2
    FOREIGN KEY (fk_Cliente_id_cliente)
    REFERENCES Cliente (id_cliente)
    ON DELETE CASCADE;
 
ALTER TABLE comprado ADD CONSTRAINT FK_comprado_1
    FOREIGN KEY (fk_Pacote_id_pacote)
    REFERENCES Pacote (id_pacote)
    ON DELETE RESTRICT;
 
ALTER TABLE comprado ADD CONSTRAINT FK_comprado_2
    FOREIGN KEY (fk_Compra_id_compra)
    REFERENCES Compra (id_compra)
    ON DELETE SET NULL;