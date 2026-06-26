package com.fidelitas.ejerciciopractico1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
