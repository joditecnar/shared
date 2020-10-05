package com.example.informatica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private EditText editTextNombre1, editTextTelefono2, editTextCorreo3, editTextEdad4;
    private Button Guardar1, verAgenda2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre1 =(EditText)findViewById(R.id.editTextNombre);
        editTextTelefono2 =(EditText)findViewById(R.id.editTextTelefono);
        editTextCorreo3 =(EditText)findViewById(R.id.editTextCorreo);
        editTextEdad4 =(EditText)findViewById(R.id.editTextEdad);
        Guardar1 =(Button)findViewById(R.id.Guardar);
        verAgenda2 =(Button)findViewById(R.id.Agenda);

        Guardar1.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                SharedPreferences Datos = getSharedPreferences("Agenda", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Datos.edit();

                editor.putString("Nombre", editTextNombre1.getText().toString());
                editor.putString("Telefono", editTextTelefono2.getText().toString());
                editor.putString("Correo", editTextCorreo3.getText().toString());
                editor.putString("Edad", editTextEdad4.getText().toString());

                editor.apply();
                Toast.makeText(MainActivity.this, "Datos guardados en agenda", Toast.LENGTH_LONG).show();

                editTextNombre1.getText().clear();
                editTextTelefono2.getText().clear();
                editTextCorreo3.getText().clear();
                editTextEdad4.getText().clear();
            }
        });

        verAgenda2.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(MainActivity.this, verAgenda.class);

                siguiente.putExtra("Nombre", editTextNombre1.getText().toString());
                siguiente.putExtra("Telefono", editTextTelefono2.getText().toString());
                siguiente.putExtra("Correo", editTextCorreo3.getText().toString());
                siguiente.putExtra("Edad", editTextEdad4.getText().toString());

                startActivity(siguiente);

                Toast.makeText(MainActivity.this, "Ultimo registro", Toast.LENGTH_LONG).show();


               /* SharedPreferences Datos = getSharedPreferences("Agenda", Context.MODE_PRIVATE);

                editTextNombre1.setText(Datos.getString("Nombre", ""));
                editTextTelefono2.setText(Datos.getString("Telefono", ""));
                editTextCorreo3.setText(Datos.getString("Correo", ""));
                editTextEdad4.setText(Datos.getString("Edad", ""));

                if (editTextNombre1.length() == 0){
                    Toast.makeText(MainActivity.this, "Sin datos", Toast.LENGTH_LONG).show();

                }*/

            }
        });

    }
}
