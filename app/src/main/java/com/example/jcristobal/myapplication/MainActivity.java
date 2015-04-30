package com.example.jcristobal.myapplication;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


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

        final Button boton_alert = (Button)findViewById(R.id.button_alerta);
        boton_alert.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // Creamos la notificación
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(android.R.drawable.ic_dialog_info)  // icono pequeño (se queda en barra superior)
                                .setLargeIcon((((BitmapDrawable)getResources()
                                        .getDrawable(R.drawable.gitmark)).getBitmap())) // icono grande (a la derecha)
                                .setContentTitle("Mensaje de Alerta")
                                .setContentText("Ejemplo de notificación.")
                                //.setContentInfo("4")
                                .setTicker("Alerta!")  // si tiene espacio mostrará este texto junto al icono pequeño
                                .setWhen(System.currentTimeMillis()+10000);
                                int NOTIF_ALERTA_ID = 0;

                // Actividad a la que se dirige si pulsa la alerta
                Intent notIntent =
                        new Intent(MainActivity.this, MainActivity.class);
                PendingIntent contIntent =
                        PendingIntent.getActivity(
                                MainActivity.this, 0, notIntent, 0);
                mBuilder.setContentIntent(contIntent);

                // Generamos la notificación
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());

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
            //Toast toast1 = Toast.makeText(getApplicationContext(), "Visita JCristobal en GitHub", Toast.LENGTH_SHORT);
            //toast1.show();
            Toast toast_personalizado = new Toast(getApplicationContext());

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.lytLayout));

            TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
            txtMsg.setText("Visita JCristobal en GitHub");

            toast_personalizado.setDuration(Toast.LENGTH_SHORT);
            toast_personalizado.setView(layout);
            toast_personalizado.show();
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
