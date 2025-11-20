\# Sistema de Login - POO com Java Swing + MySQL
(Dupla Mario Junior e Luiz Felipe)


Sistema simples de login, cadastro e recuperação de senha usando:

\- Java Swing

\- MySQL

\- Padrão de camadas (Model, DAO, Conexão)



\## Funcionalidades

\- Cadastro de usuários

\- Login com validação no banco

\- Recuperação de senha

\- Tela principal após login



\## Banco de Dados (MySQL)

```sql

CREATE DATABASE sistema\_login;

USE sistema\_login;



CREATE TABLE usuarios (

&nbsp;   id INT AUTO\_INCREMENT PRIMARY KEY,

&nbsp;   usuario VARCHAR(50) UNIQUE NOT NULL,

&nbsp;   senha VARCHAR(100) NOT NULL

);



INSERT INTO usuarios (usuario, senha) VALUES ('admin', '123');

