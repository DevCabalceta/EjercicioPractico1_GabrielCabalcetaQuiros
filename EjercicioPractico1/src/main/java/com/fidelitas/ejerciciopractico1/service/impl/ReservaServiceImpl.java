package com.fidelitas.ejerciciopractico1.service.impl;

import com.fidelitas.ejerciciopractico1.domain.Reserva;
import com.fidelitas.ejerciciopractico1.repository.ReservaRepository;
import com.fidelitas.ejerciciopractico1.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }
}