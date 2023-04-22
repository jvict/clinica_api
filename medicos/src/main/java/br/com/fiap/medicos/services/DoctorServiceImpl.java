package br.com.fiap.medicos.services;

import br.com.fiap.medicos.domain.interfaces.DoctorService;
import br.com.fiap.medicos.domain.interfaces.repository.DoctorRepository;
import br.com.fiap.medicos.domain.model.DoctorResponse;
import br.com.fiap.medicos.domain.model.entity.DoctorEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    Logger LOG = LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Autowired
    private DoctorRepository repository;

    public DoctorResponse save(DoctorEntity doctor){


        if(doctor.getId() == null || doctor.getId().isEmpty()){
            doctor.setId(UUID.randomUUID().toString());
        }

        repository.save(doctor);
        return new DoctorResponse(doctor);
    }

    public void delete(String id){
        LOG.info("Removendo Médico: " + id);
        repository.deleteById(id);
    }


    public DoctorResponse find(String id){
        LOG.info("Buscar Médico: " + id);
        DoctorEntity doctorEntity = repository.findById(id).get();
        return new DoctorResponse(doctorEntity);
    }

}
