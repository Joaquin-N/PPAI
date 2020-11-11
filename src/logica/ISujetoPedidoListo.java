package logica;

import interfaz.IObserverPedidoListo;

public interface ISujetoPedidoListo
{
    void notificar();
    void suscribir(IObserverPedidoListo[] o);
    void quitar(IObserverPedidoListo[] o);

}
