package logica;


public class Menu
{
    private int cantidadMinimaComensales;
    private String comentarios;
    private String detalleDeMenu[];
    private String fechaCreacion;
    private String fechaVigencia;
    private String foto;
    private String nombre;
    private long precio;

    public Menu(int cantidadMinimaComensales, String comentarios, String[] detalleDeMenu, String fechaCreacion, String fechaVigencia, String foto, String nombre, long precio) {
        this.cantidadMinimaComensales = cantidadMinimaComensales;
        this.comentarios = comentarios;
        this.detalleDeMenu = detalleDeMenu;
        this.fechaCreacion = fechaCreacion;
        this.fechaVigencia = fechaVigencia;
        this.foto = foto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }


}


