package com.fio.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuProfessor extends Activity implements OnClickListener {

	private Button btChamada;
	private Button btLancarNotas;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuprofessor);

		String loginParametro = getIntent().getStringExtra("usuario");

		TextView tBoasVindas = (TextView) findViewById(R.id.bemVindoProfessor);

		tBoasVindas.setText("Bem vindo " + loginParametro);

		btChamada = (Button) findViewById(R.id.btChamada);
		btLancarNotas = (Button) findViewById(R.id.btLancarNotas);
		
		
		
		btChamada.setOnClickListener(this);
		btLancarNotas.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view == btChamada) {
			Intent intent = new Intent(this,Chamada.class);
			startActivity(intent);
		}
		if (view == btLancarNotas) {
			Intent intent = new Intent(this,LancamentoNotas.class);
			startActivity(intent);
		}
	}

}
