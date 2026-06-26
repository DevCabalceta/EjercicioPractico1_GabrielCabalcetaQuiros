package com.fidelitas.ejerciciopractico1.service.impl;

import com.fidelitas.ejerciciopractico1.domain.Servicio;
import com.fidelitas.ejerciciopractico1.repository.ServicioRepository;
import com.fidelitas.ejerciciopractico1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        servicioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio buscarPorId(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }
}