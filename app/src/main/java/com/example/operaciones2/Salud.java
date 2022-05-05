package com.example.operaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Salud extends Activity {

    EditText etNombre, etPeso, etAltura;
    Button btnCalcular, btnLimpiar;
    RadioButton rbVaron, rbMujer;
    String mensaje;
    double IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);


        etNombre = (EditText) findViewById(R.id.editNombre);
        etPeso = (EditText) findViewById(R.id.editPeso);
        etAltura = (EditText) findViewById(R.id.editAltura);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        rbVaron = (RadioButton) findViewById(R.id.rbHombre);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Limpiar();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcularIMC();
                String imcres = String.format("%.2f",IMC);
                Intent i = new Intent(Salud.this, MostrarIMC.class);
                i.putExtra("nombre",etNombre.getText().toString());
                i.putExtra("mensaje",mensaje);
                i.putExtra("IMC",imcres);
                startActivity(i);
            }
        });
    }

    private void Limpiar()
    {
        etNombre.setText("");
        etPeso.setText("");
        etAltura.setText("");

    }

    private String MensajeIMC (double IMC)
    {
        //String mensaje = "";

        if(IMC < 16)
            mensaje = "Bajo peso muy grave";
        else if (IMC >= 16 & IMC <= 16.99)
            mensaje = "Bajo peso grave";
        else if (IMC >= 17 & IMC <= 18.49)
            mensaje = "Bajo peso";
        else if (IMC >= 18.50 & IMC <= 24.99)
            mensaje = "Peso normal";
        else if (IMC >= 25 & IMC <= 29.99)
            mensaje = "Sobrepeso";
        else if (IMC >= 30 & IMC <= 34.99)
            mensaje = "Obesidad grado I";
        else if (IMC >= 35 & IMC <= 39.99)
            mensaje = "Obesidad grado II";
        else if (IMC >= 40)
            mensaje = "Obesidad grado III";
        return mensaje;
    }



    private  void CalcularIMC()
    {
        String nombre = etNombre.getText().toString();
        Double altura = Double.valueOf(etAltura.getText().toString());
        Double peso = Double.valueOf(etPeso.getText().toString());
        IMC = peso / Math.pow(altura,2);

        Toast.makeText(this, nombre + " TU IMC es "+ String.format("%.2f",IMC)+" "+MensajeIMC(IMC), Toast.LENGTH_SHORT).show();

        if(rbMujer.isChecked() == true)
            Toast.makeText(this, " Eres MUJER", Toast.LENGTH_SHORT).show();
        else if (rbVaron.isChecked() == true)
            Toast.makeText(this, " Eres VARON", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, " No eligio genero", Toast.LENGTH_SHORT).show();
    }



}