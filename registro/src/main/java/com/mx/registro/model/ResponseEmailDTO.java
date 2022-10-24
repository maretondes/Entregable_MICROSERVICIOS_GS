package com.mx.registro.model;

public class ResponseEmailDTO {

    String code;
    String Existe;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExiste() {
        return Existe;
    }

    public void setExiste(String existe) {
        Existe = existe;
    }

    @Override
    public String toString() {
        return "ResponseEmailDTO{" +
                "code='" + code + '\'' +
                ", Existe='" + Existe + '\'' +
                '}';
    }
}
