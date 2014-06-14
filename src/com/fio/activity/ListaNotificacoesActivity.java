package com.fio.activity;

import java.util.ArrayList;

import com.fio.bean.Notificacao;
import com.fio.tcc.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

@SuppressWarnings("unused")
public class ListaNotificacoesActivity extends Activity implements
		OnItemClickListener {
	private ListView listaNotificacoes;
	String[] lista;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listanotificacoes);

		lista = getIntent().getStringArrayExtra("listaNotificacoes");

		ArrayList listaNotificacao = new ArrayList();

		for (int i = 0; i < lista.length; i++) {
			String[] arrayNotificacao = lista[i].split("/p");
			listaNotificacao.add(arrayNotificacao[0]);
		}

		listaNotificacoes = (ListView) findViewById(R.id.listNotificacoes);
		
		ArrayAdapter ad = new ArrayAdapter(this,
				android.R.layout.simple_list_item_2, android.R.id.text1,
				listaNotificacao);

		listaNotificacoes.setAdapter(ad);

		
		listaNotificacoes.setOnItemClickListener(this);

	}

	public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
		Intent intent = new Intent(this, DetalhesNotificacaoActivity.class);
		intent.putExtra("arrayNotificacao", lista[pos]);
		startActivity(intent);
	}
}
