package com.lizardapp.android.fastorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fastorder.data.Pedidos;

/**
 * Created by joserojas on 27/9/16.
 */
public class PedidosRepository {
    private static PedidosRepository repository = new PedidosRepository();
    private HashMap<String, Pedidos> leads = new HashMap<>();

    public static PedidosRepository getInstance() {
        return repository;
    }

    private PedidosRepository() {
       //saveLead(new Pedidos("emty", "empty", "empty", "emty", "empty", "empty"));

        

    }


    private void saveLead(Pedidos lead) {
        leads.put(lead.getId(), lead);
    }

    public List<Pedidos> getLeads() {
        return new ArrayList<>(leads.values());
    }
}