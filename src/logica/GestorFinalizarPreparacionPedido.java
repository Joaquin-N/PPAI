package logica;

import interfaz.IObserverPedidoListo;
import interfaz.PantallaFinalizarPreparacionPedido;
import javafx.event.ActionEvent;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GestorFinalizarPreparacionPedido implements ISujetoPedidoListo
{
    private List<Estado>listaEstados = new ArrayList<>();
    private List<DetalleDePedido> listaDetallesPedidos = new ArrayList<>();
    private List<IObserverPedidoListo> observadoresSuscriptos = new ArrayList<>();

    private ArrayList<Integer> detallesPedidoSeleccionadosAServir;
    private ArrayList<DetalleDePedido> detallesPedidoEnPreparacion;
    private ArrayList<String[]> datosPedidoEnPreparacion;

    private PantallaFinalizarPreparacionPedido pantalla;
    private IObserverPedidoListo observadorMonitor;
    private IObserverPedidoListo observadorMovil;

    private DetalleDePedido detalleActual;
    private int numMesaActual;
    private int cantidadActual;

    public void setPantalla(PantallaFinalizarPreparacionPedido pantalla)
    {
        this.pantalla = pantalla;
    }

    public void setObservadorMonitor(IObserverPedidoListo observadorMonitor)
    {
        this.observadorMonitor = observadorMonitor;
    }

    public void setObservadorMovil(IObserverPedidoListo observadorMovil)
    {
        this.observadorMovil = observadorMovil;
    }

    public void setListaEstados(List<Estado> estados)
    {
        listaEstados = estados;
    }

    public void setListaDetallesPedidos(List<DetalleDePedido> detalles)
    {
        listaDetallesPedidos = detalles;
    }


    public void finalizarPedido(String metodoOrd)
    {
        detallesPedidoEnPreparacion = new ArrayList<>();
        datosPedidoEnPreparacion = new ArrayList<>();
        detallesPedidoSeleccionadosAServir = new ArrayList<>();

        buscarDetallesPedidoEnPreparacion();

        if (metodoOrd.equals("Tiempo de espera"))
            ordenarSegunMayorTiempoEspera();
        else if (metodoOrd.equals("Mesa"))
            ordenarPorMesa();

        for (DetalleDePedido det: detallesPedidoEnPreparacion)
        {
            LocalTime actual = LocalTime.now();
            String tiempo = String.valueOf(ChronoUnit.MINUTES.between(det.getHora(), actual));
            String item = buscarInfoDetallePedido(det);
            String cantidad = String.valueOf(det.getCantidad());
            String mesa = buscarMesaDetalleEnPreparacion(det);

            String[] datos = new String[]{item, cantidad, mesa, tiempo};
            datosPedidoEnPreparacion.add(datos);
            pantalla.mostrarDatosDetallePedidoEnPreparacion(datos);
        }

        pantalla.solicitarSeleccionDeUnoVariosDetalles();
    }

    private void buscarDetallesPedidoEnPreparacion()
    {
        Estado estEnPreparacion = null;
        List<Estado> estadosDetallePedido = new ArrayList<>();

        for (Estado est: listaEstados)
            if(est.esAmbitoDetallePedido())
                estadosDetallePedido.add(est);

        for (Estado est: estadosDetallePedido)
            if(est.esEnPreparacion())
            {
                estEnPreparacion = est;
                break;
            }

        for (DetalleDePedido det: listaDetallesPedidos) {
            if(det.estaEnPreparacion(estEnPreparacion)) detallesPedidoEnPreparacion.add(det);
        }
    }

    private void ordenarSegunMayorTiempoEspera() {
        LocalTime actual = LocalTime.now();
        detallesPedidoEnPreparacion.sort(new Comparator<DetalleDePedido>()
        {
            @Override
            public int compare(DetalleDePedido o1, DetalleDePedido o2)
            {
                int o1Minutes = (int) ChronoUnit.MINUTES.between(o1.getHora(), actual);
                int o2Minutes = (int) ChronoUnit.MINUTES.between(o2.getHora(), actual);
                return o2Minutes - o1Minutes;
            }
        });

    }

    private void ordenarPorMesa()
    {
        detallesPedidoEnPreparacion.sort(new Comparator<DetalleDePedido>()
        {
            @Override
            public int compare(DetalleDePedido o1, DetalleDePedido o2)
            {
                return o1.mostrarMesa() - o2.mostrarMesa();
            }
        });
    }

    private String buscarInfoDetallePedido(DetalleDePedido det)
    {
        String nombre;
        if(det.getProductoDeCarta() != null) nombre = det.mostrarNombreProducto();
        else nombre = det.mostrarNombreMenu();
        return nombre;
    }

    private String buscarMesaDetalleEnPreparacion(DetalleDePedido det)
    {
        return String.valueOf(det.mostrarMesa());
    }

    public void detallePedidoSeleccionado(int index)
    {
        if (index == -1)
            pantalla.solicitarConfirmacionElaboracionProducto();
        else
            detallesPedidoSeleccionadosAServir.add(index);
    }

    public void confirmarElaboracion()
    {
        actualizarEstadoDetallePedido();
    }

    private void actualizarEstadoDetallePedido()
    {
        Estado estListoParaServir = null;
        List<Estado> estadosDetallePedido = new ArrayList<>();

        for (Estado est: listaEstados)
            if(est.esAmbitoDetallePedido())
                estadosDetallePedido.add(est);

        for (Estado est: estadosDetallePedido)
            if(est.esListoParaServir())
            {
                estListoParaServir = est;
                break;
            }

        for (Integer index: detallesPedidoSeleccionadosAServir)
        {
            detalleActual = detallesPedidoEnPreparacion.get(index);
            cantidadActual = Integer.parseInt(datosPedidoEnPreparacion.get(index)[1]);
            numMesaActual = Integer.parseInt(datosPedidoEnPreparacion.get(index)[2]);

            detalleActual.finalizar(estListoParaServir);
            publicarDetPedidoAServir();
            actualizarEstadoNotificado();
        }
        finCasoUso();
    }

    private void publicarDetPedidoAServir()
    {
        IObserverPedidoListo[] o = {observadorMonitor, observadorMovil};
        suscribir(o);
        notificar();
    }

    @Override
    public void suscribir(IObserverPedidoListo[] o)
    {
        for (IObserverPedidoListo obs :o)
            if(!observadoresSuscriptos.contains(obs))
                observadoresSuscriptos.add(obs);
    }

    @Override
    public void quitar(IObserverPedidoListo[] o)
    {
        observadoresSuscriptos.removeAll(Arrays.asList(o));
    }

    @Override
    public void notificar()
    {
        for(IObserverPedidoListo obs : observadoresSuscriptos)
        {
            obs.actualizar(numMesaActual, cantidadActual);
        }
    }

    private void actualizarEstadoNotificado()
    {
        Estado estNotificado = null;
        List<Estado> estadosDetallePedido = new ArrayList<>();

        for (Estado est: listaEstados)
            if(est.esAmbitoDetallePedido())
                estadosDetallePedido.add(est);

        for (Estado est: estadosDetallePedido)
            if(est.esNotificado())
            {
                estNotificado = est;
                break;
            }

        detalleActual.notificar(estNotificado);
    }

    private void finCasoUso()
    {
        System.out.println("Caso de uso finalizado");
        pantalla.tomarOpcionFinalizarPedido(new ActionEvent());
    }
}
