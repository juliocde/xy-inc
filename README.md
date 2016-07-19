# Teste Java

Foram criados dois projetos utilizando o framework JERSEY para implementação do REST:

  1 - Projeto Client onde foram criados classes para testes REST (POST, GET, PUT, DELETE).
  
  2 - Projeto Server onde ficara hospedado no servidor (usei Tomcat para testes) os serviços REST.
  
  Utilizei o maven para empacotamento e dependências das bibliotecas.
  

#Banco de Dados

Utilizei Mysql com JDBC simples para persistir os dados trocados entre cliente e servidor.
A classe Connect estão as configurações do banco.

Scripts:

CREATE DATABASE zup;

CREATE TABLE products ( id INT PRIMARY KEY, name VARCHAR(30), description VARCHAR(50), price FLOAT(10.2), category VARCHAR(30));







