/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inan
 */
@Entity
@Table(name = "adresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a"),
    @NamedQuery(name = "Adresa.findByIdAdresa", query = "SELECT a FROM Adresa a WHERE a.idAdresa = :idAdresa"),
    @NamedQuery(name = "Adresa.findByMesto", query = "SELECT a FROM Adresa a WHERE a.mesto = :mesto"),
    @NamedQuery(name = "Adresa.findByUlica", query = "SELECT a FROM Adresa a WHERE a.ulica = :ulica"),
    @NamedQuery(name = "Adresa.findByCisloUlica", query = "SELECT a FROM Adresa a WHERE a.cisloUlica = :cisloUlica"),
    @NamedQuery(name = "Adresa.findByPsc", query = "SELECT a FROM Adresa a WHERE a.psc = :psc")})
public class Adresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adresa")
    private Integer idAdresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "mesto")
    private String mesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cislo_ulica")
    private int cisloUlica;
    @Column(name = "psc")
    private Integer psc;
    @OneToMany(mappedBy = "idAdresa")
    private Collection<Zakaznik> zakaznikCollection;
    @OneToMany(mappedBy = "idAdresa")
    private Collection<Zamestnanec> zamestnanecCollection;

    public Adresa() {
    }

    public Adresa(Integer idAdresa) {
        this.idAdresa = idAdresa;
    }

    public Adresa(Integer idAdresa, String mesto, String ulica, int cisloUlica) {
        this.idAdresa = idAdresa;
        this.mesto = mesto;
        this.ulica = ulica;
        this.cisloUlica = cisloUlica;
    }

    public Integer getIdAdresa() {
        return idAdresa;
    }

    public void setIdAdresa(Integer idAdresa) {
        this.idAdresa = idAdresa;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getCisloUlica() {
        return cisloUlica;
    }

    public void setCisloUlica(int cisloUlica) {
        this.cisloUlica = cisloUlica;
    }

    public Integer getPsc() {
        return psc;
    }

    public void setPsc(Integer psc) {
        this.psc = psc;
    }

    @XmlTransient
    public Collection<Zakaznik> getZakaznikCollection() {
        return zakaznikCollection;
    }

    public void setZakaznikCollection(Collection<Zakaznik> zakaznikCollection) {
        this.zakaznikCollection = zakaznikCollection;
    }

    @XmlTransient
    public Collection<Zamestnanec> getZamestnanecCollection() {
        return zamestnanecCollection;
    }

    public void setZamestnanecCollection(Collection<Zamestnanec> zamestnanecCollection) {
        this.zamestnanecCollection = zamestnanecCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdresa != null ? idAdresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.idAdresa == null && other.idAdresa != null) || (this.idAdresa != null && !this.idAdresa.equals(other.idAdresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Adresa[ idAdresa=" + idAdresa + " ]";
    }
    
}
