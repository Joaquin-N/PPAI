package logica;

public class Producto
{

    private String fechaCreacion;
    private String foto;
    private String nombre;
    private long precio;
    private String receta;
    private String sectorComanda;
    private String tiempoPresen;

    public Producto(String fechaCreacion, String foto, String nombre, long precio, String receta, String sectorComanda, String tiempoPresen) {
        this.fechaCreacion = fechaCreacion;
        this.foto = foto;
        this.nombre = nombre;
        this.precio = precio;
        this.receta = receta;
        this.sectorComanda = sectorComanda;
        this.tiempoPresen = tiempoPresen;
    }


    public String getNombre() {
        return nombre;
    }
}
