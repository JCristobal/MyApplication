package com.example.jcristobal.myapplication;

/**
 * Created by JCristobal on 17/03/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class saludo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saludo_main);

        //Obtenemos una referencia a los controles de la interfaz
        final Button boton2 = (Button)findViewById(R.id.button2);

        //Implementamos el evento “click” del botón
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =
                        new Intent(saludo.this, MainActivity.class);

                startActivity(intent2);
            }
        });


        final ImageButton boton_img = (ImageButton)findViewById(R.id.imageButton);
        boton_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 =
                        new Intent(saludo.this, MainActivity.class);
                startActivity(intent3);


            }
        });



    }
}