package logica;

public class Estado
{
    private String ambito;
    private String nombre;

    public Estado(String ambito, String nombre)
    {
        this.ambito = ambito;
        this.nombre = nombre;
    }

    public boolean esAbierta()
    {
        return this.nombre.equals("Abierta");
    }


    public boolean esAbierto()
    {
        return this.nombre.equals("Abierto");
    }


    public boolean esActiva()
    {
        return this.nombre.equals("Activa");
    }


    public boolean esAmbitoDetallePedido()
    {
        return this.ambito.equals("Detalle Pedido");
    }


    public boolean esAmbitoMesa()
    {
        return this.ambito.equals("Mesa");
    }


    public boolean esAmbitoPedido()
    {
        return this.ambito.equals("Pedido");
    }


    public boolean esAmbitoReserva()
    {
        return this.ambito.equals("Reserva");
    }


    public boolean esConfirmada()
    {
        return this.nombre.equals("Confirmada");
    }


    public boolean esConPedGenerado()
    {
        return this.nombre.equals("Con pedido generado");
    }


    public boolean esCreada()
    {
        return this.nombre.equals("Creada");
    }


    public boolean esCreado()
    {
        return this.nombre.equals("Creado");
    }


    public boolean esEnPreparacion()
    {
        return this.nombre.equals("En preparacion");
    }


    public boolean esListoParaServir()
    {
        return this.nombre.equals("Listo para servir");
    }


    public boolean esNotificada()
    {
        return this.nombre.equals("Notificada");
    }


    public boolean esNotificado()
    {
        return this.nombre.equals("Notificado");
    }


    public boolean esPendienteCumplimentar()
    {
        return this.nombre.equals("Pendiente de cumplimentar");
    }


    public boolean esPendPrep()
    {
        return this.nombre.equals("Pendiente de preparacion");
    }

    @Override
    public boolean equals(Object o)
    {
        Estado e = (Estado)o;
        return e.nombre.equals(this.nombre) && e.ambito.equals(this.ambito);
    }
}
