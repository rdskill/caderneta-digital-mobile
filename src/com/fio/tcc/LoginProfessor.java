package com.fio.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginProfessor extends Activity implements OnClickListener {
	private Button btCancelar;
	private Button btLogin;
	private EditText tUsuario;
	private EditText tSenha;
	
	private final String LOGIN = "admin";
	private final String SENHA = "123";

	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginprofessor);
        
        tUsuario = (EditText) findViewById(R.id.nomeProfessor);
        tSenha = (EditText) findViewById(R.id.senhaProfessor);
        
        btCancelar = (Button) findViewById(R.id.btCancelarProfessor);
        btLogin = (Button) findViewById(R.id.btLoginProfessor);
        
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
			
			
			if (usuario.equals(LOGIN) && senha.equals(SENHA)) {
				Intent intent = new Intent (this, MenuProfessor.class);
				intent.putExtra("usuario", usuario);
				startActivity(intent);
			} else {
				Toast.makeText(this, "Usuário ou Senha incorretos", Toast.LENGTH_SHORT).show();
			}
		}
		
	}
}