package com.projeto.integrador.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

     private String baseUrl = "http://projetointegrador2.cfapps.io/";  //10.0.2.2 ou http://127.0.0.1 - para local host
    //private String baseUrl = "https://jsonplaceholder.typicode.com/";
    private InterfaceDeServicos api;
    private static RetrofitService instancia;

    private RetrofitService() {
        api = criaRetrofit().create(InterfaceDeServicos.class);
    }

    private Retrofit criaRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd/MM/yyyy")
                .create();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    public static InterfaceDeServicos getServico() {
        if (instancia == null)
            instancia = new RetrofitService();
        return instancia.api;
    }
}
