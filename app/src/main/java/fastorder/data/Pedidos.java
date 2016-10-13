package fastorder.data;

/**
 * Created by joserojas on 25/9/16.
 */
public class Pedidos {

    private String id;
    private String idusuario;
    private String fecha;
    private String fechapedido;
    private String estado;
    private String comentarios;




    public Pedidos() {
        super();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;

    }

    public String getFechapedido() {
        return fechapedido;
    }
    public void setFechapedido(String fechapedido) {
        this.fechapedido = fechapedido;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios(String comentarios) {
        return this.comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
