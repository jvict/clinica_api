package br.com.fiap.medicos;

import br.com.fiap.medicos.domain.interfaces.repository.DoctorRepository;
import br.com.fiap.medicos.domain.interfaces.repository.PacienteRepository;
import br.com.fiap.medicos.domain.model.DoctorResponse;
import br.com.fiap.medicos.domain.model.PacienteResponse;
import br.com.fiap.medicos.domain.model.entity.DoctorEntity;
import br.com.fiap.medicos.domain.model.entity.PacienteEntity;
import br.com.fiap.medicos.services.DoctorServiceImpl;
import br.com.fiap.medicos.services.PacienteServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MedicosApplicationTests {


	@InjectMocks
	DoctorServiceImpl doctorService;

	@InjectMocks
	PacienteServiceImpl pacienteService;

	@Mock
	DoctorRepository doctorRepository;

	@Mock
	PacienteRepository pacienteRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void savePacienteTest() {

		when(pacienteRepository.save(any(PacienteEntity.class))).thenReturn(null);

		PacienteEntity paciente = new PacienteEntity();
		paciente.setNome("Paciente 1");
		paciente.setCpf("12345678910");
		paciente.setData_nascimento("24/11/1999");
		paciente.setNum_convenio("12345");
		paciente.setConvenio("Teste");

		PacienteResponse pacienteResponse = pacienteService.save(paciente);

		assertNotNull(pacienteResponse.getId());
		assertEquals(pacienteResponse.getNome(), "Paciente 1");
		assertEquals(pacienteResponse.getCpf(), "12345678910");
		assertEquals(pacienteResponse.getData_nascimento(), "24/11/1999");
		assertEquals(pacienteResponse.getNum_convenio(), "12345");
		assertEquals(pacienteResponse.getConvenio(), "Teste");
	}

	@Test
	public void alterandoPacienteTest() {

		when(pacienteRepository.save(any(PacienteEntity.class))).thenReturn(null);

		PacienteEntity paciente = new PacienteEntity();
		paciente.setNome("Paciente 1");
		paciente.setCpf("12345678910");
		paciente.setData_nascimento("24/11/1999");
		paciente.setNum_convenio("12345");
		paciente.setConvenio("Teste");
		paciente.setId("8d2c35e7-b3e4-4f8a-9a4b-b28fa739c3a9");

		PacienteResponse pacienteResponse = pacienteService.save(paciente);

		assertNotNull(pacienteResponse.getId(),"8d2c35e7-b3e4-4f8a-9a4b-b28fa739c3a9");
		assertEquals(pacienteResponse.getNome(), "Paciente 1");
		assertEquals(pacienteResponse.getCpf(), "12345678910");
		assertEquals(pacienteResponse.getData_nascimento(), "24/11/1999");
		assertEquals(pacienteResponse.getNum_convenio(), "12345");
		assertEquals(pacienteResponse.getConvenio(), "Teste");

	}

	@Test
	public void deletePacienteTest() {
		doctorService.delete("8d2c35e7-b3e4-4f8a-9a4b-b28fa739c3a9");
	}

	@Test
	public void findPacienteTest() {

		PacienteEntity paciente = new PacienteEntity();
		paciente.setNome("Paciente 1");
		paciente.setCpf("12345678910");
		paciente.setData_nascimento("24/11/1999");
		paciente.setNum_convenio("12345");
		paciente.setConvenio("Teste");
		paciente.setId("8d2c35e7-b3e4-4f8a-9a4b-b28fa739c3a9");

		Optional<PacienteEntity> pacienteEntity = Optional.of(paciente);
		when(pacienteRepository.findById(anyString())).thenReturn(pacienteEntity);

		PacienteResponse pacienteResponse = pacienteService.find("f04b86dc-cf3a-4b6b-9635-ab1f848f7465");

		assertNotNull(pacienteResponse.getId(),"8d2c35e7-b3e4-4f8a-9a4b-b28fa739c3a9");
		assertEquals(pacienteResponse.getNome(), "Paciente 1");
		assertEquals(pacienteResponse.getCpf(), "12345678910");
		assertEquals(pacienteResponse.getData_nascimento(), "24/11/1999");
		assertEquals(pacienteResponse.getNum_convenio(), "12345");
		assertEquals(pacienteResponse.getConvenio(), "Teste");
	}

	@Test
	public void saveDoctorTest() {

		when(doctorRepository.save(any(DoctorEntity.class))).thenReturn(null);

		DoctorEntity doctor = new DoctorEntity();
		doctor.setNome("Medico 1");
		doctor.setCpf("12345678910");
		doctor.setCrm("123456");
		doctor.setEspecialidade("Clinico");

		DoctorResponse doctorResponse = doctorService.save(doctor);

		assertNotNull(doctorResponse.getId());
		assertEquals(doctorResponse.getNome(), "Medico 1");
		assertEquals(doctorResponse.getCpf(), "12345678910");
		assertEquals(doctorResponse.getCrm(), "123456");
		assertEquals(doctorResponse.getEspecialidade(), "Clinico");
	}

	@Test
	public void alterandoDoctorTest() {

		when(doctorRepository.save(any(DoctorEntity.class))).thenReturn(null);

		DoctorEntity doctor = new DoctorEntity();
		doctor.setNome("Medico 1");
		doctor.setCpf("12345678910");
		doctor.setCrm("123456");
		doctor.setEspecialidade("Clinico");
		doctor.setId("f04b86dc-cf3a-4b6b-9635-ab1f848f7465");

		DoctorResponse doctorResponse = doctorService.save(doctor);

		assertNotNull(doctorResponse.getId(),"f04b86dc-cf3a-4b6b-9635-ab1f848f7465");
		assertEquals(doctorResponse.getNome(), "Medico 1");
		assertEquals(doctorResponse.getCpf(), "12345678910");
		assertEquals(doctorResponse.getCrm(), "123456");
		assertEquals(doctorResponse.getEspecialidade(), "Clinico");

	}

	@Test
	public void deleteDoctorTest() {
		doctorService.delete("f04b86dc-cf3a-4b6b-9635-ab1f848f7465");
	}

	@Test
	public void findDoctorTest() {

		DoctorEntity doctor = new DoctorEntity();

		doctor.setNome("Medico 1");
		doctor.setCpf("12345678910");
		doctor.setCrm("123456");
		doctor.setEspecialidade("Clinico");
		doctor.setId("f04b86dc-cf3a-4b6b-9635-ab1f848f7465");

		Optional<DoctorEntity> doctorOptional = Optional.of(doctor);
		when(doctorRepository.findById(anyString())).thenReturn(doctorOptional);

		DoctorResponse doctorResponse = doctorService.find("f04b86dc-cf3a-4b6b-9635-ab1f848f7465");

		assertNotNull(doctorResponse.getId(),"f04b86dc-cf3a-4b6b-9635-ab1f848f7465");
		assertEquals(doctorResponse.getNome(), "Medico 1");
		assertEquals(doctorResponse.getCpf(), "12345678910");
		assertEquals(doctorResponse.getCrm(), "123456");
		assertEquals(doctorResponse.getEspecialidade(), "Clinico");
	}

}
