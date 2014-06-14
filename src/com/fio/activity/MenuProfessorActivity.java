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

public class MenuProfessorActivity extends Activity implements OnClickListener {

	private Button btChamada;
	private Button btLancarNotas;
	
	private int idProfessor;
	
	String[] lista;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuprofessor);

		String loginParametro = getIntent().getStringExtra("usuario");
		idProfessor = getIntent().getIntExtra("idProfessor", 0);
		
		

		TextView tBoasVindas = (TextView) findViewById(R.id.bemVindoProfessor);

		tBoasVindas.setText("Bem-vindo " + loginParametro);

		btChamada = (Button) findViewById(R.id.btChamada);
		btLancarNotas = (Button) findViewById(R.id.btLancarNotas);
		
		
		
		btChamada.setOnClickListener(this);
		btLancarNotas.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view == btChamada) {
			WebService ws = new WebService();
			
			lista = ws.carregaLeciona(idProfessor);
			
			Intent intent = new Intent(this,ListaChamadaActivity.class);
			intent.putExtra("listaMateria", lista);
			startActivity(intent);
		}
		if (view == btLancarNotas) {			
			WebService ws = new WebService();
			
			String idProf = idProfessor+"";
			lista = ws.carregaLecionaInteiro(idProf);
			
			Intent intent = new Intent(this,ListaMateriaLancarNotaActivity.class);
			intent.putExtra("listaMateria", lista);
			startActivity(intent);
		}
	}

}
