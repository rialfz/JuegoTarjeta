package ricardoz.retocreatic;


/**
 * Shared preference singleton
 * Created by RicardoZ on 10/11/2017.
 */
//Clase que permite cargar la configuracion inicial
public class SPSingleton {

    private static SPSingleton archivo;


    private String CONFIGURACION="configuracion";
    private String NOMBRESHAREPREFERENCE = "inicio";
    private SPSingleton(){

    }

    public static SPSingleton getInstance(){
        if(archivo == null){
            archivo = new SPSingleton();
        }
        return archivo;
    }



    public String getCONFIGURACION() {
        return CONFIGURACION;
    }

    public void setCONFIGURACION(String CONFIGURACION) {
        this.CONFIGURACION = CONFIGURACION;
    }

    public static SPSingleton getArchivo() {
        return archivo;
    }

    public static void setArchivo(SPSingleton archivo) {
        SPSingleton.archivo = archivo;
    }

    public String getNOMBRESHAREPREFERENCE() {
        return NOMBRESHAREPREFERENCE;
    }

    public void setNOMBRESHAREPREFERENCE(String NOMBRESHAREPREFERENCE) {
        this.NOMBRESHAREPREFERENCE = NOMBRESHAREPREFERENCE;
    }
}
