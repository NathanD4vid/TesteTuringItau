package com.sptech.turingitau.Dto.Req;

import javax.validation.constraints.NotBlank;

public class TransferenciaTedDocDtoReq {
    @NotBlank
    private String agencia;

    private String conta;

    private Double quantia;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Double getQuantia() {
        return quantia;
    }

    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }
}
