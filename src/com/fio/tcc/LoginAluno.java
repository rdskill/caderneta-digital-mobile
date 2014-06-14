package com.fio.tcc;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAluno extends Activity implements OnClickListener {
	private Button btCancelar;
	private Button btLogin;
	private EditText tUsuario;
	private EditText tSenha;
	
	private final String LOGIN = "admin";
	private final String SENHA = "123";


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginaluno);
		
		tUsuario = (EditText) findViewById(R.id.nomeAluno);
		tSenha = (EditText) findViewById(R.id.senhaAluno);
		
		btCancelar = (Button) findViewById(R.id.btCancelarAluno);
		btLogin = (Button) findViewById(R.id.btLoginAluno);
		
		btCancelar.setOnClickListener(this);
		btLogin.setOnClickListener(this);
		

	}


	public void onClick(View view) {
		if (view == btCancelar) {
			finish();
		}
		if (view == btLogin) {
			String usuario = tUsuario.getText().toString();
			String senha = tSenha.getText().toString();
			
			usuario = usuario.toLowerCase();
			senha = senha.toLowerCase();
			
			Log.i("tccmobile", "Usuario informado: " + usuario);
			Log.i("tccmobile", "Senha informada: " + senha);
			
			if (usuario.equals(LOGIN) && senha.equals(SENHA)) {
				Intent intent = new Intent (this, MenuAluno.class);
				intent.putExtra("usuario", usuario);
				startActivity(intent);
			} else {
				Toast.makeText(this, "Usuário ou Senha incorretos", Toast.LENGTH_SHORT).show();
			}
		}
		
	}
}