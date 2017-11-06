package com.example.dongato.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

//TODO: para los colores de cada fragmento revisar "res/values/colors" y para la animacion se crea un nuevo directorio llamado "anim" dentro de "res"

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    android.support.v4.app.FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction fragmentTransaction;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cargamos barra superiro
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //cargamos el contenedor para soportar el navegationDrawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //cargamos la barra lateral
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //cargamos el primer Fragmento q se mostrara al iniciar la actividad
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                .replace(R.id.contenedor,new SumaFragment())
                .commit();

        textView = (TextView) findViewById(R.id.name);
    }

    @Override
    public void onBackPressed() {

        //botton de retroceso

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // cargamos el menu para la barra superrior

        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //funcionalidad para el menu del toolbar

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(getApplication(),"Le diste Click a settings", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.item2)
            Toast.makeText(getApplication(),"Le diste Click a item2", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        //damos animacion a cada fragmento
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);

        // damos bunfionalidad a los items

        int id = item.getItemId();

        if (id == R.id.nav_suma) {

            SumaFragment sumaFragment = new SumaFragment();
            fragmentTransaction.replace(R.id.contenedor,sumaFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_resta) {

            RestaFragment restaFragment = new RestaFragment();
            fragmentTransaction.replace(R.id.contenedor,restaFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_multiplicacion) {

            MultiplicacionFragment multiplicacionFragment = new MultiplicacionFragment();
            fragmentTransaction.replace(R.id.contenedor,multiplicacionFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_divicion) {

            DivisionFragment divisionFragment = new DivisionFragment();
            fragmentTransaction.replace(R.id.contenedor, divisionFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_info) {

            HechoPorFragment hechoPorFragment = new HechoPorFragment();
            fragmentTransaction.replace(R.id.contenedor, hechoPorFragment);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
