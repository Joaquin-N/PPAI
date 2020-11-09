package logica;

public class DetalleDePedido
{
    private String producto;
    private String menu;
    private int cantidad;
    private int mesa;
    private String mozo;
    private String seccion;
    private int hora;
    private int minutos;
    private String tiempo;

    public DetalleDePedido(String producto, String menu, int cantidad, int mesa, String mozo, String seccion, int hora, int minutos, String tiempo)
    {
        this.producto = producto;
        this.menu = menu;
        this.cantidad = cantidad;
        this.mesa = mesa;
        this.mozo = mozo;
        this.seccion = seccion;
        this.hora = hora;
        this.minutos = minutos;
        this.tiempo = tiempo;
    }

    public String getProducto()
    {
        return producto;
    }
    public String getMenu()
    {
        return menu;
    }
    public int getCantidad()
    {
        return cantidad;
    }
    public int getMesa()
    {
        return mesa;
    }
    public String getMozo()
    {
        return mozo;
    }
    public String getSeccion()
    {
        return seccion;
    }
    public int getHora()
    {
        return hora;
    }
    public int getMinutos() { return minutos; }
    public String getTiempo() { return tiempo; }

    public static DetalleDePedido[] generarDetalles()
    {
        return new DetalleDePedido[] {
                new DetalleDePedido("Fideos", "Continental", 1, 6, "Ruben Gonzales", "6", 12, 15, "00:25"),
                new DetalleDePedido("Ensalada", "Especial", 2, 2, "Andrea Fernandez", "2", 12, 10, "00:20"),
                new DetalleDePedido("Tiramisú", "Postres", 2, 1, "Juan Perez", "1", 12, 15, "00:15"),
                new DetalleDePedido("Milanesa", "Infantil", 3, 5, "Juan Perez", "5", 12, 0, "00:12"),
                new DetalleDePedido("Pure", "Infantil", 3, 5, "Juan Perez", "5", 12, 0, "00:12"),
    };
    }

    public static DetalleDePedido[] generarDetalles2()
    {
        return new DetalleDePedido[] {
                new DetalleDePedido("Milanesa", "Infantil", 6, 5, "Juan Perez", "5", 12, 0, "00:12"),
                new DetalleDePedido("Pritty", "Bebidas", 2, 1, "Juan Perez", "1", 12, 15, "00:15"),
        };
    }

    public static DetalleDePedido[] generarDetalles3()
    {
        return new DetalleDePedido[] {
                new DetalleDePedido("Fideos", "Continental", 1, 6, "Ruben Gonzales", "6", 12, 15, "00:25"),
                new DetalleDePedido("Ensalada", "Especial", 2, 2, "Andrea Fernandez", "2", 12, 10, "00:20"),
                new DetalleDePedido("Pritty", "Bebidas", 2, 1, "Juan Perez", "1", 12, 15, "00:15"),
                new DetalleDePedido("Milanesa", "Infantil", 6, 5, "Juan Perez", "5", 12, 0, "00:12"),
        };
    }
}
