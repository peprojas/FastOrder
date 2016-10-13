package fastorder.data;

import android.util.Log;

/**
 * Created by joserojas on 20/9/16.
 */
public class Configuraciones {

    private String server;
    private String namespace;
    private String metodo;
    private String urn;

    //private String estado;
    //private String hora;


   /* String NAMESPACE = "AndroidController";
    String URL = "http://michelaobstetricia.com/sis_clinica/index.php/android/quote.lz?ws=1";
    String METHOD_NAME = "loginAndroid";
    String SOAP_ACTION = "urn:AndroidControllerwsdl#loginAndroid";*/


    public Configuraciones(){
        super();

    }

    public String getServer() {
        return server;
    }
    public void setServer(String server) {
        this.server = server;
    }

    public String getNamespace() {
        return namespace;
    }
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getMetodo() {
        return metodo;
    }
    public void setMetodo (String metodo) {
        this.metodo = metodo;
    }


    public String getUrn() {
        return urn;
    }
    public void setUrn(String urn) {
        this.urn = urn;
    }


  public boolean  cargarConfiguración(String metodo){

      try {

          setServer("http://192.168.43.224/sis_helado/index.php/android/quote?ws=1");
          setNamespace("AndroidController");
          setMetodo(metodo);
          setUrn("urn:AndroidControllerwsdl#".concat(metodo));


            return true;
      }
      catch(Exception e)
      {
          Log.d(e.toString(), "Error al cargar configuración");
      return false;

      }
  }






}


