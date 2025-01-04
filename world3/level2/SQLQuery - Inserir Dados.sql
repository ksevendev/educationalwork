INSERT INTO Usuarios (idUsuario, login, senha)
VALUES 
    (1, 'op1', 'op1'),
    (2, 'op2', 'op2');


INSERT INTO Produtos (idProduto, nome, quantidade, preco_venda)
VALUES
 (1, 'Uva', '100', '5.00'),
 (2, 'Melancia', '500', '2.00'),
 (3, 'Pera', '800', '4.00');


 INSERT INTO Pessoa_Fisica (idPessoaFisica, nome, cpf, endereco, telefone, email)
VALUES (NEXT VALUE FOR sequencia, 'Maria', 123456 , 'Rua JC, Beco, Quitanda', '555599999999', 'maria@mail.com');



 INSERT INTO Pessoa_Juridica (idPessoaJuridica, nome, cnpj, endereco, telefone, email)
VALUES (NEXT VALUE FOR sequencia, 'Pedro', '1212312', 'Rua Do Povo, Predio A L3, Quitanda', '555599999999', 'pedro_cpf@mail.com');



INSERT INTO movimentacao (idMovimento, idUsuario, idPessoa, idProduto, quantidade, tipo, valorUnitario)
VALUES (NEXT VALUE FOR sequencia, 1, 7 ,1 ,20 , 'S', 4.00),
       (NEXT VALUE FOR sequencia, 1, 7 ,3 ,15 , 'S', 2.00),
       (NEXT VALUE FOR sequencia, 2, 7 ,3 ,10 , 'S', 3.00),
       (NEXT VALUE FOR sequencia, 1, 15 ,3 ,15 , 'E', 5.00),
	   (NEXT VALUE FOR sequencia, 1, 15 ,4 ,20, 'E', 4.00);

