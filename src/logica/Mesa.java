package logica;

public class Mesa
{
    private int numero;
    private int capacidadComensales;
    private float espacioQueOcupa;
    private Estado estado;
    private int filaEnPlano;
    private String forma;
    private int ordenEnPlano;
    private Pedido pedido;

    public Mesa(int numero)
    {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidadComensales()
    {
        return capacidadComensales;
    }

    public void setCapacidadComensales(int capacidadComensales)
    {
        this.capacidadComensales = capacidadComensales;
    }

    public float getEspacioQueOcupa()
    {
        return espacioQueOcupa;
    }

    public void setEspacioQueOcupa(float espacioQueOcupa)
    {
        this.espacioQueOcupa = espacioQueOcupa;
    }

    public Estado getEstado()
    {
        return estado;
    }

    public void setEstado(Estado estado)
    {
        this.estado = estado;
    }

    public int getFilaEnPlano()
    {
        return filaEnPlano;
    }

    public void setFilaEnPlano(int filaEnPlano)
    {
        this.filaEnPlano = filaEnPlano;
    }

    public String getForma()
    {
        return forma;
    }

    public void setForma(String forma)
    {
        this.forma = forma;
    }

    public int getOrdenEnPlano()
    {
        return ordenEnPlano;
    }

    public void setOrdenEnPlano(int ordenEnPlano)
    {
        this.ordenEnPlano = ordenEnPlano;
    }

    public Pedido getPedido()
    {
        return pedido;
    }

    public void setPedido(Pedido pedido)
    {
        this.pedido = pedido;
    }
}
