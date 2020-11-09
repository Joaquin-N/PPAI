package logica;

import java.util.Date;

public class HistorialEstado
{
    private Estado estado;
    private Date fechaHoraFin;
    private Date fechaHoraInicio;


    public HistorialEstado(Estado estado, Date fechaHoraInicio)
    {
        this.estado = estado;
        this.fechaHoraInicio = fechaHoraInicio;
    }


    public boolean esUltimoHistorial()
    {
        return fechaHoraFin == null;
    }


    public boolean esEnPreparacion()
    {
        return this.estado.esEnPreparacion();
    }


    public void setFechaHoraFin(Date fechaHoraFin)
    {
        this.fechaHoraFin = fechaHoraFin;
    }
}
