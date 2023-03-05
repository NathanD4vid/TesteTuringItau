package com.sptech.turingitau.Dto.Res;

public class ComprovanteDtoRes {
    private UserDtoRes dadosEmissor;

    private UserDtoRes dadosReceptor;

    private String tipoTransferencia;

    public ComprovanteDtoRes() {

    }


    public ComprovanteDtoRes(String tipoTransferencia ,UserDtoRes dadosEmissor, UserDtoRes dadosReceptor) {
        this.tipoTransferencia = tipoTransferencia;
        this.dadosEmissor = dadosEmissor;
        this.dadosReceptor = dadosReceptor;
    }

    public UserDtoRes getDadosEmissor() {
        return dadosEmissor;
    }

    public void setDadosEmissor(UserDtoRes dadosEmissor) {
        this.dadosEmissor = dadosEmissor;
    }

    public UserDtoRes getDadosReceptor() {
        return dadosReceptor;
    }

    public void setDadosReceptor(UserDtoRes dadosReceptor) {
        this.dadosReceptor = dadosReceptor;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }
}
