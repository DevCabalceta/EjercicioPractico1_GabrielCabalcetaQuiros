package com.fidelitas.ejerciciopractico1.controllers;

import com.fidelitas.ejerciciopractico1.domain.Servicio;
import com.fidelitas.ejerciciopractico1.service.CategoriaService;
import com.fidelitas.ejerciciopractico1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var servicios = servicioService.listarServicios();
        model.addAttribute("servicios", servicios);
        return "servicio/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Servicio servicio, Model model) {
        // Pasamos las categorías para que salgan en un "Select" desplegable
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "servicio/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Servicio servicio) {
        servicioService.guardar(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Servicio servicio, Model model) {
        servicio = servicioService.buscarPorId(servicio.getId());
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categorias);
        return "servicio/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Servicio servicio) {
        servicioService.eliminar(servicio.getId());
        return "redirect:/servicio/listado";
    }
}