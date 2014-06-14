/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fio.bean;

import java.io.Serializable;
import java.util.Date;

public class Frequencia implements Serializable {
    private Integer idFrequencia;
    private String situacao;
    private Date data;
    private Matricula idMatricula;

    public Frequencia() {
    }

    public Frequencia(Integer idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public Frequencia(Integer idFrequencia, String situacao, Date data) {
        this.idFrequencia = idFrequencia;
        this.situacao = situacao;
        this.data = data;
    }

    public Integer getIdFrequencia() {
        return idFrequencia;
    }

    public void setIdFrequencia(Integer idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Matricula getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Matricula idMatricula) {
        this.idMatricula = idMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFrequencia != null ? idFrequencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frequencia)) {
            return false;
        }
        Frequencia other = (Frequencia) object;
        if ((this.idFrequencia == null && other.idFrequencia != null) || (this.idFrequencia != null && !this.idFrequencia.equals(other.idFrequencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "percistencia.Frequencia[ idFrequencia=" + idFrequencia + " ]";
    }
    
}
