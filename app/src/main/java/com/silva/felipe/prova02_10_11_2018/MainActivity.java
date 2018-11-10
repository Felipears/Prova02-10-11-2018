package com.silva.felipe.prova02_10_11_2018;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends ListActivity {

    private final String BASE_URL = "https://provaddm2018.000webhostapp.com/lista_de_alunos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chamada();
    }

    private Chamadas getRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()).create(Chamadas.class);
    }

    private void chamada() {
        Call<List<Aluno>> call = getRetrofit().obterAluno();
        call.enqueue(new Callback<List<Aluno>>() {//chamada assíncrona
            public void onResponse(Call<List<Aluno>> call,
                                   Response<List<Aluno>> response) {
                int statusCode = response.code();
                List<Aluno> alunos = response.body();
                setListAdapter(new AlunoAdapter(MainActivity.this, alunos));
            }

            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                // Log error here since request failed
                Log.i("teste", t.toString());
            }
        });
    }
}
