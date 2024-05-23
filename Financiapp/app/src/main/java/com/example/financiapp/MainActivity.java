package com.example.financiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));

        WebView webView = findViewById(R.id.webViewEuribor);
        webView.setBackgroundColor(Color.TRANSPARENT);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);


        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        webView.setWebViewClient(new WebViewClient());

        String iframeContent = "<html><head>" +
                "<style>" +
                "body, html { margin: 0; padding: 0; height: 100%; width: 100%; }" +
                ".iframe-container { position: relative; width: 100%; height: 100%; }" +
                ".iframe-container iframe { position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: 0; }" +
                "</style>" +
                "</head><body>" +
                "<div class='iframe-container'>" +
                "<iframe id='ep-chart-0dabdc87-35a6-4fae-b358-5cd461332321' src='https://embed.epdata.es/representacion/0dabdc87-35a6-4fae-b358-5cd461332321/450' " +
                "style='width: 100%; min-height: 450px; overflow: hidden;' frameborder='0' scrolling='no' height='450'></iframe>" +
                "</div>" +
                "</body></html>";

        webView.loadData(iframeContent, "text/html", "UTF-8");

        ImageView buttoniVei = findViewById(R.id.iVei);
        buttoniVei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Enlaces de Interés",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityEI.class);
                startActivity(intent);
            }
        });

        TextView tVei = findViewById(R.id.tVei);
        tVei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Enlaces de Interés",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityEI.class);
                startActivity(intent);
            }
        });

        ImageView buttoniVdoc = findViewById(R.id.iVdoc);
        buttoniVdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Documentación a Presentar",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityDOC.class);
                startActivity(intent);
            }
        });

        TextView tVdp = findViewById(R.id.tVdp);
        tVdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Documentación a Presentar",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityDOC.class);
                startActivity(intent);
            }
        });

        ImageView buttoniVsim = findViewById(R.id.iVsim);
        buttoniVsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Simulador",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivitySIM.class);
                startActivity(intent);
            }
        });

        TextView tVs = findViewById(R.id.tVs);
        tVs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Simulador",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivitySIM.class);
                startActivity(intent);
            }
        });

        ImageView buttoniVce = findViewById(R.id.iVce);
        buttoniVce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Cálculo Endeudamiento",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityCE.class);
                startActivity(intent);
            }
        });

        TextView tVce = findViewById(R.id.tVce);
        tVce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Cálculo Endeudamiento",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityCE.class);
                startActivity(intent);
            }
        });

        ImageView buttoniVqds = findViewById(R.id.iVqds);
        buttoniVqds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"¿Qué Debes Saber?",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityQDS.class);
                startActivity(intent);
            }
        });
        TextView tVqds = findViewById(R.id.tVqds);
        tVqds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"¿Qué Debes Saber?",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityQDS.class);
                startActivity(intent);
            }
        });
    }
}