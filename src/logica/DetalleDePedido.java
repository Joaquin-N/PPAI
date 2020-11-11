package logica;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class DetalleDePedido
{
    private int cantidad;
    private LocalTime hora;
    private Menu menu;
    private Pedido pedido;
    private ProductoDeCarta productoDeCarta;
    private ArrayList<HistorialEstado> historialEstados = new ArrayList<>();

    private HistorialEstado ultimoHistorial;

    public DetalleDePedido(Pedido pedido, Menu menu, ProductoDeCarta productoDeCarta, int cantidad, LocalTime hora)
    {
        historialEstados.add(new HistorialEstado(new Estado("Detalle Pedido", "En preparacion"), LocalDateTime.now()));
        this.hora = hora;
        this.menu = menu;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.productoDeCarta = productoDeCarta;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public LocalTime getHora()
    {
        return hora;
    }

    public ProductoDeCarta getProductoDeCarta() {
        return productoDeCarta;
    }

    public String mostrarNombreProducto(){
        return productoDeCarta.mostrarProducto();
    }

    public String mostrarNombreMenu(){
        return menu.getNombre();
    }

    public int mostrarMesa(){
        return pedido.mostrarMesa();
    }


    public boolean estaEnPreparacion(Estado estado)
    {
        ultimoHistorial = obtenerUltimoEstado();
        return ultimoHistorial.esEnPreparacion(estado);
    }

    public HistorialEstado obtenerUltimoEstado()
    {
        for (HistorialEstado hist: historialEstados)
            if(hist.esUltimoHistorial()) return hist;
        return null;
    }

    public void finalizar(Estado estado)
    {
        setearFinUltimoHistorial();
        crearHistorial(estado);
    }

    public void notificar(Estado estado)
    {
        setearFinUltimoHistorial();
        crearHistorial(estado);
    }

    private void setearFinUltimoHistorial()
    {
        ultimoHistorial.setFechaHoraFin(LocalDateTime.now());
    }

    private void crearHistorial(Estado estado)
    {
        ultimoHistorial = new HistorialEstado(estado, LocalDateTime.now());
        historialEstados.add(ultimoHistorial);
    }


//    public static DetalleDePedido[] generarDetalles()
//    {
//        return new DetalleDePedido[] {
//                new DetalleDePedido("Fideos", "Continental", 1, 6, "Ruben Gonzales", "6", 12, 15, "00:25"),
//                new DetalleDePedido("Ensalada", "Especial", 2, 2, "Andrea Fernandez", "2", 12, 10, "00:20"),
//                new DetalleDePedido("Tiramisú", "Postres", 2, 1, "Juan Perez", "1", 12, 15, "00:15"),
//                new DetalleDePedido("Milanesa", "Infantil", 3, 5, "Juan Perez", "5", 12, 0, "00:12"),
//                new DetalleDePedido("Pure", "Infantil", 3, 5, "Juan Perez", "5", 12, 0, "00:12"),
//    };
//    }
//
//    public static DetalleDePedido[] generarDetalles2()
//    {
//        return new DetalleDePedido[] {
//                new DetalleDePedido("Milanesa", "Infantil", 6, 5, "Juan Perez", "5", 12, 0, "00:12"),
//                new DetalleDePedido("Pritty", "Bebidas", 2, 1, "Juan Perez", "1", 12, 15, "00:15"),
//        };
//    }
//
//    public static DetalleDePedido[] generarDetalles3()
//    {
//        return new DetalleDePedido[] {
//                new DetalleDePedido("Fideos", "Continental", 1, 6, "Ruben Gonzales", "6", 12, 15, "00:25"),
//                new DetalleDePedido("Ensalada", "Especial", 2, 2, "Andrea Fernandez", "2", 12, 10, "00:20"),
//                new DetalleDePedido("Pritty", "Bebidas", 2, 1, "Juan Perez", "1", 12, 15, "00:15"),
//                new DetalleDePedido("Milanesa", "Infantil", 6, 5, "Juan Perez", "5", 12, 0, "00:12"),
//        };
//    }
}
