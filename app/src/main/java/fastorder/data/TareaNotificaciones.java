package fastorder.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.lizardapp.android.fastorder.PedidosAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;


/**
 * Created by joserojas on 25/9/16.
 */
public class TareaNotificaciones extends AsyncTask<String,Integer,Boolean>  {


    String perfil;
    String res ;
    String[] matriz;

    public  void setPerfil(String perfil){
        this.perfil = perfil;
    }
    public  String getPerfil(){ return perfil; }

    public  void setRes(String res){
        this.res = res;
    }
    public  String getRes(){
        return res;
    }

    public  void setMatriz(String[] matriz){
        this.matriz = matriz;
    }
    public  String[] getMatriz(){
        return matriz;
    }


    private  Context context;
   // ListView pd;
    private  ArrayAdapter adapter;


    public TareaNotificaciones(Context context, PedidosAdapter adapter) {
        this.adapter = adapter;
      //  pd = new ListView(context);
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(String... strings) {


        Configuraciones objConfiguraciones = new Configuraciones();
        objConfiguraciones.cargarConfiguración("getPedidos");

        


        SoapObject request = new SoapObject(objConfiguraciones.getNamespace(), objConfiguraciones.getMetodo());
        request.addProperty("perfil", perfil);
       // request.addProperty("pass", mPassword);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.toString();

        HttpTransportSE transporte = new HttpTransportSE(objConfiguraciones.getServer());








        try {
            // Simulate network access.

            transporte.call(objConfiguraciones.getUrn(), envelope);
            res = envelope.getResponse().toString();

           // perfil = res;
            return true;





        } catch (Exception e) {

            Log.d("ERconexion",e.toString());
            return false;
        }


    }


    @Override
    protected void onPostExecute(final Boolean success) {

        JSONObject json=null;
        JSONArray jArray=null;



        if (success)
        {
            Log.d("ERconexion 1",res.toString());
            int count =0;
            ArrayList<Pedidos> lista = new ArrayList<Pedidos>();
            try {
                json=new JSONObject(res);
                Log.d("ERconexion 2",json.toString());

                jArray=json.getJSONArray("pedidos");
                Log.d("ERconexion 3",jArray.toString());
                Log.d("ERconexion 3","count"+jArray.length());
                count = jArray.length();


                for (int i=0; jArray != null && i<jArray.length();i++) {
                    Pedidos e = new Pedidos();
                    JSONObject object=jArray.getJSONObject(i);
                    //   Log.d("ERconexion4 ",object.toString());

                    try{
                        e.setId(object.getString("id"));
                        e.setIdusuario(object.getString("idusuario"));
                        e.setFecha(object.getString("fecha"));
                        e.setFechapedido(object.getString("fechapedido"));
                        e.setEstado(object.getString("estado"));
                        e.getComentarios(object.getString("comentarios"));

                        String fecha1 = e.getFecha();
                        Log.d("fecha",fecha1);


                        adapter.add(e);

                    }
                    catch (Exception e1){
                        Log.d("error for",e1.toString()+" "+count);

                    }
                }



            } catch (JSONException e) {
                e.printStackTrace();
                //  Log.d("ERconexion json",e.toString());
            }




            // ListView ls = (ListView)


          //  for (String tmp : datos)


            //    adapter.add(tmp);

            // Indicamos al Adapter que ha cambiado su contenido, para que actualice
            // a su vez los datos mostrados en el ListView.
            adapter.notifyDataSetChanged();




        }
}



}

