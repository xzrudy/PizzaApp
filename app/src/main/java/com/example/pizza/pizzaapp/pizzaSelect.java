package com.example.pizza.pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class pizzaSelect extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_select);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);

        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        String text1 = "Bienvenido " + getIntent().getStringExtra("idUser");
        textView1.setText(text1);

        if (getIntent().getStringExtra("isAdmin").equals("SI")) {
            button2.setVisibility(View.VISIBLE);
        }
        else if (getIntent().getStringExtra("isAdmin").equals("NO")) {
            button2.setVisibility(View.GONE);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(pizzaSelect.this, MainActivity.class);

                Toast toast = Toast.makeText(getApplicationContext(), "El usuario " + getIntent().getStringExtra("idUser") + " ha cerrado sesión.", Toast.LENGTH_LONG);
                toast.show();

                startActivity(toHome);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toVentas = new Intent(pizzaSelect.this, ventas.class);

                toVentas.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toVentas.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));

                startActivity(toVentas);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(pizzaSelect.this, home.class);

                toHome.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toHome.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));
                toHome.putExtra("ingredientes", "Carnes frías");

                startActivity(toHome);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(pizzaSelect.this, home.class);

                toHome.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toHome.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));
                toHome.putExtra("ingredientes", "Champiñones");

                startActivity(toHome);
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(pizzaSelect.this, home.class);

                toHome.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toHome.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));
                toHome.putExtra("ingredientes", "Hawaiana");

                startActivity(toHome);
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(pizzaSelect.this, home.class);

                toHome.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toHome.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));
                toHome.putExtra("ingredientes", "Pepperoni");

                startActivity(toHome);
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(pizzaSelect.this, home.class);

                toHome.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toHome.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));
                toHome.putExtra("ingredientes", "Tres quesos");

                startActivity(toHome);
            }
        });
    }
}