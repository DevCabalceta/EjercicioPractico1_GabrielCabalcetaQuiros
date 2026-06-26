package com.fidelitas.ejerciciopractico1.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente")
    private String nombreCliente;
    
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
}