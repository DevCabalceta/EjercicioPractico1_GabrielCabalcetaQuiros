package com.fidelitas.ejerciciopractico1.service;

import com.fidelitas.ejerciciopractico1.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listarCategorias();
    void guardar(Categoria categoria);
    void eliminar(Long id);
    Categoria buscarPorId(Long id);
}