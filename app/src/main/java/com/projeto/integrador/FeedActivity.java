package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.projeto.integrador.adapters.PropostaAdapter;
import com.projeto.integrador.domain.Proposta;
import com.projeto.integrador.services.InterfaceDeServicos;
import com.projeto.integrador.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedActivity extends DrawerCreator {

    TextView textView;
    ListView listaPropostas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.telamiolo);
        super.onCreate(savedInstanceState);

        listaPropostas = (ListView) findViewById(R.id.listView_listaDoFeed);

        imprimePropostasGerais();
    }

    private void imprimePropostasGerais() {
        InterfaceDeServicos services = RetrofitService.getServico();
        Call<List<Proposta>> call = services.obterPropostas();
        Log.i("teste", "------------> 1");
        call.enqueue(new Callback<List<Proposta>>() {
            @Override
            public void onResponse(Call<List<Proposta>> call, Response<List<Proposta>> response) {
                Log.i("teste", "------------> 2");
                List<Proposta> listaDePropostasGerais = response.body();
                Log.i("teste", "------------> 2.1: "+listaDePropostasGerais.size());
                listaPropostas.setAdapter(new PropostaAdapter(FeedActivity.this, listaDePropostasGerais));
            }

            @Override
            public void onFailure(Call<List<Proposta>> call, Throwable t) {
                Log.i("teste", "------------> 3: " + t.getCause());
            }
        });
    }

    public void vaiParaMinhasPropostas(View view){
        Intent intent = new Intent(this, PropostasActivity.class);
        startActivity(intent);
    }
}
