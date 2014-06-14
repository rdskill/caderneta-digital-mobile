/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fio.bean;

import java.io.Serializable;
import java.util.List;

public class Professor implements Serializable {
    private Integer idProfessor; 
    private String nome;
    private String nomeUsuario;
    private String senha;
    private List<Leciona> lecionaList;

    public Professor() {
    }

    public Professor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Professor(Integer idProfessor, String nome, String nomeUsuario, String senha) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
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

    public List<Leciona> getLecionaList() {
        return lecionaList;
    }

    public void setLecionaList(List<Leciona> lecionaList) {
        this.lecionaList = lecionaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfessor != null ? idProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.idProfessor == null && other.idProfessor != null) || (this.idProfessor != null && !this.idProfessor.equals(other.idProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "percistencia.Professor[ idProfessor=" + idProfessor + " ]";
    }
    
}
