package logica;

import java.util.Date;

public class DetalleDePedido
{
    private int cantidad;
    private String detFactura;
    private HistorialEstado historialEstado;
    private Date hora;
    private Menu menu;
    private double precio;
    private String producto;
    private float tiempo;
    private Pedido pedido;
    private ProductoDeCarta productoDeCarta;



    public DetalleDePedido(int cantidad, String detFactura, HistorialEstado historialEstado, Date hora, Menu menu, double precio, String producto, float tiempo, Pedido pedido, ProductoDeCarta productoDeCarta) {
        this.cantidad = cantidad;
        this.detFactura = detFactura;
        this.historialEstado = historialEstado;
        this.hora = hora;
        this.menu = menu;
        this.precio = precio;
        this.producto = producto;
        this.tiempo = tiempo;
        this.pedido = pedido;
        this.productoDeCarta = productoDeCarta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public ProductoDeCarta getProductoDeCarta() {
        return productoDeCarta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getDetFactura() {
        return detFactura;
    }

    public HistorialEstado getHistorialEstado() {
        return historialEstado;
    }

    public Date getHora() {
        return hora;
    }

    public Menu getMenu() {
        return menu;
    }

    public double getPrecio() {
        return precio;
    }

    public String getProducto() {
        return producto;
    }

    public float getTiempo() {
        return tiempo;
    }

    public boolean estaEnPreparacion(){
        if(obtenerUltimoEstado()){
            return true;
        }
        return false;
    }

    private boolean obtenerUltimoEstado() {
        if(historialEstado.esEnPreparacion()){
            return true;
        }
        return false;
    }

    private String mostrarNombreProducto(){
        return productoDeCarta.mostrarProductos();
    }

    private String mostrarNombreMenu(){
        return menu.getNombre();
    }
    private int mostrarMesa(){
        return pedido.mostrarMesa();
    }
}
