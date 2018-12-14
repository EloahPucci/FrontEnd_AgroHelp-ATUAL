package com.projeto.integrador.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projeto.integrador.R;
import com.projeto.integrador.domain.Proposta;

import java.util.List;

public class PropostaAdapter extends BaseAdapter {

    private Context context;
    private List<Proposta> lista;

    public PropostaAdapter(Context context, List<Proposta> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Proposta proposta = lista.get(position);
        Log.i("teste","------------> 2.2: "+ proposta.getDescricao());
        View linha = LayoutInflater.from(context).inflate(R.layout.linha_list_view_proposta_feed, null);

        TextView nomeUsuario = (TextView) linha.findViewById(R.id.nomeUsuario_postFeed);
        TextView descricaoServico = (TextView) linha.findViewById(R.id.descricaoServico_postFeed);
        TextView nomeFazenda = (TextView) linha.findViewById(R.id.nomeFazenda_postFeed);
        TextView prazoServico = (TextView) linha.findViewById(R.id.prazoServico_postFeed);

        nomeUsuario.setText(proposta.getNomeDoUsuario());
        descricaoServico.setText(proposta.getDescricao() + " descrição aqui");
        nomeFazenda.setText(proposta.getFazenda());
        prazoServico.setText(proposta.getPrazo() + "");

        return linha;
    }
}
