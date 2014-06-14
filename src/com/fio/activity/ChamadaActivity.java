package com.fio.activity;

import java.util.ArrayList;

import com.fio.bean.Aluno;
import com.fio.tcc.R;
import com.fio.util.ListaAlunoAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

@SuppressWarnings("unused")
public class ChamadaActivity extends ListActivity {
	ArrayList<Aluno> listaChamada = new ArrayList<Aluno>();
	String[] lista;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chamada);

		lista = getIntent().getStringArrayExtra("alunos");

		for (int i = 0; i < lista.length; i++) {
			String[] arrayAluno = lista[i].split("\\.");
			Aluno aluno = new Aluno();
			aluno.setNome(arrayAluno[0]);
			aluno.setIdFrequencia(Integer.parseInt(arrayAluno[1]));
			aluno.setPresenca(arrayAluno[2]);
			aluno.setIdMatricula(Integer.parseInt(arrayAluno[3]));
			listaChamada.add(aluno);
		}

		setListAdapter((ListAdapter) new ListaAlunoAdapter(this, listaChamada));

	}
}
