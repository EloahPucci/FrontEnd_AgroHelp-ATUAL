package com.projeto.integrador;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.projeto.integrador.application.AgroHelpApplication;
import com.projeto.integrador.domain.Usuario;

public class MinhaContaActivity extends DrawerCreator {

    private TextView textViewNomeUserLogado;
    private String nomeUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getNome();
    private TextView textViewCpfUserLogado;
    private String cpfUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getCpf();
    private TextView textViewEmailUserLogado;
    private String emailUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getEmail();
    private TextView textViewLoginUserLogado;
    private String loginUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getLogin();
    private TextView textViewSenhaUserLogado;
    private String senhaUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getSenha();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_minha_conta);
        super.onCreate(savedInstanceState);

        textViewNomeUserLogado = (TextView) findViewById(R.id.nomeMinhaConta);
        textViewCpfUserLogado = (TextView) findViewById(R.id.cpfMinhaConta);
        textViewEmailUserLogado = (TextView) findViewById(R.id.emailMinhaConta);
        textViewLoginUserLogado = (TextView) findViewById(R.id.loginMinhaConta);
        textViewSenhaUserLogado = (TextView) findViewById(R.id.senhaMinhaConta);

        listarDadosMinhaConta();
    }

    public void listarDadosMinhaConta(){

        textViewNomeUserLogado.setText(nomeUsuarioLogado);
        textViewCpfUserLogado.setText(cpfUsuarioLogado);
        textViewEmailUserLogado.setText(emailUsuarioLogado);
        textViewLoginUserLogado.setText(loginUsuarioLogado);
        textViewSenhaUserLogado.setText(senhaUsuarioLogado);
    }
}
