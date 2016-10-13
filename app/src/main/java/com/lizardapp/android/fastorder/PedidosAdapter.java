package com.lizardapp.android.fastorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fastorder.data.Pedidos;

/**
 * Created by joserojas on 27/9/16.
 */
public class PedidosAdapter extends ArrayAdapter<Pedidos>{


    public PedidosAdapter(Context context,  List<Pedidos> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.lista_pedidos_1,
                    parent,
                    false);
        }


        // Referencias UI.
        ImageView avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
        TextView name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView fecha  = (TextView) convertView.findViewById(R.id.fecha);
        TextView estado = (TextView) convertView.findViewById(R.id.estado);

        // Lead actual.
        Pedidos lead = getItem(position);

        // Setup.
        //Glide.with(getContext()).load(lead.getImage()).into(avatar);

        name.setText("Default");
        fecha.setText(lead.getFecha());
        estado.setText(lead.getEstado());

        return convertView;
    }
}
