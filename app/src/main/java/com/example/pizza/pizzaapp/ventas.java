package com.example.pizza.pizzaapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ventas extends AppCompatActivity {

    Button button1;
    TextView textView, /*textView1,*/ textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    ListView lvVentas;
    ArrayList<VentaRow> ventaList;
    VentaRow ventaR;

    //CUSTOM LISTVIEW SOURCE: https://www.youtube.com/watch?v=8K-6gdTlGEA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        button1 = (Button) findViewById(R.id.button1);

        textView = (TextView) findViewById(R.id.textView);

        //textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);

        ventaList = new ArrayList<>();

        SQLiteDatabase pizzaDB = openOrCreateDatabase("pizzaDB", MODE_PRIVATE, null);

        Cursor resultSet = pizzaDB.rawQuery("SELECT * FROM Ventas", null);
        resultSet.moveToFirst();

        if (resultSet.getCount() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "La tabla se encuentra vacía", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            do {
                ventaR = new VentaRow(resultSet.getString(0), resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
                ventaList.add(ventaR);
            }
            while (resultSet.moveToNext());

            customRowVenta adapter = new customRowVenta(this, R.layout.list_adapter_layout, ventaList);
            lvVentas = (ListView) findViewById(R.id.listViewVentas);
            lvVentas.setAdapter(adapter);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPizzaSelect = new Intent(ventas.this, pizzaSelect.class);

                toPizzaSelect.putExtra("idUser", getIntent().getStringExtra("idUser"));
                toPizzaSelect.putExtra("isAdmin", getIntent().getStringExtra("isAdmin"));

                startActivity(toPizzaSelect);
            }
        });
    }
}