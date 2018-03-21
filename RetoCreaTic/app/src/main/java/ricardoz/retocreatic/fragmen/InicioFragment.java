package ricardoz.retocreatic.fragmen;


import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ricardoz.retocreatic.Adaptador.AdaterTarjeta;
import ricardoz.retocreatic.Comparar;
import ricardoz.retocreatic.R;
import ricardoz.retocreatic.Tarjeta;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    List<Tarjeta> tarjetas;
    RecyclerView listaTarjetas;
    AdaterTarjeta adaptador;
    TextView texMin;
    TextView texSeg;
    int contador;
    int imagenCarta;
    CountDownTimer timer;
    Integer pos;
    Boolean isCompracion=false;
    boolean istimer=false;
    Comunicacion comunicacion;
    boolean  isValidate=true;
    long tiempo;

    public interface Comunicacion
    {
        public void terminar(long tiempo);

    }

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_inicio, container, false);
        cargarConfiguracion();
        listaTarjetas = (RecyclerView) vista.findViewById(R.id.lista_tarjetas);
        listaTarjetas.setHasFixedSize(true);
        //LinearLayoutManager managerRv = new  //new LinearLayoutManager(this);
        listaTarjetas.setLayoutManager(new GridLayoutManager(getContext(),6));
        RecyclerView.ItemDecoration decorador = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        listaTarjetas.addItemDecoration(decorador);

        adaptador = new AdaterTarjeta(tarjetas,getContext());
        adaptador.setOnClickListener(mostrar);
        listaTarjetas.setAdapter(adaptador);
        texMin = (TextView) vista.findViewById(R.id.textMinuto);
        texSeg = (TextView) vista.findViewById(R.id.textSegundo);

        return vista;
    }

    View.OnClickListener mostrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             if(isValidate) {
                 Integer postion = listaTarjetas.getChildPosition(v);
                 Tarjeta tarjeta = tarjetas.get(postion);
                 if (!tarjeta.isStado()) {
                     tarjeta.setImagen(tarjeta.getNumeroAsociado());

                     adaptador = new AdaterTarjeta(tarjetas, getContext());
                     adaptador.setOnClickListener(this);
                     listaTarjetas.setAdapter(adaptador);

                     if (isCompracion) {
                         comparar(tarjeta, postion);
                     } else if (isCompracion == false) {
                         isCompracion = true;
                         pos = postion;
                     }
                 }
             }
        }
    };

    public void cargarConfiguracion(){


        if(istimer){timer.cancel();}
        pos=0;
        isCompracion=false;
        imagenCarta=R.drawable.logo_clouster;
        tarjetas = new ArrayList<>();
        contador=0;
        for (int i=0;i<18;i++){
            String uri = "@drawable/imagen"+String.valueOf(i+1);
            int imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
            Tarjeta tarj1=new Tarjeta(imagenCarta,imageResource,false);
            Tarjeta tarj2= new Tarjeta(imagenCarta,imageResource,false);
            tarjetas.add(tarj1);
            tarjetas.add(tarj2);
        }
        distribuir();

        timer= new CountDownTimer(121000, 1000) {
            //121000
            public void onTick(long millisUntilFinished) {
                texMin.setText((millisUntilFinished / 1000)/60+": ");
                texSeg.setText(String.valueOf((millisUntilFinished / 1000)%60));
                tiempo=(millisUntilFinished / 1000);
            }

            public void onFinish() {
                texSeg.setText(String.valueOf(0));
                isValidate=false;
                Toast.makeText(getContext(),"juego Terminado",Toast.LENGTH_LONG).show();
                terminar();

            }
        }.start();
        istimer=true;

    }


    public void distribuir(){
        List<Tarjeta> tj = new ArrayList<>();
        for(int i=0;i<tarjetas.size();i++){
            if(generarAleatorio()<=7){
                tj.add(tarjetas.get(i));
                tarjetas.remove(i);
            }
        }
        tarjetas.addAll(tj);
    }

    public int generarAleatorio(){
        int b=0;
        while(true){
            Random aleatorio = new Random();
             b= 0+aleatorio.nextInt( (9+1) - 0);
            System.out.println(b);
            if(b<18&&b>=0){
                break;
            }
        }
        return b;
    }

    public void comparar(Tarjeta tarjeta, Integer postion ){




        Comparar c = new Comparar();
        c.setContaddor(contador);
        c.setFragment(this);
        c.setListaTarjetas(listaTarjetas);
        c.setTarjetas(tarjetas);
        c.setA(pos);
        c.setB(postion);
        c.execute();

        isCompracion=false;




    }

    public void mostrar(AdaterTarjeta result, int contador){
        result.setOnClickListener(mostrar);
        listaTarjetas.setAdapter(result);
        this.contador=contador;
        if(contador==18){
            terminar();
            Toast.makeText(getContext(),"juego Terminado",Toast.LENGTH_LONG).show();
        }
    }

    public void terminar(){
        long f=120-(120-tiempo);
        comunicacion.terminar(f);
    }

    public void onAttach(Context context){
        super.onAttach(context);
        comunicacion= (Comunicacion) context;
    }

}
