package com.projeto.integrador.services;

import com.projeto.integrador.domain.Fazendas;
import com.projeto.integrador.domain.Proposta;
import com.projeto.integrador.domain.Usuario;
import com.projeto.integrador.services.domain.UsuarioRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceDeServicos {

    @GET("/usuarios")
    Call<Usuario> login(UsuarioRequest usuarioRequest);

    @GET("/fazendas")
    Call<List<Fazendas>> obterFazendas();

    @GET("/propostas")
    Call<List<Proposta>> obterPropostas();
}
