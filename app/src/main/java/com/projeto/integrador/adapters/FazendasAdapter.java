package com.projeto.integrador.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projeto.integrador.R;
import com.projeto.integrador.domain.Fazendas;

import java.util.List;

public class FazendasAdapter extends BaseAdapter {

    private Context contexto;
    private List<Fazendas> lista;

    public FazendasAdapter(Context contexto, List<Fazendas> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /* Comentado para testes de Login somente

        Fazendas fazenda = lista.get(position);
        View linha = LayoutInflater.from(contexto).inflate(R.layout.layout_linha_listview_fazendas, null);

        TextView longitude = (TextView) linha.findViewById(R.id.longitude);
        TextView latitude = (TextView) linha.findViewById(R.id.latitude);
        TextView nome = (TextView) linha.findViewById(R.id.nomeFazenda);

        longitude.setText(fazenda.getLongitude() + "");
        latitude.setText((fazenda.getLatitude() + ""));
        nome.setText(fazenda.getNome());

        */

        return null;
    }
}
