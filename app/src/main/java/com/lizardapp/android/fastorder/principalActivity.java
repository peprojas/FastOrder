package com.lizardapp.android.fastorder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import fastorder.data.Pedidos;
import fastorder.data.TareaNotificaciones;

public class principalActivity extends AppCompatActivity {

    ImageButton boton;
    TextView paramusuario;
    ListView  lsPedidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        SharedPreferences objetoPrefencias = getSharedPreferences("PreferenciasUsuarios",Context.MODE_PRIVATE);

        boton = (ImageButton) findViewById(R.id.imageButton2);

        lsPedidos =(ListView) findViewById(R.id.listView);

        paramusuario = (TextView)findViewById(R.id.textView2);

        String parametros[] =objetoPrefencias.getString("params","X|X").split("\\|");

        paramusuario.setText(parametros[3]);

        Intent intent = new Intent(this, RegistrationIntentService.class);

        intent.putExtra("iduser",parametros[1]);
        startService(intent);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(principalActivity.this,
                        android.R.layout.simple_list_item_1, new ArrayList());
        //List<Pedidos> lista = new Lis

        ArrayList<Pedidos> lista = new ArrayList<Pedidos>();



        Pedidos e = new Pedidos();

        for (int i=1; i > 2 ;i++) {

            e.setId(String.valueOf(i));
            e.setIdusuario(String.valueOf(i));
            e.setFecha("000-00-00");
            e.setFechapedido("000-00-00");
            e.setEstado("emty");
            e.getComentarios("emty");

            lista.add(e);

        }

        PedidosAdapter pedidosAdapter = new PedidosAdapter(principalActivity.this, lista);
        lsPedidos.setAdapter(pedidosAdapter);
        TareaNotificaciones tareaN = new TareaNotificaciones(this,pedidosAdapter);
        tareaN.execute(parametros[3]);







        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences objPrefence = getSharedPreferences("PreferenciasUsuarios", Context.MODE_PRIVATE);
                SharedPreferences.Editor objPreferenceEditor = objPrefence.edit();
                objPreferenceEditor.putString("params","");
                objPreferenceEditor.putBoolean("cheked",false);
                objPreferenceEditor.commit();

                Intent intent = new Intent(principalActivity.this,LoginActivity.class);
                startActivity(intent);

             //   finish();
            }
        });
    }
}
