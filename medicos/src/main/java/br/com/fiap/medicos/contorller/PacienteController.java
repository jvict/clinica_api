package br.com.fiap.medicos.contorller;

import br.com.fiap.medicos.domain.interfaces.PacienteService;
import br.com.fiap.medicos.domain.model.PacienteResponse;
import br.com.fiap.medicos.domain.model.ResponseDoctorEntity;
import br.com.fiap.medicos.domain.model.entity.PacienteEntity;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    Logger LOG = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private PacienteService service;

    //Metodo GET responsavel para selecionar um paciente de acordo com o id do mesmo
    @GetMapping("/{id}")
    public ResponseEntity selectPaciente(@PathVariable String id){
        try {
            PacienteResponse paciente = service.find(id);
            return  ResponseEntity.ok(new ResponseDoctorEntity(paciente));
        } catch (Exception ex){
            LOG.error("Paciente não encontrado", ex);
            return ResponseEntity.internalServerError().body(new ResponseDoctorEntity(ex.getMessage()));
        }
    }

    //Metodo POST responsavel por cadastrar um paciente
    @PostMapping
    public ResponseEntity savePaciente(@RequestBody PacienteEntity paciente){
        try {
            PacienteResponse pacienteResponse = service.save(paciente);
            return ResponseEntity.created(new URI("/PACIENTE/"+pacienteResponse.getId()))
                    .body(new ResponseDoctorEntity(pacienteResponse));
        } catch (Exception ex){
            LOG.error("Paciente não encontrado", ex);
            return ResponseEntity.internalServerError().body(new ResponseDoctorEntity(ex.getMessage()));
        }
    }

    //Metodo Put responsavel por atualizar qualquer dado de um paciente existente de acordo com seu ID
    @PutMapping("/{id}")
    public ResponseEntity updatePaciente(@RequestBody @NotNull PacienteEntity paciente,@PathVariable String id){

        try {

            paciente.setId(id);
            PacienteResponse pacienteResponse = service.save(paciente);
            return ResponseEntity.ok(new ResponseDoctorEntity(pacienteResponse));
        }catch (Exception ex){
            LOG.error("Erro ao alterar dados do paciente", ex);
            return ResponseEntity.internalServerError().body(new ResponseDoctorEntity(ex.getMessage()));
        }

    }

    // Metodo DELETE responsavel por remover um paciente de com o ID
    @DeleteMapping("/{id}")
    public ResponseEntity removePaciente(@PathVariable String id){
        try {
            service.delete(id);
            return  ResponseEntity.ok(new ResponseDoctorEntity("Paciente excluído com sucesso."));
        }catch (Exception ex){
            LOG.error("Problema ao excluir paciente", ex);
            return ResponseEntity.internalServerError().body(new ResponseDoctorEntity(ex.getMessage()));
        }
    }
}
