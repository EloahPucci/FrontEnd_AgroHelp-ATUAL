package com.projeto.integrador;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PropostasActivity extends DrawerCreator implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerProp;
    private static final String[] listaDoSpinnerPropostas = {"Todas", "Em andamento", "Finalizadas"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_propostas);
        super.onCreate(savedInstanceState);

        spinnerProp = (Spinner) findViewById(R.id.listaDropDown_StatusDaProposta);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PropostasActivity.this, android.R.layout.simple_spinner_dropdown_item, listaDoSpinnerPropostas);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProp.setAdapter(adapter);
        spinnerProp.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
