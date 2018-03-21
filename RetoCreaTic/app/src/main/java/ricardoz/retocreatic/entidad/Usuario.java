package ricardoz.retocreatic.entidad;

import com.orm.SugarRecord;

/**
 * Created by RicardoZ on 21/03/2018.
 */

public class Usuario extends SugarRecord {

    private String nombre;
    private String correo;
    private Double puntaje;


    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }
}
