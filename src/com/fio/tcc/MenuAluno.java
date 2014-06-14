package com.fio.tcc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuAluno extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menualuno);
		
		String loginParametro = getIntent().getStringExtra("usuario");
		
		TextView tBoasVindas = (TextView) findViewById(R.id.bemVindoAluno);
		
		//atribui o text do nosso labelBoasVindas
		tBoasVindas.setText("Bem vindo " + loginParametro);

	}
}
