package com.example.demo.service;

import com.example.demo.Repository.AlunoRepository;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.model.Aluno;
import com.example.demo.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ApiService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Aluno matricularAlunoEmCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new NoSuchElementException("Aluno não encontrado para o ID: " + alunoId));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new NoSuchElementException("Curso não encontrado para o ID: " + cursoId));

        if (!aluno.getCursos().contains(curso)) {
            aluno.getCursos().add(curso);
            return alunoRepository.save(aluno);
        }
        return aluno;
    }

    public Aluno removerAlunoDeCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new NoSuchElementException("Aluno não encontrado para o ID: " + alunoId));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new NoSuchElementException("Curso não encontrado para o ID: " + cursoId));

        if (aluno.getCursos().contains(curso)) {
            aluno.getCursos().remove(curso);
            return alunoRepository.save(aluno);
        }
        return aluno;
    }

    public List<Curso> listarCursosDeAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new NoSuchElementException("Aluno não encontrado para o ID: " + alunoId));
        return List.copyOf(aluno.getCursos());
    }

    public List<Aluno> listarAlunosDeCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new NoSuchElementException("Curso não encontrado para o ID: " + cursoId));
        return List.copyOf(curso.getAlunos());
    }
}
