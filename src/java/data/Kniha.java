/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "kniha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kniha.findAll", query = "SELECT k FROM Kniha k"),
    @NamedQuery(name = "Kniha.findByIdKniha", query = "SELECT k FROM Kniha k WHERE k.idKniha = :idKniha"),
    @NamedQuery(name = "Kniha.findByNazov", query = "SELECT k FROM Kniha k WHERE k.nazov = :nazov"),
    @NamedQuery(name = "Kniha.findByAutor", query = "SELECT k FROM Kniha k WHERE k.autor = :autor"),
    @NamedQuery(name = "Kniha.findByRokVydania", query = "SELECT k FROM Kniha k WHERE k.rokVydania = :rokVydania"),
    @NamedQuery(name = "Kniha.findByVydavatelstvo", query = "SELECT k FROM Kniha k WHERE k.vydavatelstvo = :vydavatelstvo"),
    @NamedQuery(name = "Kniha.findByStav", query = "SELECT k FROM Kniha k WHERE k.stav = :stav")})
public class Kniha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_kniha")
    private Integer idKniha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nazov")
    private String nazov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rok_vydania")
    private int rokVydania;
    @Size(max = 25)
    @Column(name = "vydavatelstvo")
    private String vydavatelstvo;
    @Size(max = 15)
    @Column(name = "stav")
    private String stav;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kniha")
    private Collection<Pozicka> pozickaCollection;

    public Kniha() {
    }

    public Kniha(Integer idKniha) {
        this.idKniha = idKniha;
    }

    public Kniha(Integer idKniha, String nazov, String autor, int rokVydania) {
        this.idKniha = idKniha;
        this.nazov = nazov;
        this.autor = autor;
        this.rokVydania = rokVydania;
    }

    public Integer getIdKniha() {
        return idKniha;
    }

    public void setIdKniha(Integer idKniha) {
        this.idKniha = idKniha;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getRokVydania() {
        return rokVydania;
    }

    public void setRokVydania(int rokVydania) {
        this.rokVydania = rokVydania;
    }

    public String getVydavatelstvo() {
        return vydavatelstvo;
    }

    public void setVydavatelstvo(String vydavatelstvo) {
        this.vydavatelstvo = vydavatelstvo;
    }

    public String getStav() {
        return stav;
    }

    public void setStav(String stav) {
        this.stav = stav;
    }

    @XmlTransient
    public Collection<Pozicka> getPozickaCollection() {
        return pozickaCollection;
    }

    public void setPozickaCollection(Collection<Pozicka> pozickaCollection) {
        this.pozickaCollection = pozickaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKniha != null ? idKniha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kniha)) {
            return false;
        }
        Kniha other = (Kniha) object;
        if ((this.idKniha == null && other.idKniha != null) || (this.idKniha != null && !this.idKniha.equals(other.idKniha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Kniha[ idKniha=" + idKniha + " ]";
    }
    
}
