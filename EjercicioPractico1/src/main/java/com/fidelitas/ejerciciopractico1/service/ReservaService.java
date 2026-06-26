package com.fidelitas.ejerciciopractico1.service;

import com.fidelitas.ejerciciopractico1.domain.Reserva;
import java.util.List;

public interface ReservaService {
    List<Reserva> listarReservas();
    void guardar(Reserva reserva);
    void eliminar(Long id);
    Reserva buscarPorId(Long id);
}