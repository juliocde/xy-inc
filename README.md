# Teste Java

Foi criado um projeto utilizando o framework JERSEY para implementação do REST:

  Classes Clients onde foram criados os metodos para testes REST (POST, GET, PUT, DELETE).
  
  Utilizei o Tomcat para testes dos serviços REST.
  
  Utilizei o maven para empacotamento e dependências das bibliotecas (POM.xml).
  

Banco de Dados:

Utilizei Mysql com JDBC simples para persistir os dados trocados entre cliente e servidor.
A classe Connect estão as configurações do banco.

Scripts:

CREATE DATABASE zup;

CREATE TABLE products ( id INT PRIMARY KEY, name VARCHAR(30), description VARCHAR(50), price FLOAT(10.2), category VARCHAR(30));



Para rodar, deve-se importar o projeto com o maven e adicionar a aplicacão no Tomcat.

Cada classe client contem um metodo main para teste de cada serviço REST (POST, GET, PUT, DELETE).



