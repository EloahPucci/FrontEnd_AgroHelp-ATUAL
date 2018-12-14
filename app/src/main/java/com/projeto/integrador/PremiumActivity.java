package com.projeto.integrador;

import android.app.Activity;
import android.os.Bundle;

public class PremiumActivity extends DrawerCreator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_premium);
        super.onCreate(savedInstanceState);
    }
}
