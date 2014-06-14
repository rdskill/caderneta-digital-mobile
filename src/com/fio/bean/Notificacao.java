/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fio.bean;

import java.io.Serializable;
import java.util.Date;



public class Notificacao implements Serializable {
    private Integer idNotificacao;
    private String titulo;
    private String conteudo;
    private Date data;
    private Date dataEvento;
    private UsuarioSecretaria idUsuarioSecretaria;

    public Notificacao() {
    }

    public Notificacao(Integer idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public Notificacao(Integer idNotificacao, String titulo, String conteudo, Date data, Date dataEvento) {
        this.idNotificacao = idNotificacao;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
        this.dataEvento = dataEvento;
    }

    public Integer getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(Integer idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public UsuarioSecretaria getIdUsuarioSecretaria() {
        return idUsuarioSecretaria;
    }

    public void setIdUsuarioSecretaria(UsuarioSecretaria idUsuarioSecretaria) {
        this.idUsuarioSecretaria = idUsuarioSecretaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacao != null ? idNotificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Notificacao)) {
            return false;
        }
        Notificacao other = (Notificacao) object;
        if ((this.idNotificacao == null && other.idNotificacao != null) || (this.idNotificacao != null && !this.idNotificacao.equals(other.idNotificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "percistencia.Notificacao[ idNotificacao=" + idNotificacao + " ]";
    }
    
}
