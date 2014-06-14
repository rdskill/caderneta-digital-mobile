package com.fio.activity;

import com.fio.tcc.R;
import com.fio.util.FormatarDataUtil;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesNotificacaoActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhenotificacoes);

		String notificacao = getIntent().getStringExtra("arrayNotificacao");
		
		String[] pedacoNotificacao = notificacao.split("/p");

		TextView textTitulo = (TextView) findViewById(R.id.tituloNotificacao);
		TextView textConteudo = (TextView) findViewById(R.id.conteudoNotificacao);
		TextView textData = (TextView) findViewById(R.id.dataNotificacao);
		TextView textDataEvento = (TextView) findViewById(R.id.dataEventoNotificacao);

		
		
		textTitulo.setText(pedacoNotificacao[0]);
		textConteudo.setText(pedacoNotificacao[1]);
		
		FormatarDataUtil fdu = new FormatarDataUtil();
		String dataNotificacao = fdu.formatData(pedacoNotificacao[2]);
		String dataEvento = fdu.formatData(pedacoNotificacao[3]);
		
		textData.setText(dataNotificacao);
		textDataEvento.setText("Data Evento: "+dataEvento);
		
	}

	
	

}
