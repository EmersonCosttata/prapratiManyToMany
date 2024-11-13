package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Métodos de consulta adicionais, se necessário, podem ser adicionados aqui
}