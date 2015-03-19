package com.example.jcristobal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * Created by JCristobal on 18/03/2015.
 */

public class vista extends Activity {
    private ProgressBar progressBar;
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


        String URL = "http://developer.android.com";
        WebView webview;
        webview = (WebView)findViewById(R.id.webView);

        webview.setWebViewClient(new WebViewClient() {         // Para que sólo se vea en el webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }});

        webview.getSettings().setJavaScriptEnabled(true);    // Permitimos que se ejecute JavaScript
        webview.getSettings().setLoadWithOverviewMode(true); // Ajustamos la vista para que no se vea demasiado grande
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setBuiltInZoomControls(true);  // habilitamos el zoom
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
