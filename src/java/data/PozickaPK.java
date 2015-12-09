/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author inan
 */
@Embeddable
public class PozickaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_zakaznik")
    private int idZakaznik;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_kniha")
    private int idKniha;

    public PozickaPK() {
    }

    public PozickaPK(int idZakaznik, int idKniha) {
        this.idZakaznik = idZakaznik;
        this.idKniha = idKniha;
    }

    public int getIdZakaznik() {
        return idZakaznik;
    }

    public void setIdZakaznik(int idZakaznik) {
        this.idZakaznik = idZakaznik;
    }

    public int getIdKniha() {
        return idKniha;
    }

    public void setIdKniha(int idKniha) {
        this.idKniha = idKniha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idZakaznik;
        hash += (int) idKniha;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PozickaPK)) {
            return false;
        }
        PozickaPK other = (PozickaPK) object;
        if (this.idZakaznik != other.idZakaznik) {
            return false;
        }
        if (this.idKniha != other.idKniha) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.PozickaPK[ idZakaznik=" + idZakaznik + ", idKniha=" + idKniha + " ]";
    }
    
}
