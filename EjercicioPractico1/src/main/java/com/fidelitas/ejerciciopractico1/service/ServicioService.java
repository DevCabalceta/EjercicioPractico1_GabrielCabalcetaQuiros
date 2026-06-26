package com.fidelitas.ejerciciopractico1.service;

import com.fidelitas.ejerciciopractico1.domain.Servicio;
import java.util.List;

public interface ServicioService {
    List<Servicio> listarServicios();
    void guardar(Servicio servicio);
    void eliminar(Long id);
    Servicio buscarPorId(Long id);
}