package com.fio.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fio.bean.Aluno;
import com.fio.bean.Nota;
import com.fio.bean.Professor;

public class WebService {

	HttpPost httppost = new HttpPost("http://10.0.2.2:8080/TCCWeb/Controlador");
	HttpClient httpclient = new DefaultHttpClient();
	String resposta = null;

	public Aluno loginAluno(String usuario, String senha) {
		Aluno aluno = new Aluno();
		try {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
			nameValuePairs
					.add(new BasicNameValuePair("parametro", "loginAluno"));
			nameValuePairs.add(new BasicNameValuePair("nomeUsuario", usuario));
			nameValuePairs.add(new BasicNameValuePair("senha", senha));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				String[] lista = resposta.split("\\.");
				aluno.setIdAluno(Integer.parseInt(lista[0]));
				aluno.setNome(lista[1]);
				aluno.setNomeUsuario(lista[2]);
				aluno.setRa(Integer.parseInt(lista[3]));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return aluno;
	}

	public Professor loginProfessor(String usuario, String senha) {
		Professor professor = new Professor();
		try {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"loginProfessor"));
			nameValuePairs.add(new BasicNameValuePair("nomeUsuario", usuario));
			nameValuePairs.add(new BasicNameValuePair("senha", senha));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				String[] lista = resposta.split("\\.");
				professor.setIdProfessor(Integer.parseInt(lista[0]));
				professor.setNome(lista[1]);
				professor.setNomeUsuario(lista[2]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return professor;
	}

	public String[] carregaLeciona(int id) {
		String[] lista = null;
		try {

			String idProfessor = "" + id;

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"carregaLeciona"));
			nameValuePairs.add(new BasicNameValuePair("idProfessor",
					idProfessor));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				lista = resposta.split("/n");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;
	}

	public String[] carregaListaChamada(int id) {
		String[] listaChamada = null;
		try {
			String idLeciona = "" + id;

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"carregaListaChamada"));
			nameValuePairs.add(new BasicNameValuePair("idLeciona", idLeciona));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				listaChamada = resposta.split("/n");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return listaChamada;
	}

	public void lancarFrequenciaAluno(String situacao, String idFrequencia,
			String idMatricula) {
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"lancarFrequenciaAluno"));
			nameValuePairs
					.add(new BasicNameValuePair("situacaoAluno", situacao));
			nameValuePairs.add(new BasicNameValuePair("idFrequencia",
					idFrequencia));
			nameValuePairs.add(new BasicNameValuePair("idMatricula",
					idMatricula));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String[] receberNotificacoes() {
		String[] listaNotificacoes = null;
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"receberNotificacoes"));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				listaNotificacoes = resposta.split("/n");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return listaNotificacoes;
	}

	public String[] buscarMateriaAluno(String idAluno) {
		String[] listaMateria = null;
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"buscarMateriaAluno"));
			nameValuePairs.add(new BasicNameValuePair("idAluno", idAluno));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				listaMateria = resposta.split("/n");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return listaMateria;
	}

	public String[] buscarFrequenciaNota(String idMatricula) {
		String[] listaMateria = null;
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"buscarFrequenciaNota"));
			nameValuePairs.add(new BasicNameValuePair("idMatricula",
					idMatricula));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				listaMateria = resposta.split("/n");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return listaMateria;
	}

	public String[] carregaLecionaInteiro(String idProfessor) {
		String[] lista = null;
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"carregaLecionaInteiro"));
			nameValuePairs.add(new BasicNameValuePair("idProfessor",
					idProfessor));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				lista = resposta.split("/n");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;
	}

	public String[] carregaChamadaNotaFrequencia(String idLeciona) {
		String[] lista = null;
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"carregaChamadaNotaFrequencia"));
			nameValuePairs.add(new BasicNameValuePair("idLeciona", idLeciona));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				lista = resposta.split("/n");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;
	}

	public String[] carregaNotasAluno(String idMatricula) {
		String[] lista = null;
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"carregaNotasAluno"));
			nameValuePairs.add(new BasicNameValuePair("idMatricula",
					idMatricula));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);

			if (resposta != null) {
				lista = resposta.split("/n");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;
	}

	public String lancarNotas(ArrayList<Nota> arrayNota, String idMatricula) {
		int idNotaPrimBim = 0;
		float notaPrimeiroBim = -1;
		int idNotaSegBim = 0;
		float notaSegundoBim = -1;
		int idNotaExame = 0;
		float notaExame = -1;
		try {
			if (arrayNota.size() >= 1) {
				if (arrayNota.get(0).getIdNota() != null) {
					idNotaPrimBim = arrayNota.get(0).getIdNota();
				}
				notaPrimeiroBim = arrayNota.get(0).getNota();
			}
			if (arrayNota.size() >= 2) {
				if (arrayNota.get(1).getIdNota() != null) {
					idNotaSegBim = arrayNota.get(1).getIdNota();
				}
				notaSegundoBim = arrayNota.get(1).getNota();
			}
			if (arrayNota.size() == 3) {
				if (arrayNota.get(2).getIdNota() != null) {
					idNotaExame = arrayNota.get(2).getIdNota();
				}
				notaExame = arrayNota.get(2).getNota();
			}

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(8);
			nameValuePairs.add(new BasicNameValuePair("parametro",
					"lancarNotas"));
			nameValuePairs.add(new BasicNameValuePair("idMatricula",
					idMatricula));
			nameValuePairs.add(new BasicNameValuePair("idNotaPrimBim", ""
					+ idNotaPrimBim));
			nameValuePairs.add(new BasicNameValuePair("primeiroBim", ""
					+ notaPrimeiroBim));
			nameValuePairs.add(new BasicNameValuePair("idNotaSegBim", ""
					+ idNotaSegBim));
			nameValuePairs.add(new BasicNameValuePair("segundoBim", ""
					+ notaSegundoBim));
			nameValuePairs.add(new BasicNameValuePair("idNotaExame", ""
					+ idNotaExame));
			nameValuePairs.add(new BasicNameValuePair("exame", "" + notaExame));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse httpresp;

			httpresp = httpclient.execute(httppost);
			HttpEntity entity = httpresp.getEntity();

			resposta = EntityUtils.toString(entity);
		} catch (Exception e) {
			System.out.println(e);
		}
		return resposta;
	}
	
	


}