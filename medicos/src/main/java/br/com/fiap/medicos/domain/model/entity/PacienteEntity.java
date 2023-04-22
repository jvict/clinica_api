package br.com.fiap.medicos.domain.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_paciente")
public class PacienteEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String nome;
    private String cpf;
    private String data_nascimento;
    private String num_convenio;
    private String convenio;

    public PacienteEntity(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getNum_convenio() {
        return num_convenio;
    }

    public void setNum_convenio(String num_convenio) {
        this.num_convenio = num_convenio;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
}
