package logica;

import java.time.LocalDateTime;

public class HistorialEstado
{
    private Estado estado;
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraInicio;

    public void setFechaHoraFin(LocalDateTime fechaHoraFin)
    {
        this.fechaHoraFin = fechaHoraFin;
    }

    public HistorialEstado(Estado estado, LocalDateTime fechaHoraInicio)
    {
        this.estado = estado;
        this.fechaHoraInicio = fechaHoraInicio;
    }


    public boolean esUltimoHistorial()
    {
        return fechaHoraFin == null;
    }


    public boolean esEnPreparacion(Estado est)
    {
        return this.estado.equals(est);
    }

}
