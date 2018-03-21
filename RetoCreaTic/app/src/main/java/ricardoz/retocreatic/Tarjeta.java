package ricardoz.retocreatic;

/**
 * Created by RicardoZ on 19/03/2018.
 */

public class Tarjeta {
    private Integer imagen;
    private Integer numeroAsociado;
    private boolean stado;

    public Tarjeta(Integer imagen, Integer numeroAsociado, boolean stado) {
        this.imagen = imagen;
        this.numeroAsociado = numeroAsociado;
        this.stado=stado;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public Integer getNumeroAsociado() {
        return numeroAsociado;
    }

    public void setNumeroAsociado(Integer numeroAsociado) {
        this.numeroAsociado = numeroAsociado;
    }

    public boolean isStado() {
        return stado;
    }

    public void setStado(boolean stado) {
        this.stado = stado;
    }
}
