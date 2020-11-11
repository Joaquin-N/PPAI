package logica;

import java.util.Date;

public class Producto
{
    private String nombre;
    private Date fechaCreacion;
    private String foto;
    private float precio;
    private String receta;
    private String sectorComanda;
    private String tiempoPresen;


    public Producto(String nombre)
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

    public Date getFechaCreacion()
    {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
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

    public String getReceta()
    {
        return receta;
    }

    public void setReceta(String receta)
    {
        this.receta = receta;
    }

    public String getSectorComanda()
    {
        return sectorComanda;
    }

    public void setSectorComanda(String sectorComanda)
    {
        this.sectorComanda = sectorComanda;
    }

    public String getTiempoPresen()
    {
        return tiempoPresen;
    }

    public void setTiempoPresen(String tiempoPresen)
    {
        this.tiempoPresen = tiempoPresen;
    }
}
