package com.example.operaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class PantallaInicio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(PantallaInicio.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea,2000);
    }
}