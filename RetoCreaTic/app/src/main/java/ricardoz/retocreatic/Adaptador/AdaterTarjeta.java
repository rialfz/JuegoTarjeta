package ricardoz.retocreatic.Adaptador;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import ricardoz.retocreatic.R;
import ricardoz.retocreatic.Tarjeta;

/**
 * Created by RicardoZ on 19/03/2018.
 */

public class AdaterTarjeta extends RecyclerView.Adapter<AdaterTarjeta.TarjetaViewHolder> implements View.OnClickListener {

    Activity activity;
    List<Tarjeta> tarjetas;
    private Context context;
    //numero de opciones por defecto
    private List<Integer> indices;
    private static boolean seleccionable;
    private View.OnClickListener listener;

    public AdaterTarjeta(List<Tarjeta> tarjetas,Context context)
        {
            if(tarjetas != null)
            {
                this.tarjetas = tarjetas;
            }else{
                this.tarjetas= new ArrayList<>();
            }
                this.context = context;
                this.indices = new ArrayList<>();
                seleccionable = false;
        }

        @Override
        public void onClick(View v) {
            if(listener!=null){
                listener.onClick(v);
            }
        }

    public static class TarjetaViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imagen;


        TarjetaViewHolder(View item){
            super(item);

            imagen=(ImageView)item.findViewById(R.id.imagen);


        }
    }

        @Override
        public TarjetaViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarjeta, parent, false);
            v.setOnClickListener(this);
            TarjetaViewHolder uvh = new TarjetaViewHolder(v);

            return uvh;
        }

        @Override
        public void onBindViewHolder(TarjetaViewHolder holder, int position) {

            holder.imagen.setImageResource(tarjetas.get(position).getImagen());


        }

        @Override
        public int getItemCount() {
            return tarjetas.size();
        }




    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }



}
