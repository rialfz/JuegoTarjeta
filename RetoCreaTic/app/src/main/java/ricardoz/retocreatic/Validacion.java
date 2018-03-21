package ricardoz.retocreatic;

import android.util.Log;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RicardoZ on 21/03/2018.
 */

public class Validacion {

    public static boolean correoValido(String correo){
        if(Patterns.EMAIL_ADDRESS.matcher(correo).matches() == false){
            return false;
        }else{
            return true;
        }
    }

    public static boolean contrasenaValida(String contrasena){
        return contrasena.length()<7?false:true;
    }

    public static boolean isVacio(String campo){
        return campo.length() == 0?true:false;
    }

    public static boolean nombreValido(String nombre){
        Pattern p = Pattern.compile(nombre);
        Matcher m = p.matcher("[a-zA-Z&&[^0-9]]");
        boolean r = m.matches();
        Log.d("Validacion", "valor de match es "+r);
        if(r) {
            return false;
        }else{
            return true;
        }
    }
}
