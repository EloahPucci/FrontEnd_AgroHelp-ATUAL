package com.projeto.integrador.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable {

    private String nome;
    private String senha;
    private String cpf;
    private String email;
    private String login;
    //private Fazendas fazendas; //Fazenda acho que não traz por aqui.


    public Usuario(String nome, String senha, String cpf, String email, String login) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    //public Fazendas getFazendas() {
    //    return fazendas;
    //}

    //public void setFazendas(Fazendas fazendas) {
    //    this.fazendas = fazendas;
    //}
}
