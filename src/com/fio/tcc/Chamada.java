package com.fio.tcc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Chamada extends Activity implements OnClickListener {
	
	private Button btVoltar;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chamada);
		
		btVoltar = (Button) findViewById(R.id.btVoltarChamada);
		
		btVoltar.setOnClickListener(this);
		
	}

	public void onClick(View view) {
		if (view == btVoltar) {
			finish();
		}
	}
}
