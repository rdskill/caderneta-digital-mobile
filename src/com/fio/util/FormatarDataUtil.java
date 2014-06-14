package com.fio.util;

public class FormatarDataUtil {
	public String formatData(String data) {
		String[]dataPartida = data.split("-");
		
		String dia = dataPartida[2];
		String mes = dataPartida[1];
		String ano = dataPartida[0];
		
		data=dia+"/"+mes+"/"+ano;
		return data;
	}
}
