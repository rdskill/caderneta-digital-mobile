package com.fio.activity;


import java.util.ArrayList;

import com.fio.tcc.R;
import com.fio.webservice.WebService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ListaMateriaLancarNotaActivity extends Activity implements OnClickListener {
	private Spinner spMaterias;
	private Button btListaAlunos;
	ArrayList<String> lista = new ArrayList<String>();
	private String materia;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listamaterialancarnota);
		
		String[] loginParametro = getIntent().getStringArrayExtra("listaMateria");
		
		if (loginParametro.length == 1 && loginParametro[0].equals("")) {
			finish();
			Toast.makeText(this, "Não há matérias vinculadas ao professor", Toast.LENGTH_LONG).show();
		} else {
			for (int i=0;i<loginParametro.length;i++) {
				lista.add(loginParametro[i]);
			}
		}
		
		spMaterias = (Spinner) findViewById(R.id.spinnerListaMateriasNota);
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, lista);
		ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;

		spMaterias.setAdapter(spinnerArrayAdapter);
		
		btListaAlunos = (Button) findViewById(R.id.btTelaLancarNota);
		
		btListaAlunos.setOnClickListener(this);
		
		spMaterias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			 
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				materia = parent.getItemAtPosition(posicao).toString();
			}
 
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				materia = parent.getItemAtPosition(0).toString();
			}
		});
	}
	@Override
	public void onClick(View arg0) {
		String materia2[] = materia.split("\\.");
		String id = materia2[0];
		WebService ws = new WebService();
		String[] listaAlunos = ws.carregaChamadaNotaFrequencia(id);
		Intent intent = new Intent(this, ListaAlunosNotaFrequencia.class);
		intent.putExtra("alunos", listaAlunos);
		startActivity(intent);		
	}
	
	
}
