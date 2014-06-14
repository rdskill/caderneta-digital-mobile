package com.fio.activity;

import java.util.ArrayList;

import com.fio.tcc.R;
import com.fio.webservice.WebService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAlunosNotaFrequencia extends Activity implements OnItemClickListener {
	private ListView listViewAluno;
	String[] alunos;
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listaalunosnotafrequencia);
		
		alunos = getIntent().getStringArrayExtra("alunos");
		
		ArrayList listaAluno = new ArrayList();

		for (int i = 0; i < alunos.length; i++) {
			String[] arrayNotificacao = alunos[i].split("\\.");
			listaAluno.add(arrayNotificacao[1]);
		}

		listViewAluno = (ListView) findViewById(R.id.listAlunosFrequenciaNota);
		
		ArrayAdapter ad = new ArrayAdapter(this,
				android.R.layout.simple_list_item_2, android.R.id.text1,
				listaAluno);

		listViewAluno.setAdapter(ad);

		
		listViewAluno.setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
		String[] arrayAluno = alunos[pos].split("\\.");		
		
		WebService ws = new WebService();
		String[] notas = ws.carregaNotasAluno(arrayAluno[2]);
		
		Intent intent = new Intent(this, LancamentoNotasActivity.class);
		intent.putExtra("arrayNotas", notas);
		intent.putExtra("idMatricula", arrayAluno[2]);
		
		startActivity(intent);
	}
}
