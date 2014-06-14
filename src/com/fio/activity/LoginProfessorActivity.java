package com.fio.activity;

import com.fio.bean.Professor;
import com.fio.tcc.R;
import com.fio.webservice.WebService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginProfessorActivity extends Activity implements OnClickListener {
	private Button btLogin;
	private EditText tUsuario;
	private EditText tSenha;
		
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginprofessor);
        
        tUsuario = (EditText) findViewById(R.id.nomeProfessor);
        tSenha = (EditText) findViewById(R.id.senhaProfessor);
        
        btLogin = (Button) findViewById(R.id.btLoginProfessor);
        
		btLogin.setOnClickListener(this);
    }



	public void onClick(View view) {
		if (view == btLogin) {
			String usuario = tUsuario.getText().toString();
			String senha = tSenha.getText().toString();
			
			WebService ws = new WebService();
			Professor professor = ws.loginProfessor(usuario, senha);
			
			if (professor.getNome() != null) {
				
				Intent intent = new Intent (this, MenuProfessorActivity.class);
				intent.putExtra("usuario", professor.getNome());
				intent.putExtra("idProfessor", professor.getIdProfessor());
				startActivity(intent);
			} else {
				Toast.makeText(this, "Usuário ou Senha incorretos", Toast.LENGTH_SHORT).show();
			}
		}
		
	}
}