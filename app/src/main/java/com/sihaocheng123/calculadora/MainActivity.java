package com.sihaocheng123.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView pantalla, resultadoPantalla;
    private double firstValue, secondValue, resultValue;
    private char operacionActual;
    private DecimalFormat decimalFormat;
    private Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    private Button botonMas, botonMenos, botonPor, botonEntre, botonPorcentaje, botonCalcular,
            botonBorrar, botonAC, botonComa;

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

        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        boton3 = findViewById(R.id.button3);
        boton4 = findViewById(R.id.button4);
        boton5 = findViewById(R.id.button5);
        boton6 = findViewById(R.id.button6);
        boton7 = findViewById(R.id.button7);
        boton8 = findViewById(R.id.button8);
        boton9 = findViewById(R.id.button9);
        boton0 = findViewById(R.id.button0);
        botonMas = findViewById(R.id.buttonAdd);
        botonMenos = findViewById(R.id.buttonMenos);
        botonPor = findViewById(R.id.buttonX);
        botonEntre = findViewById(R.id.buttonDividir);
        botonPorcentaje = findViewById(R.id.buttonPorcentaje);
        botonCalcular = findViewById(R.id.buttonCalcular);
        botonBorrar = findViewById(R.id.buttonDelete);
        botonAC = findViewById(R.id.buttonAC);
        pantalla = findViewById(R.id.pantalla);
        botonComa = findViewById(R.id.buttonComa);
        pantalla.setText("");
        resultadoPantalla = findViewById(R.id.resultado);

        firstValue = Double.NaN;
        decimalFormat = new DecimalFormat("#.########");

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "1");
            }
        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "1");
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "2");
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "3");
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "4");
            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "5");
            }
        });
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "6");
            }
        });
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "7");
            }
        });
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "8");
            }
        });
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "9");
            }
        });
        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + "0");
            }
        });
        botonComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(pantalla.getText() + ",");
            }
        });

        botonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacionActual = botonMas.getText().toString().charAt(0);
                allCalculations();
                pantalla.setText(decimalFormat.format(firstValue)+ "+");
                resultadoPantalla.setText("");
            }
        });
        botonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacionActual = botonMenos.getText().toString().charAt(0);
                allCalculations();
                pantalla.setText(decimalFormat.format(firstValue)+ "-");
                resultadoPantalla.setText("");
            }
        });
        botonPor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacionActual = botonPor.getText().toString().charAt(0);
                allCalculations();
                pantalla.setText(decimalFormat.format(firstValue)+ "*");
                resultadoPantalla.setText("");
            }
        });
        botonEntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacionActual = botonEntre.getText().toString().charAt(0);
                allCalculations();
                pantalla.setText(decimalFormat.format(firstValue)+ "/");
                resultadoPantalla.setText("");
            }
        });

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                resultadoPantalla.setText(decimalFormat.format(resultValue));
                firstValue = Double.NaN;
                operacionActual= 'a';
            }
        });


    }

    public void allCalculations() {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble((pantalla.getText().toString()));

            if (operacionActual == botonMas.getText().toString().charAt(0)) {
                resultValue = this.firstValue + secondValue;
            } else if (operacionActual == botonMenos.getText().toString().charAt(0)) {
                resultValue = this.firstValue - secondValue;
            } else if (operacionActual == botonPor.getText().toString().charAt(0)) {
                resultValue = this.firstValue * secondValue;
            } else if (operacionActual == botonEntre.getText().toString().charAt(0)) {
                resultValue = this.firstValue / secondValue;
            } else if (operacionActual == botonPorcentaje.getText().toString().charAt(0)) {
                resultValue = this.firstValue % secondValue;
            }
        }else{
            try{
                firstValue = Double.parseDouble(pantalla.getText().toString());
            }catch (Exception e){
                Toast toast = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
            }
        }
    }
}
