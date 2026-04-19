# Sistema de Gerenciamento de Alunos (Java + MySQL)

## 📌 Descrição do Projeto

Este projeto consiste em um **sistema simples de gerenciamento de alunos**, desenvolvido em **Java** com integração a um banco de dados **MySQL** utilizando **JDBC (Java Database Connectivity)**.

A aplicação funciona via **terminal (console)** e permite realizar operações básicas de gerenciamento de dados (CRUD) em uma tabela de alunos armazenada no banco de dados.

As funcionalidades incluem:

- Inserir novos alunos
- Listar alunos cadastrados
- Atualizar dados de um aluno
- Excluir um aluno

O objetivo do projeto é demonstrar **como conectar uma aplicação Java a um banco de dados SQL**, além de implementar operações básicas de manipulação de dados.

---

# 🛠 Tecnologias Utilizadas

- **Java**
- **MySQL**
- **JDBC (Java Database Connectivity)**
- **SQL**

---

# 🗄 Estrutura do Banco de Dados

O banco de dados utilizado no projeto se chama **escola** e possui uma tabela chamada **alunos**.

## Criação do banco de dados

```sql
CREATE DATABASE escola;
USE escola;

CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    curso VARCHAR(100),
    idade INT
);
```

A tabela possui os seguintes campos:

| Campo | Tipo | Descrição |
|------|------|-----------|
| id | INT | Identificador único do aluno |
| nome | VARCHAR(100) | Nome do aluno |
| curso | VARCHAR(100) | Curso do aluno |
| idade | INT | Idade do aluno |

---

# 📂 Estrutura do Projeto

O projeto é composto por três classes principais:

```
proejtopoo4bim
│
├── Aluno.java
├── AlunoDAO.java
└── ProejtoPOO4bim.java
```

## 1️⃣ Classe `Aluno`

Representa a **entidade aluno** dentro do sistema.

A classe possui os seguintes atributos:

- `id`
- `nome`
- `curso`
- `idade`

Além disso, contém:

- Construtor
- Getters e Setters
- Método `toString()` para exibição dos dados do aluno.

---

## 2️⃣ Classe `AlunoDAO`

A classe **DAO (Data Access Object)** é responsável por toda comunicação com o banco de dados.

Ela utiliza **JDBC** para realizar operações SQL.

### Conexão com o banco

A conexão é realizada utilizando:

```java
String url = "jdbc:mysql://localhost:3306/escola";
String user = "root";
String password = "";
```

---

### Métodos implementados

#### Inserir aluno

```java
inserirAluno(Aluno aluno)
```

Executa um comando **INSERT** no banco de dados para cadastrar um novo aluno.

---

#### Listar alunos

```java
listarAlunos()
```

Executa um **SELECT** e retorna uma lista com todos os alunos cadastrados.

---

#### Atualizar aluno

```java
atualizarAluno(Aluno aluno)
```

Atualiza os dados de um aluno existente utilizando o **ID** como referência.

---

#### Excluir aluno

```java
excluirAluno(int id)
```

Remove um aluno da tabela com base no **ID**.

---

#### Fechar conexão

```java
fecharConexao()
```

Fecha a conexão com o banco de dados ao final da execução do programa.

---

# 💻 Funcionamento do Programa

A execução do sistema ocorre pela classe:

```
ProejtoPOO4bim.java
```

Ela apresenta um **menu interativo no terminal** permitindo que o usuário escolha qual operação deseja realizar.

### Menu do sistema

```
1 - Inserir aluno
2 - Listar alunos
3 - Atualizar aluno
4 - Excluir aluno
0 - Sair
```

O usuário fornece as informações necessárias através do teclado, e o sistema executa a operação correspondente no banco de dados.

---

# 🔄 Operações CRUD Implementadas

O sistema implementa as quatro operações básicas de manipulação de dados:

| Operação | Descrição |
|--------|--------|
| Create | Inserir novos alunos |
| Read | Listar alunos cadastrados |
| Update | Atualizar dados de alunos |
| Delete | Excluir alunos |

---

# ▶ Como Executar o Projeto

### 1️⃣ Criar o banco de dados

Execute o script SQL fornecido para criar o banco e a tabela.

### 2️⃣ Configurar o MySQL

Certifique-se de que o MySQL esteja rodando e que os dados de conexão estejam corretos:

```
url = jdbc:mysql://localhost:3306/escola
user = root
password = ""
```

### 3️⃣ Adicionar o driver JDBC

É necessário adicionar o **MySQL Connector/J** ao projeto.

Download:

https://dev.mysql.com/downloads/connector/j/

### 4️⃣ Executar o projeto

Compile e execute a classe:

```
ProejtoPOO4bim.java
```

O menu será exibido no terminal.

---

# 📚 Objetivo Educacional

Este projeto foi desenvolvido com fins educacionais para demonstrar:

- Conexão entre **Java e banco de dados**
- Utilização de **JDBC**
- Implementação de **DAO (Data Access Object)**
- Aplicação das operações **CRUD**
- Estruturação básica de um projeto orientado a objetos

---

# 👨‍💻 Autor

Projeto desenvolvido para estudo de **Programação Orientada a Objetos e integração com banco de dados** utilizando Java e MySQL.
