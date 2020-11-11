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
                LocalTime.of(18,0)
                ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(5)),
                new Menu("Continental"),
                null,
                2,
                LocalTime.of(17,50)
        ));

        detalles.add(new DetalleDePedido(
                new Pedido(new Mesa(2)),
                new Menu("Americano"),
                null,
                4,
                LocalTime.of(18,5)
        ));

        return detalles;
    }
}
