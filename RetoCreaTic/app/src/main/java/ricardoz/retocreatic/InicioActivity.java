package ricardoz.retocreatic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.orm.SugarContext;

import java.util.List;

import ricardoz.retocreatic.Adaptador.AdaterTarjeta;
import ricardoz.retocreatic.fragmen.AcercadeFragment;
import ricardoz.retocreatic.fragmen.InicioFragment;
import ricardoz.retocreatic.fragmen.PuntajeFragment;
import ricardoz.retocreatic.fragmen.usuarioFragment;

public class InicioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,InicioFragment.Comunicacion,usuarioFragment.Comunicacion {

    List<Tarjeta> tarjetas;
    RecyclerView listaTarjetas;
    AdaterTarjeta adaptador;
    FragmentManager fm;
    FragmentTransaction tx;
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        SugarContext.init(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fm = getSupportFragmentManager();
        fragment = new InicioFragment();
        tx = fm.beginTransaction();
        tx.replace(R.id.contenedor, fragment);
        tx.commit();
        toggle.syncState();


    }

    @Override
    public void terminar(long tiempo) {

        long puntaje =0;
        if(tiempo!=0) {
            puntaje = (tiempo * 100) / 120;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Bundle arg = new Bundle();
        arg.putString("Puntaje",String.valueOf(puntaje));

        fragment = new usuarioFragment();
        fragment.setArguments(arg);
        tx = fm.beginTransaction();
        tx.replace(R.id.contenedor, fragment);
        tx.commit();
        toggle.syncState();
        //Intent intent = new Intent(InicioActivity.this,InformacionUsuario.class);
        //startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragment = null;


        int id = item.getItemId();

        if (id == R.id.nav_puntaje) {
            fragment = new PuntajeFragment();
        } else if (id == R.id.nav_reiniciar) {
            fragment = new InicioFragment();
        } else if (id == R.id.nav_sacerca) {
            fragment = new AcercadeFragment();
        } else if (id == R.id.nav_salir) {
            System.exit(0);
        }


        tx = fm.beginTransaction();
        tx.replace(R.id.contenedor, fragment);
        tx.commit();
        toggle.syncState();
        return true;
    }

    @Override
    public void reiniciar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragment = new InicioFragment();
        tx = fm.beginTransaction();
        tx.replace(R.id.contenedor, fragment);
        tx.commit();
        toggle.syncState();
    }
}









