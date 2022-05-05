package com.example.operaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarIMC extends Activity {
    TextView datos, titulo;
    String d1,d2,d3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_imc);

        recibirDatos();
    }

    private void recibirDatos()
    {
        Bundle extras = getIntent().getExtras();
        d1 = extras.getString("mensaje");
        d2 = extras.getString("IMC");
        d3 = extras.getString("nombre");

        datos = (TextView) findViewById(R.id.DATOS);
        titulo = (TextView) findViewById(R.id.titulo);

        titulo.setText(d3 + " el calculo de tu IMC indica");
        datos.setText(d1 + " con un valor de: " + d2);
    }

    public void volver(View view) {
        finish();
    }

    public void recomendaciones(View view) {
        if(Float.parseFloat(d2)<=18.49){
            Intent i = new Intent(MostrarIMC.this, RecomendacionBajoPeso.class);
            startActivity(i);
        }
        else if (Float.parseFloat(d2)>=25.00){
            Intent i = new Intent(MostrarIMC.this, RecomendacionesSobrePeso.class);
            startActivity(i);
        }
        else {
            Toast.makeText(getApplicationContext(),"Tu peso se encuentra en un nivel adecuado continua manteniendo tus habitos",Toast.LENGTH_LONG).show();
        }

    }
}