package com.fio.activity;

import java.util.ArrayList;

import com.fio.bean.Nota;
import com.fio.tcc.R;
import com.fio.webservice.WebService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LancamentoNotasActivity extends Activity implements
		OnClickListener {
	private EditText notaPrimeiroBimestre;
	private EditText notaSegundoBimestre;
	private EditText notaExame;
	private String[] notas;
	private Button btLancarNota;
	private String idMatricula;
	Nota nota;
	ArrayList<Nota> arrayNotas;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lancamentonotas);

		nota = new Nota();
		arrayNotas = new ArrayList<Nota>();

		notas = getIntent().getStringArrayExtra("arrayNotas");

		if (!notas[0].equals("")) {
			for (int i = 0; i < notas.length; i++) {
				nota = new Nota();
				String[] idNota = notas[i].split("/id");
				nota.setIdNota(Integer.parseInt(idNota[0]));
				nota.setNota(Float.parseFloat(idNota[1]));
				arrayNotas.add(nota);
			}
		}

		idMatricula = getIntent().getStringExtra("idMatricula");

		notaPrimeiroBimestre = (EditText) findViewById(R.id.notaPrimeiroBimestre);
		notaSegundoBimestre = (EditText) findViewById(R.id.notaSegundoBimestre);
		notaExame = (EditText) findViewById(R.id.notaExame);

		if (arrayNotas.size() > 0) {
			if (arrayNotas.size() >= 1) {
				notaPrimeiroBimestre.setText("" + arrayNotas.get(0).getNota());
			}
			if (arrayNotas.size() >= 2) {
				notaSegundoBimestre.setText("" + arrayNotas.get(1).getNota());
			}
			if (arrayNotas.size() == 3) {
				notaExame.setText("" + arrayNotas.get(2).getNota());
			}
		}

		btLancarNota = (Button) findViewById(R.id.btLancarNota);

		btLancarNota.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view == btLancarNota) {
			ArrayList<Nota> arrayNotas2 = new ArrayList<Nota>();

			String notaPriBim = notaPrimeiroBimestre.getText().toString();
			if (!notaPriBim.equals("")) {
				nota = new Nota();
				if (arrayNotas.size() >= 1) {
					nota.setIdNota(arrayNotas.get(0).getIdNota());
				}
				nota.setNota(Float.parseFloat(notaPriBim));
				arrayNotas2.add(nota);
			}
			String notaSegBim = notaSegundoBimestre.getText().toString();
			if (!notaSegBim.equals("")) {
				nota = new Nota();
				if (arrayNotas.size() >= 2) {
					nota.setIdNota(arrayNotas.get(1).getIdNota());
				}
				nota.setNota(Float.parseFloat(notaSegBim));
				arrayNotas2.add(nota);
			}
			String notaExam = notaExame.getText().toString();
			if (!notaExam.equals("")) {
				nota = new Nota();
				if (arrayNotas.size() == 3) {
					nota.setIdNota(arrayNotas.get(2).getIdNota());
				}
				nota.setNota(Float.parseFloat(notaExam));
				arrayNotas2.add(nota);
			}
			WebService ws = new WebService();
			String resposta = ws.lancarNotas(arrayNotas2, idMatricula);

			Toast.makeText(this, resposta, Toast.LENGTH_SHORT).show();

			finish();
		}
	}
}
