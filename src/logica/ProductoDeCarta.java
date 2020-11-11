package logica;

public class ProductoDeCarta
{
    private String nombre;
    private Producto producto;

    public ProductoDeCarta(Producto producto)
    {
        this.producto = producto;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Producto getProducto()
    {
        return producto;
    }

    public void setProducto(Producto producto)
    {
        this.producto = producto;
    }

    public String mostrarProducto()
    {
        return producto.getNombre();
    }
}
