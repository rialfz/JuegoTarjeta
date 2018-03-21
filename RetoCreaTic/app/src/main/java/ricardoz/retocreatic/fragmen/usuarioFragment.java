package ricardoz.retocreatic.fragmen;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ricardoz.retocreatic.R;
import ricardoz.retocreatic.entidad.Usuario;
import ricardoz.retocreatic.Validacion;

/**
 * A simple {@link Fragment} subclass.
 */
public class usuarioFragment extends Fragment {

    TextView textPunateje,textNombre,textCorreo;
    TextInputLayout inputNombre, inputCorreo;
    Button btnGuardar;
    Double punt;
    Comunicacion comunicacion;

    public usuarioFragment() {
        // Required empty public constructor
    }

    public interface Comunicacion
    {
        public void reiniciar();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_informacion_usuario, container, false);
        String puntaje=getArguments().getString("Puntaje");
        punt=Double.parseDouble(puntaje);
        textPunateje=(TextView) vista.findViewById(R.id.puntaje);
        textNombre=(TextView) vista.findViewById(R.id.nombre);
        textCorreo=(TextView) vista.findViewById(R.id.correo);
        btnGuardar = (Button) vista.findViewById(R.id.btnGuardarDatos);
        inputNombre = (TextInputLayout) vista.findViewById(R.id.inputNombre);
        inputCorreo = (TextInputLayout) vista.findViewById(R.id.inputCorreo);
        textPunateje.setText("Tu puntuación: "+puntaje);
        btnGuardar.setOnClickListener(guardar);
        return vista;
    }


    View.OnClickListener guardar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nombre = textNombre.getText().toString();
            String correo= textCorreo.getText().toString();

            if(validar(nombre,correo)){
                Usuario us = new Usuario();
                us.setNombre(nombre);
                us.setCorreo(correo);
                us.setPuntaje(punt);
                Usuario.save(us);
                Toast.makeText(getContext(),"Jugador Guardado",Toast.LENGTH_LONG).show();
                comunicacion.reiniciar();
            }
        }
    };


    public boolean validar(String nombre,String correo)
    {

        boolean b=false;
        boolean bc=false;
        boolean bt=false;
        if(!Validacion.isVacio(nombre)){
            b=true;
            inputNombre.setError(null);
        }else{
            inputNombre.setError("campo vacio");
        }

        if(!Validacion.isVacio(correo)){
            if(Validacion.correoValido(correo)){
                inputCorreo.setError(null);
                bc = true;
            }else{
                inputCorreo.setError("correo invalido");
            }

        }else{
            inputCorreo.setError("campo vacio");
        }
        if(b&&bc){
            bt=true;
        }

        return bt;
    }

    public void onAttach(Context context){
        super.onAttach(context);
        comunicacion= (usuarioFragment.Comunicacion) context;
    }
}
