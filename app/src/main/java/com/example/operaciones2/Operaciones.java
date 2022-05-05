package com.example.operaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Operaciones extends Activity {
    Button btnLimpiar,btnPotencia,btnDivision,btnSiete,btnOcho,btnNueve,btnMultiplicacion,btnCuatro,btnCinco,btnSeis,btnMenos,btnUno,btnDos,btnTres,btnMas,btnZero,btnPunto,btnIgual,btnParentesis,btnPorcentaje ;
    ImageButton btnBorrarUltimo;
    TextView txtView1,txtView2;

    String ecuacion="";
    String formula = "";
    String formulaTemporal="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);


        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);
        btnBorrarUltimo = (ImageButton)findViewById(R.id.btnBorrarUltimo);
        btnPotencia = (Button)findViewById(R.id.btnPotencia);
        btnDivision = (Button)findViewById(R.id.btnDivision);
        btnSiete = (Button)findViewById(R.id.btnSiete);
        btnOcho = (Button)findViewById(R.id.btnOcho);
        btnNueve = (Button)findViewById(R.id.btnNueve);
        btnMultiplicacion = (Button)findViewById(R.id.btnMultiplicacion);
        btnPorcentaje = (Button)findViewById(R.id.btnPorcentaje);
        btnCinco = (Button)findViewById(R.id.btnCinco);
        btnCuatro = (Button)findViewById(R.id.btnCuatro);
        btnSeis = (Button)findViewById(R.id.btnSeis);
        btnMenos = (Button)findViewById(R.id.btnMenos);
        btnUno = (Button)findViewById(R.id.btnUno);
        btnDos = (Button)findViewById(R.id.btnDos);
        btnTres = (Button)findViewById(R.id.btnTres);
        btnMas = (Button)findViewById(R.id.btnMas);
        btnZero = (Button)findViewById(R.id.btnZero);
        btnPunto = (Button)findViewById(R.id.btnPunto);
        btnIgual = (Button)findViewById(R.id.btnIgual);
        txtView1 = (TextView)findViewById(R.id.textView1);
        txtView2 = (TextView)findViewById(R.id.textView2);


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("0");
            }
        });

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("1");
            }
        });

        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("2");
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("3");
            }
        });

        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("4");
            }
        });

        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("5");
            }
        });

        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("6");
            }
        });

        btnSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("7");
            }
        });

        btnOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("8");
            }
        });

        btnNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("9");
            }
        });

        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("/100");
            }
        });

        btnPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("^");
            }
        });


        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("+");
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("-");
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("*");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion("/");
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEcuacion(".");
            }
        });


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtView1.setText("");
                txtView2.setText("");
                ecuacion="";
                parenIzquierdo = true;
            }
        });


        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result = null;
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
                Revisar();

                try {
                    result = (double)engine.eval(formula);
                } catch (ScriptException e)
                {
                    Toast.makeText(getApplicationContext(),"Valor ingresados invalidos", Toast.LENGTH_SHORT).show();
                }

                if(result != null)
                    txtView2.setText(String.valueOf(result.doubleValue()));
            }
        });



    }

    public void BorrarUltimo(View view)
    {
        String ecuaTemp ;
        ecuaTemp = ecuacion;
        ecuacion = "";
        ecuaTemp= ecuaTemp.replaceFirst(".$","");
        setEcuacion(ecuaTemp);
    }


    private void setEcuacion(String valorIngresado)
    {

        ecuacion = ecuacion + valorIngresado;
        txtView1.setText(ecuacion);
    }


    boolean parenIzquierdo = true;
    public void parentesisRevision(View view)
    {
        if(parenIzquierdo)
        {
            setEcuacion("(");
            parenIzquierdo = false;
        }
        else
        {
            setEcuacion(")");
            parenIzquierdo = true;
        }
    }

    private void Revisar()
    {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0; i < ecuacion.length(); i++)
        {
            if (ecuacion.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = ecuacion;
        formulaTemporal = ecuacion;
        for(Integer index: indexOfPowers)
        {
            CambiarFormula(index);
        }
        formula = formulaTemporal;
    }

    private void CambiarFormula(Integer index)
    {
        String numeroIzquierdo = "";
        String numeroDerecho = "";

        for(int i = index + 1; i< ecuacion.length(); i++)
        {
            if(esNumerico(ecuacion.charAt(i)))
                numeroDerecho = numeroDerecho + ecuacion.charAt(i);
            else
                break;
        }

        for(int i = index - 1; i >= 0; i--)
        {
            if(esNumerico(ecuacion.charAt(i)))
                numeroIzquierdo = numeroIzquierdo + ecuacion.charAt(i);
            else
                break;
        }

        String original = numeroIzquierdo + "^" + numeroDerecho;
        String changed = "Math.pow("+numeroIzquierdo+","+numeroDerecho+")";

        formulaTemporal = formulaTemporal.replace(original,changed);

    }






    private boolean esNumerico(char c)
    {
        if((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }
}