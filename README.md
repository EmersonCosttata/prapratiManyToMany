Este projeto trata de uma API REST para gerenciar alunos e cursos, com funcionalidades de adicionar alunos, cursos, matricular alunos em cursos, listar alunos e cursos, e testar a API.
Esse projeto usa meaven, certifique que se tbm de ter o java 17 instalado!
Configurar o mysql no aplication.propeties como user senha, e colocar o nome do banco a ultilizar (cria ele tbm).

Endpoints e Exemplos de Requisições:
Adicionar Aluno

Endpoint: POST /api/alunos

{
  "nome": "João Silva",
  "email": "joao.silva@example.com"
}
Resposta Esperada: Retorna o aluno criado com o ID gerado.
Adicionar Curso

Endpoint: POST /api/cursos

{
  "nome": "Matemática"
}

Resposta Esperada: Retorna o curso criado com o ID gerado.
Matricular Aluno em Curso

Endpoint: POST /api/alunos/{id}/cursos/{cursoId}
POST /api/alunos/1/cursos/1

Resposta Esperada: Retorna o aluno com a lista de cursos atualizada.
Remover Aluno de Curso

Endpoint: DELETE /api/alunos/{id}/cursos/{cursoId}

Exemplo:
DELETE /api/alunos/1/cursos/1
Resposta Esperada: Retorna o aluno com a lista de cursos atualizada.
Listar Cursos de um Aluno


Endpoint: GET /api/alunos/{id}/cursos

Exemplo:
GET /api/alunos/1/cursos
Resposta Esperada: Retorna uma lista de cursos que o aluno está matriculado.
Listar Alunos de um Curso

Endpoint: GET /api/cursos/{id}/alunos

Exemplo:
GET /api/cursos/1/alunos
Resposta Esperada: Retorna uma lista de alunos matriculados no curso.

Testar a API
Endpoint: GET /api/test

GET /api/test
Resposta Esperada: Retorna a mensagem "API funcionando!" para verificar se o serviço está online.
