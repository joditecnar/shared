package com.example.informatica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class verAgenda extends AppCompatActivity {

    private ImageButton buttonSiguiente;
    private TextView textView1, textView2, textView3, textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_agenda);

        buttonSiguiente =(ImageButton)findViewById(R.id.imageButton);
        textView1 = (TextView)findViewById(R.id.textViewPage1);
        textView2 =(TextView)findViewById(R.id.textViewPage2);
        textView3 =(TextView)findViewById(R.id.textViewPage3);
        textView4 =(TextView)findViewById(R.id.textViewPage4);

        SharedPreferences Datos = getSharedPreferences("Agenda", Context.MODE_PRIVATE);
        textView1.setText(Datos.getString("Nombre", ""));
        textView2.setText(Datos.getString("Telefono", ""));
        textView3.setText(Datos.getString("Correo", ""));
        textView4.setText(Datos.getString("Edad", ""));

        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anterior = new Intent(verAgenda.this, MainActivity.class);
                startActivity(anterior);

                Toast.makeText(verAgenda.this, "Pagina principal", Toast.LENGTH_LONG).show();

            }
        });

    }
}
