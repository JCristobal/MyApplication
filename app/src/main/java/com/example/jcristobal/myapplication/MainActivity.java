package com.example.jcristobal.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz
        final Button boton = (Button)findViewById(R.id.button);

        //Implementamos el evento “click” del botón
        boton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {   //http://www.sgoliver.net/blog/desarrollando-una-aplicacion-android-sencilla/
                Intent intent =
                        new Intent(MainActivity.this, saludo.class);

                startActivity(intent);
            }
        });


        final Button boton_tabs = (Button)findViewById(R.id.button_tabs);
        boton_tabs.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(MainActivity.this, tabs.class);

                startActivity(intent);
            }
        });

        final Button boton_tabs_deslizantes = (Button)findViewById(R.id.button_tabs_desl);
        boton_tabs_deslizantes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(MainActivity.this, CrearTabsSwipe.class);

                startActivity(intent);
            }
        });



        // Botón de salida (final de la aplicación)
        final Button boton_salida = (Button)findViewById(R.id.exit_button);
        boton_salida.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_exit) {
            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    }
