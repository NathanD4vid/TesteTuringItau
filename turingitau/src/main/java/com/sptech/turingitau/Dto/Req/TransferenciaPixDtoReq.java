package com.sptech.turingitau.Dto.Req;

import javax.validation.constraints.NotBlank;

public class TransferenciaPixDtoReq {
    @NotBlank
    private String cpf;

    private Double quantia;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getQuantia() {
        return quantia;
    }

    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }
}
