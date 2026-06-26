package com.fidelitas.ejerciciopractico1.service.impl;

import com.fidelitas.ejerciciopractico1.domain.Categoria;
import com.fidelitas.ejerciciopractico1.repository.CategoriaRepository;
import com.fidelitas.ejerciciopractico1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}