/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inan
 */
@Entity
@Table(name = "pozicka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pozicka.findAll", query = "SELECT p FROM Pozicka p"),
    @NamedQuery(name = "Pozicka.findByIdZakaznik", query = "SELECT p FROM Pozicka p WHERE p.pozickaPK.idZakaznik = :idZakaznik"),
    @NamedQuery(name = "Pozicka.findByIdKniha", query = "SELECT p FROM Pozicka p WHERE p.pozickaPK.idKniha = :idKniha"),
    @NamedQuery(name = "Pozicka.findByPopis", query = "SELECT p FROM Pozicka p WHERE p.popis = :popis")})
public class Pozicka implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PozickaPK pozickaPK;
    @Size(max = 100)
    @Column(name = "popis")
    private String popis;
    @JoinColumn(name = "id_zakaznik", referencedColumnName = "id_zakaznik", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zakaznik zakaznik;
    @JoinColumn(name = "id_kniha", referencedColumnName = "id_kniha", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Kniha kniha;

    public Pozicka() {
    }

    public Pozicka(PozickaPK pozickaPK) {
        this.pozickaPK = pozickaPK;
    }

    public Pozicka(int idZakaznik, int idKniha) {
        this.pozickaPK = new PozickaPK(idZakaznik, idKniha);
    }

    public PozickaPK getPozickaPK() {
        return pozickaPK;
    }

    public void setPozickaPK(PozickaPK pozickaPK) {
        this.pozickaPK = pozickaPK;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public Kniha getKniha() {
        return kniha;
    }

    public void setKniha(Kniha kniha) {
        this.kniha = kniha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pozickaPK != null ? pozickaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pozicka)) {
            return false;
        }
        Pozicka other = (Pozicka) object;
        if ((this.pozickaPK == null && other.pozickaPK != null) || (this.pozickaPK != null && !this.pozickaPK.equals(other.pozickaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Pozicka[ pozickaPK=" + pozickaPK + " ]";
    }
    
}
