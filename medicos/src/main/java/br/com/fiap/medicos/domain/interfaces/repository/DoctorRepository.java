package br.com.fiap.medicos.domain.interfaces.repository;

import br.com.fiap.medicos.domain.model.entity.DoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity, String> {
}
