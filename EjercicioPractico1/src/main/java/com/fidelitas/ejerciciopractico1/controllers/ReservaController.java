package com.fidelitas.ejerciciopractico1.controllers;

import com.fidelitas.ejerciciopractico1.domain.Reserva;
import com.fidelitas.ejerciciopractico1.service.ReservaService;
import com.fidelitas.ejerciciopractico1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService; 

    @GetMapping("/listado")
    public String listado(Model model) {
        var reservas = reservaService.listarReservas();
        model.addAttribute("reservas", reservas);
        return "reserva/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Reserva reserva, Model model) {
        var servicios = servicioService.listarServicios();
        model.addAttribute("servicios", servicios);
        return "reserva/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Reserva reserva, Model model) {
        reserva = reservaService.buscarPorId(reserva.getId());
        var servicios = servicioService.listarServicios();
        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicios);
        return "reserva/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Reserva reserva) {
        reservaService.eliminar(reserva.getId());
        return "redirect:/reserva/listado";
    }
}