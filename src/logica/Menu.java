package logica;

import java.util.Date;

public class Menu
{
    private String nombre;
    private int cantidadMinimaComensales;
    private String comentarios;
    private Date fechaCreacion;
    private Date fechaVigencia;
    private String foto;
    private float precio;

    public Menu(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getCantidadMinimaComensales()
    {
        return cantidadMinimaComensales;
    }

    public void setCantidadMinimaComensales(int cantidadMinimaComensales)
    {
        this.cantidadMinimaComensales = cantidadMinimaComensales;
    }

    public String getComentarios()
    {
        return comentarios;
    }

    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios;
    }

    public Date getFechaCreacion()
    {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVigencia()
    {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia)
    {
        this.fechaVigencia = fechaVigencia;
    }

    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    public float getPrecio()
    {
        return precio;
    }

    public void setPrecio(float precio)
    {
        this.precio = precio;
    }
}
