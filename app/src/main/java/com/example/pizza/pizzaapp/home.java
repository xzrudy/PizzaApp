package com.example.pizza.pizzaapp;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    Button btnRegresar, btnPedido;
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    EditText editTextDireccion;

    NumberPicker numberPicker1;

    Spinner spinnerSize, spinnerPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnPedido = (Button) findViewById(R.id.btnPedido);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);

        editTextDireccion = (EditText) findViewById(R.id.editTextDireccion);

        numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);

        spinnerSize = (Spinner) findViewById(R.id.spinnerSize);
        spinnerPago = (Spinner) findViewById(R.id.spinnerPago);

        //NUMBER PICKER MAX Y MIN.
        numberPicker1.setMinValue(1);
        numberPicker1.setMaxValue(12);

        // ARREGLO DE TAMAÑOS DE PIZZA
        ArrayList<String> spinnerArraySize =  new ArrayList<String>();
        spinnerArraySize.add("Pequeña");
        spinnerArraySize.add("Mediana");
        spinnerArraySize.add("Grande");
        spinnerArraySize.add("Familiar");

        ArrayAdapter<String> adapterSize = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArraySize);

        spinnerSize.setAdapter(adapterSize);

        // ARREGLO DE TIPOS DE PAGO
        ArrayList<String> spinnerArrayPago =  new ArrayList<String>();
        spinnerArrayPago.add("Tarjeta de débito");
        spinnerArrayPago.add("Tarjeta de crédito");
        spinnerArrayPago.add("Google pay");
        spinnerArrayPago.add("Paypal");

        ArrayAdapter<String> adapterPago = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArrayPago);

        spinnerPago.setAdapter(adapterPago);

        String text1 = "Bienvenido " + getIntent().getStringExtra("idUser");
        textView1.setText(text1);

        String text4 = "Ingredientes de Pizza " + getIntent().getStringExtra("ingredientes") + ":";
        textView4.setText(text4);

        if (getIntent().getStringExtra("ingredientes").equals("Carnes frías")) {
            String text8 =
                    "\u2022 Jamón \n" +
                    "\u2022 Tocino \n" +
                    "\u2022 Salchica de pavo \n" +
                    "\u2022 Salami \n" +
                    "\u2022 Aceitunas verdes";

            textView8.setText(text8);
        }
        else  if (getIntent().getStringExtra("ingredientes").equals("Champiñones")) {
            String text8 =
                    "\u2022 Champiñones \n" +
                            "\u2022 Jamon de pavo \n" +
                            "\u2022 Aceitunas";

            textView8.setText(text8);
        }
        else  if (getIntent().getStringExtra("ingredientes").equals("Hawaiana")) {
            String text8 =
                    "\u2022 Jamon \n" +
                    "\u2022 Piña";

            textView8.setText(text8);
        }
        else  if (getIntent().getStringExtra("ingredientes").equals("Pepperoni")) {
            String text8 =
                    "\u2022 Pepperoni \n" +
                            "\u2022 Chile rojo triturado";

            textView8.setText(text8);
        }
        else  if (getIntent().getStringExtra("ingredientes").equals("Tres quesos")) {
            String text8 =
                    "\u2022 Queso manchego \n" +
                    "\u2022 Queso mozzarella  \n" +
                    "\u2022 Queso parmesano";

            textView8.setText(text8);
        }
        else {
            Toast toast1 = Toast.makeText(getApplicationContext(), "NO INGREDIENTES", Toast.LENGTH_LONG);
            toast1.show();
        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPizzaSelect = new Intent(home.this, pizzaSelect.class);

                toPizzaSelect.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toPizzaSelect.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));

                startActivity(toPizzaSelect);
            }
        });

        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toCheckout = new Intent(home.this, checkout.class);

                if (editTextDireccion.length() != 0) {
                    toCheckout.putExtra("idUser", getIntent().getStringExtra("idUser"));
                    toCheckout.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));
                    toCheckout.putExtra("ingredientes", getIntent().getStringExtra("ingredientes"));
                    toCheckout.putExtra("size", spinnerSize.getSelectedItem().toString());
                    toCheckout.putExtra("cantidad", String.valueOf(numberPicker1.getValue()));
                    toCheckout.putExtra("direccion", editTextDireccion.getText().toString());
                    toCheckout.putExtra("pago", spinnerPago.getSelectedItem().toString());

                    String total = calculaTotal(getIntent().getStringExtra("ingredientes"), spinnerSize.getSelectedItem().toString(), String.valueOf(numberPicker1.getValue()));

                    toCheckout.putExtra("total", total);

                    startActivity(toCheckout);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "El campo Dirección se encuentra vacío", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    public String calculaTotal(String ingrediente, String size, String cantidad) {

        Double size1 = 70.0;
        Double size2 = 90.0;
        Double size3 = 110.0;
        Double size4 = 145.0;

        Double total = 0.0;

        Double _cantidad = Double.parseDouble(cantidad);

        if (size.equals("Pequeña")) {
            total = _cantidad * size1;
        }
        else if (size.equals("Mediana")) {
            total = _cantidad * size2;
        }
        else if (size.equals("Grande")) {
            total = _cantidad * size3;
        }
        else if (size.equals("Familiar")) {
            total = _cantidad * size4;
        }

            return total.toString();

    }

}