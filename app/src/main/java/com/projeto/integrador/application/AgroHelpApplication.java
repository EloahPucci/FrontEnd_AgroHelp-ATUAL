package com.projeto.integrador.application;

import android.app.Application;

import com.projeto.integrador.domain.Usuario;

public class AgroHelpApplication extends Application {

    private static AgroHelpApplication agroHelpApplication;
    private Usuario usuario;

    public synchronized static AgroHelpApplication getInstance() {
        return agroHelpApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        agroHelpApplication = this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
