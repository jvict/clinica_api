package br.com.fiap.medicos.domain.interfaces;

import br.com.fiap.medicos.domain.model.PacienteResponse;
import br.com.fiap.medicos.domain.model.entity.PacienteEntity;

public interface PacienteService {

    PacienteResponse save(PacienteEntity paciente);
    PacienteResponse find(String id);
    void delete(String id);
}
