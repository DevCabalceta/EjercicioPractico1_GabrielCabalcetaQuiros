package com.fidelitas.ejerciciopractico1.repository;

import com.fidelitas.ejerciciopractico1.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}