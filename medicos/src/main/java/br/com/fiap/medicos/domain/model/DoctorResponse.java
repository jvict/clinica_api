package br.com.fiap.medicos.domain.model;

import br.com.fiap.medicos.domain.model.entity.DoctorEntity;

public class DoctorResponse {

    //Classe responsavel por capturar os dados recebidos no body
    private String id;
    private String nome;
    private String cpf;
    private String especialidade;
    private String crm;

    public DoctorResponse(String id, String nome, String cpf,String especialidade,String crm){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public DoctorResponse(DoctorEntity doctor) {
        this.id = doctor.getId();
        this.nome = doctor.getNome();
        this.cpf = doctor.getCpf();
        this.especialidade = doctor.getEspecialidade();
        this.crm = doctor.getCrm();
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
