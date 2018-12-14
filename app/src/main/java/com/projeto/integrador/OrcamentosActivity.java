package com.projeto.integrador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class OrcamentosActivity extends DrawerCreator implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerOrcamentos;
    private static final String[] listaDoSpinnerOrcamentos = {"Todos", "Enviados", "Recebidos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_orcamentos);
        super.onCreate(savedInstanceState);

        spinnerOrcamentos = (Spinner) findViewById(R.id.listaDropDown_TipoDoOrcamento);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(OrcamentosActivity.this, android.R.layout.simple_spinner_dropdown_item, listaDoSpinnerOrcamentos);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrcamentos.setAdapter(adapter);
        spinnerOrcamentos.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
