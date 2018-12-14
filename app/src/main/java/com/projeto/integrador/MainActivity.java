package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.projeto.integrador.adapters.UsuarioAdapter;
import com.projeto.integrador.application.AgroHelpApplication;
import com.projeto.integrador.domain.Usuario;
import com.projeto.integrador.services.InterfaceDeServicos;
import com.projeto.integrador.services.RetrofitService;
import com.projeto.integrador.services.domain.UsuarioRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private InterfaceDeServicos interfaceDeServicos;
    private RetrofitService retrofitService;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> usuarios;
    private TextView login, senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void chamadaLogin() {
        interfaceDeServicos = retrofitService.getServico();

        String loginTexto = login.getText().toString();
        String senhaTexto = senha.getText().toString();

        Call<Usuario> call = interfaceDeServicos.login(new UsuarioRequest(loginTexto, senhaTexto));

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.body() != null && response.isSuccessful())  {
                    AgroHelpApplication.getInstance().setUsuario(response.body());
                    startActivityFeed();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

//        call.enqueue(new Callback<List<Usuario>>() {
//            @Override
//            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
//                usuarios = response.body();
//
//                login = findViewById(R.id.loginId);
//                senha = findViewById(R.id.senhaId);
//
//                boolean flag = true;
//
//
//
//                for(Usuario usuario : usuarios){
//                    if(usuario.getNome().equals(loginTexto) && usuario.getSenha().equals(senhaTexto)){
//                        flag = false;
//                        Intent intent = new Intent(MainActivity.this, FeedActivity.class);
//                        intent.putExtra("usuarioObj", usuario);
//                        Log.i("logou", "Logou galera");
//
//
//                        startActivity(intent);
//                    }
//                }
//
//                if(flag) {
//                    Toast.makeText(getApplicationContext(), "Sistema não reconhece este login e senha", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Usuario>> call, Throwable t) {
//                Log.i("erro", t.getMessage());
//            }
//        });

    }

    public void entraNoSistema(View view) {  // botão principal de login do sistema

        login = findViewById(R.id.loginId);
        senha = findViewById(R.id.senhaId);

        Log.i("login", login.getText().toString());

        if((login.getText().toString().isEmpty()) || senha.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Você deve preencher os campos", Toast.LENGTH_SHORT).show();
        }
        else {

//            chamadaLogin();
            //TODO ativar de novo quando back-end estiver pronto (Está mocado o login)
            AgroHelpApplication.getInstance().setUsuario(new Usuario("Breno Mendes", "1234", "01010101001", "brenomendes@gmail.com", "Breno Mendes"));
            startActivityFeed();

        }

        // criei este teste para simplismente buscar os dados digitados na tela e transcrever para o log.
        login = findViewById(R.id.loginId);
        senha = findViewById(R.id.senhaId);

        if (login != null && senha != null){

            String loginTexto = login.getText().toString();
            String senhaTexto = senha.getText().toString();

            Log.i("nome entrado no login", loginTexto);
            Log.i("nome entrado na senha", senhaTexto);
        }
    }

    private void startActivityFeed() {
        Intent intent = new Intent(MainActivity.this, FeedActivity.class);
        startActivity(intent);
    }

    public void abreTelaDeCadastro(View view){
        Intent intent = new Intent(MainActivity.this, CadastroAcitivity.class);
        startActivity(intent);
    }
}
