import logica.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDatos
{
    public List<Estado> generarEstados()
    {
        List<Estado> estados = new ArrayList<>();

        estados.add(new Estado("Detalle Pedido", "En preparacion"));
        estados.add(new Estado("Detalle Pedido", "Notificado"));
        estados.add(new Estado("Detalle Pedido", "Listo para servir"));

        return estados;
    }

    public List<DetalleDePedido> generarDetallesPedido()
    {
        List<DetalleDePedido> detalles = new ArrayList<>();

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(7)),
                null,
                new ProductoDeCarta(new Producto("Milanesa")),
                3,
                LocalTime.of(9,0)
                ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(5)),
                new Menu("Continental"),
                null,
                2,
                LocalTime.of(9,15)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(2)),
                new Menu("Americano"),
                null,
                4,
                LocalTime.of(9,20)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(6)),
                new Menu("Pizza"),
                null,
                1,
                LocalTime.of(8,55)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(3)),
                new Menu("Papas Fritas"),
                null,
                3,
                LocalTime.of(9,10)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(11)),
                new Menu("Parrillada"),
                null,
                1,
                LocalTime.of(9,15)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(1)),
                null,
                new ProductoDeCarta(new Producto("Hamburguesa")),
                3,
                LocalTime.of(9,15)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(1)),
                null,
                new ProductoDeCarta(new Producto("Sushi")),
                2,
                LocalTime.of(9,12)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(2)),
                new Menu("Continental"),
                null,
                2,
                LocalTime.of(9,25)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(6)),
                null,
                new ProductoDeCarta(new Producto("Empanadas")),
                6,
                LocalTime.of(9,20)
        ));

        return detalles;
    }
}
