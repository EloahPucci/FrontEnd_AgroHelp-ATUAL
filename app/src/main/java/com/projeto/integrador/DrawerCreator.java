package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.projeto.integrador.application.AgroHelpApplication;
import com.projeto.integrador.domain.Usuario;

public class DrawerCreator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        LinearLayout layout = (LinearLayout) findViewById(R.id.inclusao);
        int layoutid = savedInstanceState.getInt("layout");
        View view = getLayoutInflater().inflate(layoutid, layout, false);
        layout.addView(view);

        /**Linha 27 à linha 37 -> Implementação de Drawer_menu**/
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_feed);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abrir, R.string.fechar);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigationDrawer);
        navigationView.setNavigationItemSelectedListener(this);

        setCamposNoDrawer();
    }

    public void setCamposNoDrawer(){

        String nomeUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getNome();
        String emailUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getEmail();

/*        Usuario usr = null;
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Object value = bundle.get("usuarioObj");
            if (value != null && value instanceof Usuario) {
                usr = (Usuario) value;
                Log.i("TesteObjeto", usr.getNome());*/


                ((TextView)navigationView.getHeaderView(0).findViewById(R.id.nome_do_usuario)).setText(nomeUsuarioLogado);
                ((TextView)navigationView.getHeaderView(0).findViewById(R.id.email_do_usuario)).setText(emailUsuarioLogado);


/*            }
            else {
                Log.i("MIOU", "Nulo ou outro tipo: " + value);
            }
        }
        else {
            Log.i("MIOU", "Bundle tava nulo");
        }*/


       /* if (bundle != null) {
            for (String key : bundle.keySet()) {
                Object value = bundle.get(key);
                if (value == null) {
                    Log.i("Valor:", "nulo" );
                }
                else if (value instanceof Usuario) {
                    Usuario user = (Usuario) value;
                    Log.i("Valor: ", key + "::" + user.getNome());
                }
                else {
                    Log.i("Valor:", "Outro tipo = " + key + "::" + value.getClass().getName());
                }
            }
            Log.i("Terminou", "ok");
        }
        else {
            Log.i("Tava vazio", "vazio");
        }*/
    }

    /**
     * Este método controla o abrir e fechar do Drawer_menu
     **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    /**
     * Este método controla o que cada item do Drawer_menu irá fazer
     **/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Log.i("Drawer","passei aqui");

        int id = menuItem.getItemId();
        Intent intent;
        switch (id) {
            case R.id.home:
                intent = new Intent(this, FeedActivity.class);
                startActivity(intent);
                break;
            case R.id.user:
                intent = new Intent(this, MinhaContaActivity.class);
                startActivity(intent);
                break;
            case R.id.propostas:
                intent = new Intent(this, PropostasActivity.class);
                startActivity(intent);
                break;
            case R.id.orcamentos:
                intent = new Intent(this, OrcamentosActivity.class);
                startActivity(intent);
                break;
            case R.id.premium:
                intent = new Intent(this, PremiumActivity.class);
                startActivity(intent);
                break;
        }

        return false;
    }
}
