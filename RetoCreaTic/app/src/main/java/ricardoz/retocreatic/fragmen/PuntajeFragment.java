package ricardoz.retocreatic.fragmen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ricardoz.retocreatic.Adaptador.AdapterUsuario;
import ricardoz.retocreatic.R;
import ricardoz.retocreatic.entidad.Usuario;

/**
 * A simple {@link Fragment} subclass.
 */
public class PuntajeFragment extends Fragment {


    List<Usuario> usuarios;
    RecyclerView listaUsuarios;
    AdapterUsuario adaptador;

    public PuntajeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_puntaje, container, false);
        listaUsuarios = (RecyclerView) vista.findViewById(R.id.lista_tarjetas);
        listaUsuarios.setHasFixedSize(true);
        //LinearLayoutManager managerRv = new  //new LinearLayoutManager(this);
        listaUsuarios.setLayoutManager(new GridLayoutManager(getContext(),1));
        RecyclerView.ItemDecoration decorador = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        listaUsuarios.addItemDecoration(decorador);




        List<Usuario> us = Usuario.findWithQuery(Usuario.class, "SELECT * from Usuario order by puntaje DESC ", null );
        if(us.size()>5) {
            usuarios =new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                usuarios.add(us.get(i));
            }
        }else{
            usuarios=us;
        }

        adaptador = new AdapterUsuario(usuarios,getContext());
        listaUsuarios.setAdapter(adaptador);
        return vista;
    }

}
