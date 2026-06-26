package com.fidelitas.ejerciciopractico1.repository;

import com.fidelitas.ejerciciopractico1.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}