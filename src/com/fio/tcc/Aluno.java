package com.fio.tcc;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private String nome;
	private int ra;
	
	public static List<Aluno> getListaDocumentos(){
		List<Aluno> list = new ArrayList<Aluno>();
		for (int i = 0; i < 20; i++) {
			Aluno aluno = new Aluno();
			aluno.nome = "Aluno " + i;
			aluno.ra = i + 1;
			list.add(aluno);
		}
		return list;
	} 
}
