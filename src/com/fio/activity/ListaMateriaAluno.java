package com.fio.activity;

import java.util.ArrayList;

import com.fio.tcc.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaMateriaAluno extends Activity implements OnItemClickListener {
	private ListView listViewMaterias;
	String[] lista;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listamateriaaluno);
		
		lista = getIntent().getStringArrayExtra("listaMaterias");
		
		ArrayList listaMaterias = new ArrayList();
		
		for (int i = 0; i < lista.length; i++) {
			String[] arrayMateria = lista[i].split("\\.");
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
		
	}

	
	
}
