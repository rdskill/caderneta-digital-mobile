/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fio.bean;

import java.io.Serializable;
import java.util.List;


public class CicloDisciplina implements Serializable {
    private Integer idCicloDisciplina;
    private Ciclo idCiclo;
    private Disciplina idDisciplina;
    private List<Leciona> lecionaList;

    public CicloDisciplina() {
    }

    public CicloDisciplina(Integer idCicloDisciplina) {
        this.idCicloDisciplina = idCicloDisciplina;
    }

    public Integer getIdCicloDisciplina() {
        return idCicloDisciplina;
    }

    public void setIdCicloDisciplina(Integer idCicloDisciplina) {
        this.idCicloDisciplina = idCicloDisciplina;
    }

    public Ciclo getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Ciclo idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Disciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Disciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
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
        hash += (idCicloDisciplina != null ? idCicloDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CicloDisciplina)) {
            return false;
        }
        CicloDisciplina other = (CicloDisciplina) object;
        if ((this.idCicloDisciplina == null && other.idCicloDisciplina != null) || (this.idCicloDisciplina != null && !this.idCicloDisciplina.equals(other.idCicloDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "percistencia.CicloDisciplina[ idCicloDisciplina=" + idCicloDisciplina + " ]";
    }
    
}
