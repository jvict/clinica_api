package br.com.fiap.medicos.domain.model;

public class ResponseDoctorEntity {
    private Object content;
    private String message;

    public ResponseDoctorEntity(){
        super();
    }

    public ResponseDoctorEntity(Object content){
        this.content = content;
    }

    public ResponseDoctorEntity(String message){
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public String getMessage() {
        return message;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
