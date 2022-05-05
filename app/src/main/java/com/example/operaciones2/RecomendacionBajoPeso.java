package com.example.operaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class RecomendacionBajoPeso extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendacion_bajo_peso);
    }

    public void regresarconsejo1(View view) {
        finish();
    }
}