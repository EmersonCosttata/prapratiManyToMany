
# API REST para Gerenciamento de Alunos e Cursos

Este projeto trata de uma **API REST** para gerenciar alunos e cursos, com funcionalidades para adicionar alunos, cursos, matricular alunos em cursos, listar alunos e cursos, e testar a API.

## Requisitos

- **Java 17**: Certifique-se de que o **Java 17** esteja instalado em seu ambiente.
- **Maven**: Este projeto utiliza **Maven** para gerenciar as dependências.
- **MySQL**: Configure o **MySQL** no arquivo `application.properties`, incluindo o nome do banco, usuário e senha. Não se esqueça de criar o banco de dados antes de rodar o projeto.

## Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties`, configure a conexão com o banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Certifique-se de criar o banco de dados no MySQL com o nome especificado.

---

## Endpoints e Exemplos de Requisições

### 1. **Adicionar Aluno**

**Endpoint:** `POST /api/alunos`

**Exemplo de Requisição (JSON):**
```json
{
  "nome": "João Silva",
  "email": "joao.silva@example.com"
}
```

**Resposta Esperada:** Retorna o aluno criado com o ID gerado.

---

### 2. **Adicionar Curso**

**Endpoint:** `POST /api/cursos`

**Exemplo de Requisição (JSON):**
```json
{
  "nome": "Matemática"
}
```

**Resposta Esperada:** Retorna o curso criado com o ID gerado.

---

### 3. **Matricular Aluno em Curso**

**Endpoint:** `POST /api/alunos/{id}/cursos/{cursoId}`

**Exemplo de Requisição:**
```bash
POST /api/alunos/1/cursos/1
```

**Resposta Esperada:** Retorna o aluno com a lista de cursos atualizada.

---

### 4. **Remover Aluno de Curso**

**Endpoint:** `DELETE /api/alunos/{id}/cursos/{cursoId}`

**Exemplo de Requisição:**
```bash
DELETE /api/alunos/1/cursos/1
```

**Resposta Esperada:** Retorna o aluno com a lista de cursos atualizada.

---

### 5. **Listar Cursos de um Aluno**

**Endpoint:** `GET /api/alunos/{id}/cursos`

**Exemplo de Requisição:**
```bash
GET /api/alunos/1/cursos
```

**Resposta Esperada:** Retorna uma lista de cursos em que o aluno está matriculado.

---

### 6. **Listar Alunos de um Curso**

**Endpoint:** `GET /api/cursos/{id}/alunos`

**Exemplo de Requisição:**
```bash
GET /api/cursos/1/alunos
```

**Resposta Esperada:** Retorna uma lista de alunos matriculados no curso.

---

### 7. **Testar a API**

**Endpoint:** `GET /api/test`

**Exemplo de Requisição:**
```bash
GET /api/test
```

**Resposta Esperada:** Retorna a mensagem `"API funcionando!"` para verificar se o serviço está online.

---

## Dependências

Este projeto utiliza as seguintes dependências:

- **Spring Boot 2.x** (para a criação da API REST)
- **Spring Data JPA** (para interagir com o banco de dados)
- **MySQL** (como banco de dados)
- **Maven** (para gerenciar dependências)

---

### Como Rodar

1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/seu-usuario/api-alunos-cursos.git
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd api-alunos-cursos
   ```

3. Execute o projeto com o Maven:
   ```bash
   mvn spring-boot:run
   ```

4. A API estará disponível em `http://localhost:8080`.

---

### Licença

Este projeto está licenciado sob a MIT License. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
