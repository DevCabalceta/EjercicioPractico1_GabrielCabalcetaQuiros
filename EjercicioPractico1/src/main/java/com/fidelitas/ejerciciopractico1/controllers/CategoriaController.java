package com.fidelitas.ejerciciopractico1.controllers;

import com.fidelitas.ejerciciopractico1.domain.Categoria;
import com.fidelitas.ejerciciopractico1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "categoria/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Categoria categoria) {
        return "categoria/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Categoria categoria, Model model) {
        categoria = categoriaService.buscarPorId(categoria.getId());
        model.addAttribute("categoria", categoria);
        return "categoria/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Categoria categoria) {
        categoriaService.eliminar(categoria.getId());
        return "redirect:/categoria/listado";
    }
}