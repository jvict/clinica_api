package br.com.fiap.medicos.services;

import br.com.fiap.medicos.domain.interfaces.PacienteService;
import br.com.fiap.medicos.domain.interfaces.repository.PacienteRepository;
import br.com.fiap.medicos.domain.model.DoctorResponse;
import br.com.fiap.medicos.domain.model.PacienteResponse;
import br.com.fiap.medicos.domain.model.entity.PacienteEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PacienteServiceImpl implements PacienteService {

    Logger LOG = LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Autowired
    private PacienteRepository repository;

    public PacienteResponse save(PacienteEntity paciente){


        if(paciente.getId() == null || paciente.getId().isEmpty()){
            paciente.setId(UUID.randomUUID().toString());
        }

        repository.save(paciente);
        return new PacienteResponse(paciente);
    }

    public void delete(String id){
        LOG.info("Removendo Paciente: " + id);
        repository.deleteById(id);
    }


    public PacienteResponse find(String id){
        LOG.info("Procurar Paciente: " + id);
        PacienteEntity pacienteEntity = repository.findById(id).get();
        return new PacienteResponse(pacienteEntity);
    }
}
