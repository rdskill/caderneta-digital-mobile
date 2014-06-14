/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fio.bean;

import java.io.Serializable;
import java.util.List;

public class Disciplina implements Serializable {
    private Integer idDisciplina;
    private String nome;
    private int cargaHoraria;
    private List<CicloDisciplina> cicloDisciplinaList;

    public Disciplina() {
    }

    public Disciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Disciplina(Integer idDisciplina, String nome, int cargaHoraria) {
        this.idDisciplina = idDisciplina;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<CicloDisciplina> getCicloDisciplinaList() {
        return cicloDisciplinaList;
    }

    public void setCicloDisciplinaList(List<CicloDisciplina> cicloDisciplinaList) {
        this.cicloDisciplinaList = cicloDisciplinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisciplina != null ? idDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.idDisciplina == null && other.idDisciplina != null) || (this.idDisciplina != null && !this.idDisciplina.equals(other.idDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "percistencia.Disciplina[ idDisciplina=" + idDisciplina + " ]";
    }
    
}
