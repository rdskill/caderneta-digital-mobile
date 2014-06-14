/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fio.bean;

import java.io.Serializable;
import java.util.List;

public class TipoNota implements Serializable {
    private Integer idTipoNota;
    private String tipoNota;
    private List<Nota> notaList;

    public TipoNota() {
    }

    public TipoNota(Integer idTipoNota) {
        this.idTipoNota = idTipoNota;
    }

    public TipoNota(Integer idTipoNota, String tipoNota) {
        this.idTipoNota = idTipoNota;
        this.tipoNota = tipoNota;
    }

    public Integer getIdTipoNota() {
        return idTipoNota;
    }

    public void setIdTipoNota(Integer idTipoNota) {
        this.idTipoNota = idTipoNota;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoNota != null ? idTipoNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoNota)) {
            return false;
        }
        TipoNota other = (TipoNota) object;
        if ((this.idTipoNota == null && other.idTipoNota != null) || (this.idTipoNota != null && !this.idTipoNota.equals(other.idTipoNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "percistencia.TipoNota[ idTipoNota=" + idTipoNota + " ]";
    }
    
}
