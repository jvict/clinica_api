package br.com.fiap.medicos.domain.interfaces.repository;

import br.com.fiap.medicos.domain.model.entity.PacienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<PacienteEntity, String> {
}
