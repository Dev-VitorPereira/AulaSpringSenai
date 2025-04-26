# Sistema de Cadastro de Alunos

Este projeto consiste em um sistema de cadastro de alunos, onde o usuário pode visualizar os alunos cadastrados e cadastrar novos alunos. A aplicação foi construída utilizando **Spring Boot** no back-end e **JavaScript** no front-end para consumir a API.

## Tecnologias Utilizadas

- **Back-End**: 
  - Java
  - Spring Boot
  - H2 Database (para persistência em memória)

- **Front-End**:
  - HTML
  - CSS
  - JavaScript (Fetch API)

## Funcionalidades

1. **Visualizar Alunos**:
   - Os alunos cadastrados são exibidos em uma tabela.
   - A lista é recuperada via uma requisição `GET` à API, usando `fetch` no JavaScript.

2. **Cadastrar Aluno**:
   - É possível cadastrar um novo aluno através de um formulário.
   - Os dados são enviados ao back-end por meio de uma requisição `POST` à API, usando `fetch`.

## Captura de Tela

![image](https://github.com/user-attachments/assets/e77d1973-2def-425d-bbd2-0d9059e29fa9)


