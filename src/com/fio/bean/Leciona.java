/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fio.bean;

import java.io.Serializable;
import java.util.List;

public class Leciona implements Serializable {
    private Integer idLeciona;
    private String periodo;
    private Professor idProfessor;
    private CicloDisciplina idDisciplina;
    private List<Matricula> matriculaList;

    public Leciona() {
    }

    public Leciona(Integer idLeciona) {
        this.idLeciona = idLeciona;
    }

    public Leciona(Integer idLeciona, String periodo) {
        this.idLeciona = idLeciona;
        this.periodo = periodo;
    }

    public Integer getIdLeciona() {
        return idLeciona;
    }

    public void setIdLeciona(Integer idLeciona) {
        this.idLeciona = idLeciona;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Professor getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Professor idProfessor) {
        this.idProfessor = idProfessor;
    }

    public CicloDisciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(CicloDisciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLeciona != null ? idLeciona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leciona)) {
            return false;
        }
        Leciona other = (Leciona) object;
        if ((this.idLeciona == null && other.idLeciona != null) || (this.idLeciona != null && !this.idLeciona.equals(other.idLeciona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "percistencia.Leciona[ idLeciona=" + idLeciona + " ]";
    }
    
}
