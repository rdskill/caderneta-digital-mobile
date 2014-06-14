package com.fio.tcc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LancamentoNotas extends Activity implements OnClickListener {
	private EditText notaPrimeiroBimestre;
	private EditText notaSegundoBimestre;
	
	private Button btVoltar;
	private Button btLancarNota;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lancamentonotas);
		
		notaPrimeiroBimestre = (EditText) findViewById(R.id.notaPrimeiroBimestre);
		notaSegundoBimestre = (EditText) findViewById(R.id.notaSegundoBimestre);
		
		btVoltar = (Button) findViewById(R.id.btVoltarLancamentoNotas);
		btLancarNota = (Button) findViewById(R.id.btLancarNota);
		
		btVoltar.setOnClickListener(this);
		btLancarNota.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view == btVoltar) {
			finish();
		}
		if (view == btLancarNota) {
			String notaPri = notaPrimeiroBimestre.getText().toString();
			String notaSeg = notaSegundoBimestre.getText().toString();
			
			double notaPrimeiro = Double.parseDouble(notaPri);
			double notaSegundo = Double.parseDouble(notaSeg);
			
			double media = (notaPrimeiro+notaSegundo)/2;
			
			Toast.makeText(this, "Média aluno: "+media, Toast.LENGTH_SHORT).show();
		}
	}
}
