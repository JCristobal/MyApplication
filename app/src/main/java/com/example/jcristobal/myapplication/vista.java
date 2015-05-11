package com.example.jcristobal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import static android.webkit.WebSettings.ZoomDensity.*;


/**
 * Created by JCristobal on 18/03/2015.
 */

public class vista extends Activity {

    private ProgressBar progressBar; // Para la barra de proceso

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_main);


        /*final WebView web = (WebView)findViewById(R.id.webView);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 =
                        new Intent(vista.this, MainActivity.class);
                startActivity(intent5);

            }
        });*/

        // Botón hacia actividad anterior
        final Button boton = (Button)findViewById(R.id.button3);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =
                        new Intent(vista.this, saludo.class);
                startActivity(intent4);
            }
        });

        // Trabajamos con WebView
        //String URL = "http://jcristobal.github.io/learnUSAstates/index.html";
        String URL = "http://series.ly/index.php";
        WebView webview;
        webview = (WebView)findViewById(R.id.webView);

        // Para que sólo se vea en el webview: si no añadimos ésto abrirá una pestaña del navegador con la URL
        webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }});

        webview.getSettings().setJavaScriptEnabled(true);    // Permitimos que se ejecute JavaScript
        webview.getSettings().setLoadWithOverviewMode(true); // Ajustamos la vista para que no se vea demasiado grande
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setBuiltInZoomControls(true);  // habilitamos el zoom
        //webview.setInitialScale(100);   // podemos también ajusar el zoom a un valor fijo
        webview.loadUrl(URL);


        // Para la barra de proceso
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        webview.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int progress)
            {
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);
                vista.this.setProgress(progress * 1000);

                progressBar.incrementProgressBy(progress);

                if(progress == 100)
                {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }


}
