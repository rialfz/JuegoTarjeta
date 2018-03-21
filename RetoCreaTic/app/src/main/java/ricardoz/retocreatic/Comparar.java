package ricardoz.retocreatic;


import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ricardoz.retocreatic.Adaptador.AdaterTarjeta;
import ricardoz.retocreatic.fragmen.InicioFragment;

/**
 * Created by RicardoZ on 20/03/2018.
 */

public class Comparar extends AsyncTask<String, String, AdaterTarjeta>
{
    List<Tarjeta> tarjetas;
    RecyclerView listaTarjetas;
    InicioFragment fragment;
    int contaddor;
    int a;
    int b;
    @Override
    protected AdaterTarjeta doInBackground(String... params) {

        SystemClock.sleep(500);
        Tarjeta tarjeta = tarjetas.get(a);
        Tarjeta tarjeta2 = tarjetas.get(b);
        int id = tarjeta.getNumeroAsociado();
        int id2 = tarjeta2.getNumeroAsociado();

        if(id==id2){
            this.contaddor++;
            tarjeta2.setImagen(tarjeta2.getNumeroAsociado());
            tarjeta.setImagen(tarjeta.getNumeroAsociado());
            tarjeta.setStado(true);
            tarjeta2.setStado(true);
        }else{

             tarjeta2.setImagen(R.drawable.logo_clouster);
             tarjeta.setImagen(R.drawable.logo_clouster);

        }

        AdaterTarjeta adaptador = new AdaterTarjeta(tarjetas,fragment.getContext());
        return adaptador;
    }

    @Override
    protected void onPostExecute(AdaterTarjeta result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        fragment.mostrar(result,contaddor);

    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public RecyclerView getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(RecyclerView listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    public InicioFragment getFragment() {
        return fragment;
    }

    public void setFragment(InicioFragment fragment) {
        this.fragment = fragment;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getContaddor() {
        return contaddor;
    }

    public void setContaddor(int contaddor) {
        this.contaddor = contaddor;
    }
}
