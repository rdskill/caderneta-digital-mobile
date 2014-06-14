package com.fio.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuInicial extends Activity implements OnClickListener {
	private Button btLoginProfessor;
	private Button btLoginAluno;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btLoginProfessor = (Button) findViewById(R.id.btLoginProfessorMain);
		btLoginAluno = (Button) findViewById(R.id.btLoginAlunoMain);
		btLoginProfessor.setOnClickListener(this);
		btLoginAluno.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view == btLoginProfessor) {
			Intent intent = new Intent(this, LoginProfessor.class);
			startActivity(intent);
		}
		if (view == btLoginAluno) {
			Intent intent2 = new Intent(this, LoginAluno.class);
			startActivity(intent2);
		}
	}

}
