package logica;

import java.util.Date;

public class Pedido
{
    private int cantComensales;
    private DetalleDePedido detalleDePedido[];
    private String factura;
    private Date fechaHoraPed;
    private HistorialEstado historialstado[];
    private int nroPedido;
    private Mesa mesa;

    public Pedido(int cantComensales, DetalleDePedido[] detalleDePedido, String factura, Date fechaHoraPed, HistorialEstado[] historialstado, int nroPedido) {
        this.cantComensales = cantComensales;
        this.detalleDePedido = detalleDePedido;
        this.factura = factura;
        this.fechaHoraPed = fechaHoraPed;
        this.historialstado = historialstado;
        this.nroPedido = nroPedido;
    }

    public int getCantComensales() {
        return cantComensales;
    }

    public DetalleDePedido[] getDetalleDePedido() {
        return detalleDePedido;
    }

    public String getFactura() {
        return factura;
    }

    public Date getFechaHoraPed() {
        return fechaHoraPed;
    }

    public HistorialEstado[] getHistorialstado() {
        return historialstado;
    }

    public int getNroPedido() {
        return nroPedido;
    }

    public int mostrarMesa(){
        return mesa.getNumero();
    }



}
