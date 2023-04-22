package br.com.fiap.medicos.contorller;


import br.com.fiap.medicos.domain.interfaces.DoctorService;
import br.com.fiap.medicos.domain.model.DoctorResponse;
import br.com.fiap.medicos.domain.model.ResponseEntity;
import br.com.fiap.medicos.domain.model.entity.DoctorEntity;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    Logger LOG = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private DoctorService service;

    //Metodo GET responsavel para selecionar um medico de acordo com o id do mesmo
    @GetMapping("/{id}")
    public org.springframework.http.ResponseEntity selectDoctor(@PathVariable String id){
        try {
            DoctorResponse doctor = service.find(id);
            return  org.springframework.http.ResponseEntity.ok(new ResponseEntity(doctor));
        } catch (Exception ex){
            LOG.error("Médico não encontrado", ex);
            return org.springframework.http.ResponseEntity.internalServerError().body(new ResponseEntity(ex.getMessage()));
        }
    }

    //Metodo POST responsavel por cadastrar um médico
    @PostMapping
    public org.springframework.http.ResponseEntity saveDoctor(@RequestBody DoctorEntity doctor){
        try {
            DoctorResponse doctorResponse = service.save(doctor);
            return org.springframework.http.ResponseEntity.created(new URI("/DOCTOR/"+doctorResponse.getId()))
                    .body(new ResponseEntity(doctorResponse));
        } catch (Exception ex){
            LOG.error("Médico não encontrado", ex);
            return org.springframework.http.ResponseEntity.internalServerError().body(new ResponseEntity(ex.getMessage()));
        }
    }

    //Metodo Put responsavel por atualizar qualquer dado de um médico existente de acordo com seu ID
    @PutMapping("/{id}")
    public org.springframework.http.ResponseEntity updateDoctor(@RequestBody @NotNull DoctorEntity doctor,
                                                                @PathVariable String id){

        try {

            doctor.setId(id);
            DoctorResponse doctorResponse = service.save(doctor);
            return org.springframework.http.ResponseEntity.ok(new ResponseEntity(doctorResponse));
        }catch (Exception ex){
            LOG.error("Erro ao alterar dados do médico", ex);
            return org.springframework.http.ResponseEntity.internalServerError().body(new ResponseEntity(ex.getMessage()));
        }

    }

    // Metodo DELETE responsavel por remover um médico de com o ID
    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity removeDoctor(@PathVariable String id){
        try {
            service.delete(id);
            return  org.springframework.http.ResponseEntity.ok(new ResponseEntity("Médico excluído com sucesso."));
        }catch (Exception ex){
            LOG.error("Problema ao excluir médico", ex);
            return org.springframework.http.ResponseEntity.internalServerError().body(new ResponseEntity(ex.getMessage()));
        }
    }
}
