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

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private HashMap<Button,String> listaValores= new HashMap<>();

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
        Button botonEntre = findViewById(R.id.buttonEntre);
        Button botonPorcentaje = findViewById(R.id.buttonPorcentaje);
        Button botonCalcular = findViewById(R.id.buttonIgual);
        Button botonBorrar = findViewById(R.id.buttonDelete);
        Button botonAC = findViewById(R.id.buttonAC);
        TextView pantalla = findViewById(R.id.pantalla);
        Button botonComa = findViewById(R.id.buttonComa);
        pantalla.setText("");
        TextView resultadoPantalla = findViewById(R.id.resultado);

        this.listaValores.put(boton0, boton0.getText().toString());
        this.listaValores.put(boton1, boton1.getText().toString());
        this.listaValores.put(boton2, boton2.getText().toString());
        this.listaValores.put(boton3, boton3.getText().toString());
        this.listaValores.put(boton4, boton4.getText().toString());
        this.listaValores.put(boton5, boton5.getText().toString());
        this.listaValores.put(boton6, boton6.getText().toString());
        this.listaValores.put(boton7, boton7.getText().toString());
        this.listaValores.put(boton8, boton8.getText().toString());
        this.listaValores.put(boton9, boton9.getText().toString());
        this.listaValores.put(botonEntre, botonEntre.getText().toString());
        this.listaValores.put(botonPorcentaje, botonPorcentaje.getText().toString());
        this.listaValores.put(botonMas, botonMas.getText().toString());
        this.listaValores.put(botonMenos, botonMenos.getText().toString());
        this.listaValores.put(botonPor, botonPor.getText().toString());
        this.listaValores.put(botonComa, botonComa.getText().toString());
        this.listaValores.put(botonCalcular, botonComa.getText().toString());
        this.listaValores.put(botonBorrar, botonBorrar.getText().toString());
        this.listaValores.put(botonAC, botonAC.getText().toString());

        StringBuilder stringBuilder = new StringBuilder();
        
        for(Button key: listaValores.keySet()){
            if(key.getText().equals("AC")){
                key.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pantalla.setText("");
                        stringBuilder.delete(0, -1);
                    }
                });
            }else if(key.getText().equals("C")){
                key.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        stringBuilder.deleteCharAt(-1);
                        pantalla.setText(stringBuilder);
                    }
                });
            }else{
                //esto funciona, lo de arriba no
                key.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String textoPulsado = key.getText().toString();
                        stringBuilder.append(textoPulsado);
                        pantalla.setText(stringBuilder);
                    }
                });
            }

        }

//meter dentro de lo de arriba
//        botonAC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                pantalla.setText("");
//                stringBuilder.delete(0,-1);
//            }
//        });

        //split string in 2 with /, *, + or -
    }

}

