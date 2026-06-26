package com.fidelitas.ejerciciopractico1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String inicio() {
        return "index"; 
    }
    
    @GetMapping("/contacto")
    public String contacto() {
        return "contacto"; // Carga la interfaz de contacto
    }
}