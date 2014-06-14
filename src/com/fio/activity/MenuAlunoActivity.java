package com.fio.activity;

import com.fio.tcc.R;
import com.fio.webservice.WebService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuAlunoActivity extends Activity implements OnClickListener {
	private Button btVisualizarNotificacoes;
	private Button btVisualizarNotasFrequencia;
	String idAluno;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menualuno);

		String loginParametro = getIntent().getStringExtra("usuario");
		int codAluno = getIntent().getIntExtra("idAluno",0);
		idAluno = ""+codAluno;

		TextView tBoasVindas = (TextView) findViewById(R.id.bemVindoAluno);

		// atribui o text do nosso labelBoasVindas
		tBoasVindas.setText("Bem-vindo " + loginParametro);

		btVisualizarNotificacoes = (Button) findViewById(R.id.btnVisualizarNotificacoes);
		btVisualizarNotasFrequencia = (Button) findViewById(R.id.btnVisualizarFrequenciaNotas);
		
		btVisualizarNotificacoes.setOnClickListener(this);
		btVisualizarNotasFrequencia.setOnClickListener(this);

	}

	public void onClick(View v) {
		if (v == btVisualizarNotificacoes) {
			WebService ws = new WebService();
			String listaNotificacoes[] = ws.receberNotificacoes();
			
			Intent intent = new Intent(this,ListaNotificacoesActivity.class);
			intent.putExtra("listaNotificacoes", listaNotificacoes);
			startActivity(intent);
		}
		
		if (v == btVisualizarNotasFrequencia) {
			WebService ws = new WebService();
			String listaMaterias[] = ws.buscarMateriaAluno(idAluno);
			
			Intent intent = new Intent(this,ListaMateriaAlunoActivity.class);
			intent.putExtra("listaMaterias", listaMaterias);
			startActivity(intent);
		}

	}
}
