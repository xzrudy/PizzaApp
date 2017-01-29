package com.example.pizza.pizzaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class checkout extends AppCompatActivity {

    Button btnBack, btnConfirmar;
    TextView textView, textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);

        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);

        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);

        textView3.setText(getIntent().getStringExtra("idUser"));
        textView5.setText(getIntent().getStringExtra("ingredientes"));
        textView7.setText(getIntent().getStringExtra("size"));
        textView9.setText(getIntent().getStringExtra("cantidad"));
        textView11.setText(getIntent().getStringExtra("direccion"));
        textView13.setText(getIntent().getStringExtra("pago"));
        textView15.setText("$ " + getIntent().getStringExtra("total"));


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(checkout.this, home.class);

                toHome.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toHome.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));
                toHome.putExtra("ingredientes", getIntent().getStringExtra("ingredientes"));

                startActivity(toHome);
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPizzaSelect = new Intent(checkout.this, pizzaSelect.class);

                toPizzaSelect.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toPizzaSelect.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));

                Calendar c = Calendar.getInstance();
                System.out.println("Current time => "+c.getTime());

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = df.format(c.getTime());

                SQLiteDatabase pizzaDB = openOrCreateDatabase("pizzaDB", MODE_PRIVATE, null);

                pizzaDB.execSQL("INSERT INTO Ventas (idUser, ingredientes, size, cantidad, direccion, tipoPago, total, fechaVenta) " +
                        "VALUES ('" + getIntent().getStringExtra("idUser") + "', " +
                        "'" + getIntent().getStringExtra("ingredientes") + "', " +
                        "'" + getIntent().getStringExtra("size") + "', " +
                        "'" + getIntent().getStringExtra("cantidad") +"', " +
                        "'" + getIntent().getStringExtra("direccion") + "', " +
                        "'" + getIntent().getStringExtra("pago") +"', " +
                        "'" + getIntent().getStringExtra("total") +"', " +
                        "'" + df.format(c.getTime()) + "');");

                Toast toast = Toast.makeText(getApplicationContext(), "Pedido realizado", Toast.LENGTH_LONG);
                toast.show();

                startActivity(toPizzaSelect);
            }
        });

    }
}
