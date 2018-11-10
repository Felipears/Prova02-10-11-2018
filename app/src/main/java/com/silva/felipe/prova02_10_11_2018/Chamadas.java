package com.silva.felipe.prova02_10_11_2018;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Chamadas {

  @GET("lista_de_alunos")
  Call<List<Aluno>> obterAluno();

}
