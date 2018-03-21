package ricardoz.retocreatic.Adaptador;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ricardoz.retocreatic.R;
import ricardoz.retocreatic.entidad.Usuario;

/**
 * Created by RicardoZ on 21/03/2018.
 */

public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder> {

        Activity activity;
        List<Usuario> usuarios;
        private Context context;
        //numero de opciones por defecto
        private List<Integer> indices;
        private static boolean seleccionable;

        public AdapterUsuario(List<Usuario> tarjetas,Context context)
        {
                if(tarjetas != null)
                {
                this.usuarios = tarjetas;
                }else{
                this.usuarios= new ArrayList<>();
                }
                this.context = context;
                this.indices = new ArrayList<>();
                seleccionable = false;
        }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder
    {
        TextView nombre;
        TextView correo;
        TextView puntaje;




        UsuarioViewHolder(View item){
            super(item);

            nombre=(TextView) item.findViewById(R.id.itemNombre);
            correo=(TextView) item.findViewById(R.id.itemCorreo);
            puntaje=(TextView) item.findViewById(R.id.itemPunataje);


        }
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        UsuarioViewHolder uvh = new UsuarioViewHolder(v);

        return uvh;
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {

        holder.nombre.setText("  Nombre: "+usuarios.get(position).getNombre());
        holder.correo.setText("  Correo: "+usuarios.get(position).getCorreo());
        holder.puntaje.setText("  Puntaje: "+String.valueOf(usuarios.get(position).getPuntaje()));
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }


}
