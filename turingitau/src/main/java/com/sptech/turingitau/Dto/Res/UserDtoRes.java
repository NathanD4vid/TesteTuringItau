package com.sptech.turingitau.Dto.Res;


import com.sptech.TuringItau.Entity.UserEntity;

public class UserDtoRes {

    private Integer id;

    private String nome;

    private String email;

    private String cpf;

    private String agencia;

    private String conta;

    private double saldo;

    public UserDtoRes() {

    }

    public UserDtoRes(UserEntity user) {
        this.agencia = user.getAgencia();
        this.conta = user.getConta();
        this.cpf = user.getCpf();
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.saldo = user.getSaldo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
