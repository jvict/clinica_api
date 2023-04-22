package br.com.fiap.medicos.domain.interfaces;

import br.com.fiap.medicos.domain.model.DoctorResponse;
import br.com.fiap.medicos.domain.model.entity.DoctorEntity;

public interface DoctorService {

    DoctorResponse save(DoctorEntity doctor);
    DoctorResponse find(String id);
    void delete(String id);
}
