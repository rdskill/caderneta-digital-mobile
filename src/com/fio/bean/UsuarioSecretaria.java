/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fio.bean;

import java.io.Serializable;
import java.util.List;

public class UsuarioSecretaria implements Serializable {
    private Integer idUsuarioSecretaria;
    private String nome;
    private String nomeUsuario;
    private String senha;
    private List<Notificacao> notificacaoList;

    public UsuarioSecretaria() {
    }

    public UsuarioSecretaria(Integer idUsuarioSecretaria) {
        this.idUsuarioSecretaria = idUsuarioSecretaria;
    }

    public UsuarioSecretaria(Integer idUsuarioSecretaria, String nome, String nomeUsuario, String senha) {
        this.idUsuarioSecretaria = idUsuarioSecretaria;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public Integer getIdUsuarioSecretaria() {
        return idUsuarioSecretaria;
    }

    public void setIdUsuarioSecretaria(Integer idUsuarioSecretaria) {
        this.idUsuarioSecretaria = idUsuarioSecretaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Notificacao> getNotificacaoList() {
        return notificacaoList;
    }

    public void setNotificacaoList(List<Notificacao> notificacaoList) {
        this.notificacaoList = notificacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioSecretaria != null ? idUsuarioSecretaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioSecretaria)) {
            return false;
        }
        UsuarioSecretaria other = (UsuarioSecretaria) object;
        if ((this.idUsuarioSecretaria == null && other.idUsuarioSecretaria != null) || (this.idUsuarioSecretaria != null && !this.idUsuarioSecretaria.equals(other.idUsuarioSecretaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "percistencia.UsuarioSecretaria[ idUsuarioSecretaria=" + idUsuarioSecretaria + " ]";
    }
    
}
