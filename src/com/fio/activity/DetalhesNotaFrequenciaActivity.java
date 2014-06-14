package com.fio.activity;

import com.fio.tcc.R;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesNotaFrequenciaActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhenotafrequencia);
		
		String[] notificacao = getIntent().getStringArrayExtra("arrayNotaFrequencia");
		
		String nomeMateria = getIntent().getStringExtra("nomeMateria");
		
		Typeface fontSegoe = Typeface.createFromAsset(getAssets(), "fonts/segoesc.ttf");
		
		TextView txtMateria = (TextView)findViewById(R.id.nomeMateria);
		TextView txtPrimeiroBimestre = (TextView) findViewById(R.id.notaPrimeiroBimestre);
		TextView txtSegundoBimestre = (TextView) findViewById(R.id.notaSegundoBimestre);
		TextView txtExame = (TextView) findViewById(R.id.notaExame);
		TextView txtQuantidadeFaltas = (TextView) findViewById(R.id.quantidadeFalta);
		TextView txtPorcentagemFrequencia = (TextView) findViewById(R.id.porcentagemFrequencia);
		
		txtMateria.setTypeface(fontSegoe);
		
		float faltasF = Float.parseFloat(notificacao[3]);
		int faltas = (int) faltasF;
		
		txtMateria.setText(nomeMateria);
		txtPrimeiroBimestre.setText("1º Bimestre "+notificacao[0]);
		txtSegundoBimestre.setText("2º Bimestre: "+notificacao[1]);
		txtExame.setText("Exame: "+notificacao[2]);
		txtQuantidadeFaltas.setText("Faltas: "+faltas);
		txtPorcentagemFrequencia.setText("Frequência: "+notificacao[4]);
		
	}
}
