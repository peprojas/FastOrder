package com.lizardapp.android.fastorder;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private static final int AUTO_HIDE_DELAY_MILLIS = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

       // SetearPreferencias();
  if (ObtenerPreferecias()){

      Intent pintent = new Intent(MainActivity.this,principalActivity.class);
      startActivity(pintent);

  }

        else{
      new android.os.Handler().postDelayed(new Runnable() {
          public void run() {
              // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
              Intent intent = new Intent(MainActivity.this,LoginActivity.class);
              startActivity(intent);
              finish();
          }

          ;
      }, AUTO_HIDE_DELAY_MILLIS);


  }
    }



    public boolean ObtenerPreferecias()  {

        SharedPreferences misPreferencias = getSharedPreferences("PreferenciasUsuarios", Context.MODE_PRIVATE);

       return misPreferencias.getBoolean("cheked",false);
    }



}
