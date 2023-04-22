package br.com.fiap.medicos.domain.model;

public class ResponseEntity {
    private Object content;
    private String message;

    public ResponseEntity(){
        super();
    }

    public ResponseEntity(Object content){
        this.content = content;
    }

    public ResponseEntity(String message){
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
