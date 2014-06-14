package com.fio.util;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.fio.bean.Aluno;
import com.fio.tcc.R;
import com.fio.webservice.WebService;

public class ListaAlunoAdapter extends BaseAdapter implements OnCheckedChangeListener {
	private Context context;
	private List<Aluno> alunoList;
	TextView textNome;
	ToggleButton toggleChamada;
	String presencaAluno = "";
	WebService ws = new WebService();

	public ListaAlunoAdapter(Context context, List<Aluno> alunolist) {
		this.context = context;
		this.alunoList = alunolist;
	}

	public int getCount() {
		return alunoList.size();
	}

	public Object getItem(int position) {
		return alunoList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// Recupera o aluno da posição atual
		Aluno aluno = alunoList.get(position);

		// Cria uma instância do layout XML para os objetos correspondentes
		// na View
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.itens_lista_chamada, null);

		// Nome Aluno
		textNome = (TextView) view.findViewById(R.id.nomesAlunosChamada);
		textNome.setText(aluno.getNome());

		// Toggle Aluno
		toggleChamada = (ToggleButton) view.findViewById(R.id.toggleChamada);
		toggleChamada.setTag(aluno.getNome()+"."+aluno.getPresenca()+"."+aluno.getIdFrequencia()+"."+aluno.getIdMatricula());
		if(aluno.getPresenca().equals("p")) {
			toggleChamada.setChecked(true);
		} else {
			toggleChamada.setChecked(false);
		}
		
		toggleChamada.setOnCheckedChangeListener(this);

		return view;
	}

	
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		String[] alunoArray = buttonView.getTag().toString().split("\\.");
		if (isChecked){
			ws.lancarFrequenciaAluno("p",alunoArray[2],alunoArray[3]);
		} else {
			ws.lancarFrequenciaAluno("f",alunoArray[2],alunoArray[3]);
		}			
		
	}

}
