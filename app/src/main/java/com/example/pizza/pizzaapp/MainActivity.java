package com.example.pizza.pizzaapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeListener;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText editTextUser, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        SQLiteDatabase pizzaDB = openOrCreateDatabase("pizzaDB", MODE_PRIVATE, null);

        pizzaDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Ventas (idVenta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idUSer NVARCHAR, " +
                "ingredientes NVARCHAR, " +
                "size NVARCHAR, " +
                "cantidad NVARCHAR, " +
                "direccion NVARCHAR, " +
                "tipoPago NVARCHAR, " +
                "total NVARCHAR, " +
                "fechaVenta NVARCHAR);");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toPizzaSelect = new Intent(MainActivity.this, pizzaSelect.class);

                toPizzaSelect.putExtra("idUser", editTextUser.getText().toString());

                if (editTextUser.length() != 0 && editTextPassword.length() != 0) {
                    if (editTextUser.getText().toString().equals("admin")) {
                        toPizzaSelect.putExtra("isAdmin", "SI");
                        startActivity(toPizzaSelect); //Muestra la siguiente vista
                    }
                    else {
                        toPizzaSelect.putExtra("isAdmin", "NO");
                        startActivity(toPizzaSelect); //Muestra la siguiente vista
                    }
                }
                else if (editTextUser.length() == 0 && editTextPassword.length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Los campos se encuentran vacíos", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (editTextUser.length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "El campo Usuario no puede ir vacío", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (editTextPassword.length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "El campo Contraseña no puede ir vacío", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}