package com.projeto.integrador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.projeto.integrador.domain.Usuario;

public class CabecalhoGavetaActivity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabecalho_gaveta);

        Intent i = new Intent();
        Usuario userLogado = (Usuario) i.getSerializableExtra("usuario");
        textView = findViewById(R.id.nome_do_usuario);
        textView.setText("teste");
    }
}
