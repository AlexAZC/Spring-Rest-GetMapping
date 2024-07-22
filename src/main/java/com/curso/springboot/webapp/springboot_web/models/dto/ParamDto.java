package com.curso.springboot.webapp.springboot_web.models.dto;

public class ParamDto {

    private String message;
    private Integer code;



    /* GETTERS Y SETTERS */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
