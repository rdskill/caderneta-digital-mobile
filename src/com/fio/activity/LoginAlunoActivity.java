package com.fio.activity;

import com.fio.bean.Aluno;
import com.fio.tcc.R;
import com.fio.webservice.WebService;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAlunoActivity extends Activity implements OnClickListener {
	private Button btLogin;
	private EditText tUsuario;
	private EditText tSenha;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginaluno);

		tUsuario = (EditText) findViewById(R.id.nomeAluno);
		tSenha = (EditText) findViewById(R.id.senhaAluno);

		btLogin = (Button) findViewById(R.id.btLoginAluno);

		btLogin.setOnClickListener(this);

	}

	public void onClick(View view) {
		if (view == btLogin) {
			String usuario = tUsuario.getText().toString();
			String senha = tSenha.getText().toString();

			WebService ws = new WebService();
			Aluno aluno = ws.loginAluno(usuario, senha);

			try {
				if (aluno.getNome() != null) {
					Intent intent = new Intent(this, MenuAlunoActivity.class);
					intent.putExtra("usuario", aluno.getNome());
					intent.putExtra("idAluno", aluno.getIdAluno());
					startActivity(intent);
				} else {
					tUsuario.setText("");
					tSenha.setText("");
					Toast.makeText(this, "Usuário ou Senha inválidos.", Toast.LENGTH_SHORT)
					.show();
				}

			} catch (NumberFormatException e) {
				e.printStackTrace();
				Toast.makeText(this, "Digite um ID válido", Toast.LENGTH_SHORT)
						.show();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
				Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			}

			Log.i("tccmobile", "Usuario informado: " + usuario);
			Log.i("tccmobile", "Senha informada: " + senha);

		}

	}
}