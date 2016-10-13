package fastorder.data;

import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by joserojas on 1/10/16.
 */

public class UpdateToken extends AsyncTask<String,Integer,Boolean> {


    String id;
    String  token;
    String res;




    @Override
    public Boolean doInBackground(String... strings) {


        id =  strings[0];
        token = strings[1];
        Configuraciones objetoConfig = new Configuraciones();
        objetoConfig.cargarConfiguración("putUsuarioGoogle");
        SoapObject request = new SoapObject(objetoConfig.getNamespace(), objetoConfig.getMetodo());
        request.addProperty("id", id);
        request.addProperty("idgoogle", token);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.toString();

        HttpTransportSE transporte = new HttpTransportSE(objetoConfig.getServer());

        try {
            transporte.call(objetoConfig.getUrn(),envelope);
            res = envelope.getResponse().toString();

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return false;
        }



    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }


}
