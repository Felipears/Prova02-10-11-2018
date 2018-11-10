package com.silva.felipe.prova02_10_11_2018;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AlunoAdapter extends BaseAdapter {

    Context contexto;
    List<Aluno> lista;

    public AlunoAdapter(Context contexto, List<Aluno> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = LayoutInflater.from(contexto).inflate(R.layout.lista_aluno_nota, null);
        Aluno aluno = lista.get(position);

        TextView nomeAluno = (TextView) linha.findViewById(R.id.aluno);
        TextView notaAluno = (TextView) linha.findViewById(R.id.nota);
        ImageView imagem =   (ImageView) linha.findViewById(R.id.imagem);

        if(aluno.getNota() > 6){
            imagem.setImageResource(R.drawable.ic_azul);
        }
        else{
            imagem.setImageResource(R.drawable.ic_vermelho);
        }
        nomeAluno.setText(aluno.getNome());
        notaAluno.setText(aluno.getNota() + "");
        return linha;
    }
}
