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

public class ListaMateriaAlunoActivity extends Activity implements OnItemClickListener {
	private ListView listViewMaterias;
	String[] lista;
	String[] arrayMateria;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listamateriaaluno);
		
		lista = getIntent().getStringArrayExtra("listaMaterias");
		
		ArrayList listaMaterias = new ArrayList();
		
		for (int i = 0; i < lista.length; i++) {
			arrayMateria = lista[i].split("\\.");
			listaMaterias.add(arrayMateria[1]);
		}
		
		listViewMaterias = (ListView) findViewById(R.id.listMateriasAluno);
		
		ArrayAdapter ad = new ArrayAdapter(this,
				android.R.layout.simple_list_item_2, android.R.id.text1,
				listaMaterias);
		
		listViewMaterias.setAdapter(ad);
		
		listViewMaterias.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
		WebService ws = new WebService();
		arrayMateria = lista[pos].split("\\.");
		String resposta[] = ws.buscarFrequenciaNota(arrayMateria[0]);
		Intent intent = new Intent(this, DetalhesNotaFrequenciaActivity.class);
		intent.putExtra("arrayNotaFrequencia", resposta);
		intent.putExtra("nomeMateria", arrayMateria[1]);
		startActivity(intent);
	}

	
	
}
