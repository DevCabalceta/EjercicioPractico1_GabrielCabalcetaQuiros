package com.fidelitas.ejerciciopractico1.repository;

import com.fidelitas.ejerciciopractico1.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}