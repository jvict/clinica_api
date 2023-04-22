package br.com.fiap.medicos.domain.model;

import br.com.fiap.medicos.domain.model.entity.PacienteEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class PacienteResponse {
    //Classe responsavel por capturar os dados recebidos no body

    private String id;
    private String nome;
    private String cpf;
    private String data_nascimento;
    private String num_convenio;
    private String convenio;

    public PacienteResponse(String id, String nome, String cpf,String data_nascimento,String num_convenio, String convenio){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.num_convenio = num_convenio;
        this.convenio = convenio;
    }

    public PacienteResponse(PacienteEntity paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
        this.data_nascimento = paciente.getData_nascimento();
        this.num_convenio = paciente.getNum_convenio();
        this.convenio =  paciente.getConvenio();
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
