package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ApiService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlunoCursoController {

    @Autowired
    private ApiService service;

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = service.criarAluno(aluno);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> adicionarCurso(@RequestBody Curso curso) {
        Curso novoCurso = service.criarCurso(curso);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }

    @PostMapping("/alunos/{id}/cursos/{cursoId}")
    public ResponseEntity<Aluno> matricularAlunoEmCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        Aluno alunoAtualizado = service.matricularAlunoEmCurso(id, cursoId);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/alunos/{id}/cursos/{cursoId}")
    public ResponseEntity<Aluno> removerAlunoDeCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        Aluno alunoAtualizado = service.removerAlunoDeCurso(id, cursoId);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("API funcionando!");
    }


    @GetMapping("/alunos/{id}/cursos")
    public ResponseEntity<List<Curso>> listarCursosDeAluno(@PathVariable Long id) {
        List<Curso> cursos = service.listarCursosDeAluno(id);
        return cursos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cursos);
    }

    @GetMapping("/cursos/{id}/alunos")
    public ResponseEntity<List<Aluno>> listarAlunosDeCurso(@PathVariable Long id) {
        List<Aluno> alunos = service.listarAlunosDeCurso(id);
        return alunos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(alunos);
    }
}
