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

public class ListaChamadaActivity extends Activity implements OnClickListener {
	private Spinner spChamada;
	private Button btTelaChamada;
	ArrayList<String> lista = new ArrayList<String>();
	private String materia;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listachamada);
		String[] loginParametro = null;
		loginParametro = getIntent().getStringArrayExtra("listaMateria");
		
		System.out.println("Resposta:"+loginParametro[0]+".");
		System.out.println("Tamanho: "+loginParametro.length);
		
		if (loginParametro.length == 1 && loginParametro[0].equals("")) {
			finish();
			Toast.makeText(this, "Não há matérias vinculadas à data presente", Toast.LENGTH_LONG).show();
		} else {
			for (int i=0;i<loginParametro.length;i++) {
				lista.add(loginParametro[i]);
			}
		}
		
		
		
		spChamada = (Spinner) findViewById(R.id.spinnerListaChamada);
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, lista);
		ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;

		spChamada.setAdapter(spinnerArrayAdapter);
		
		
		btTelaChamada = (Button) findViewById(R.id.btTelaChamada);
		
		
		btTelaChamada.setOnClickListener(this);
		
		spChamada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			 
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

	public void onClick(View view) {
		if (view == btTelaChamada) {
			String materia2[] = materia.split("\\.");
			int id = Integer.parseInt(materia2[0]);
			WebService ws = new WebService();
			String[] listaAlunos = ws.carregaListaChamada(id);
			Intent intent = new Intent(this, ChamadaActivity.class);
			intent.putExtra("alunos", listaAlunos);
			startActivity(intent);
		}
	}
}
