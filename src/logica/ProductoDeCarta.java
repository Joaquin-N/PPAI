package logica;

public class ProductoDeCarta
{

    private boolean esFavorito;
    private long precio;
    private Producto producto;

    public ProductoDeCarta(boolean esFavorito, long precio, Producto producto) {
        this.esFavorito = esFavorito;
        this.precio = precio;
        this.producto = producto;
    }


    public Producto getProducto() {
        return producto;
    }

    public String mostrarProductos(){

        return producto.getNombre();
    }
}
