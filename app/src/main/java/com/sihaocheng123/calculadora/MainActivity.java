package com.sihaocheng123.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button boton1 = findViewById(R.id.button1);
        Button boton2 = findViewById(R.id.button2);
        Button boton3 = findViewById(R.id.button3);
        Button boton4 = findViewById(R.id.button4);
        Button boton5 = findViewById(R.id.button5);
        Button boton6 = findViewById(R.id.button6);
        Button boton7 = findViewById(R.id.button7);
        Button boton8 = findViewById(R.id.button8);
        Button boton9 = findViewById(R.id.button9);
        Button boton0 = findViewById(R.id.button0);
        Button botonMas = findViewById(R.id.buttonAdd);
        Button botonMenos = findViewById(R.id.buttonMenos);
        Button botonPor = findViewById(R.id.buttonX);
        Button botonEntre = findViewById(R.id.buttonDividir);
        Button botonPorcentaje = findViewById(R.id.buttonPorcentaje);
        Button botonCalcular = findViewById(R.id.buttonCalcular);
        Button botonBorrar = findViewById(R.id.buttonDelete);
        Button botonAC = findViewById(R.id.buttonAC);
        Button botonE = findViewById(R.id.buttonE);
        TextView pantalla = findViewById(R.id.pantalla);
        pantalla.setText("");
        TextView resultadoPantalla = findViewById(R.id.resultado);


        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(boton0);
        buttons.add(boton1);
        buttons.add(boton2);
        buttons.add(boton3);
        buttons.add(boton4);
        buttons.add(boton5);
        buttons.add(boton6);
        buttons.add(boton7);
        buttons.add(boton8);
        buttons.add(boton9);

        buttons.add(botonMas);
        buttons.add(botonMenos);
        buttons.add(botonPorcentaje);
        buttons.add(botonPor);
        buttons.add(botonEntre);
        buttons.add(botonBorrar);
        buttons.add(botonAC);
        buttons.add(botonE);

        ArrayList<Integer> listaNums = new ArrayList<>();
        String[] operador = new String[1];


        for (Button btn : buttons) {
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (isNumeric(btn.getText().toString())) {
                        String textoPantalla = pantalla.getText().toString();
                        textoPantalla += btn.getText();
                        pantalla.setText(textoPantalla);
                    }else{
                        String textoPantalla = pantalla.getText().toString();
                        textoPantalla += btn.getText();
                        pantalla.setText(textoPantalla);
                        operador[0] = btn.getText().toString();
                    }

                }
            });
        }

        botonCalcular.setOnClickListener(view -> {
            int resultadoOperacion = 0;
            switch (operador[0]) {
                case "+":
                    resultadoOperacion = listaNums.get(0) + listaNums.get(1);
                    break;
                case "-":
                    resultadoOperacion = listaNums.get(0) - listaNums.get(1);
                    break;
                case "X":
                    resultadoOperacion = listaNums.get(0) * listaNums.get(1);
                    break;
                case "/":
                    resultadoOperacion = listaNums.get(0) / listaNums.get(1);
                    break;
            }
            resultadoPantalla.setText(resultadoOperacion);
        });

}
        public static boolean isNumeric (String cadena){
            boolean resultado;
            try {
                Integer.parseInt(cadena);
                resultado = true;
            } catch (NumberFormatException excepcion) {
                resultado = false;
            }
            return resultado;
        }


    }
