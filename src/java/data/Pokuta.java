/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inan
 */
@Entity
@Table(name = "pokuta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pokuta.findAll", query = "SELECT p FROM Pokuta p"),
    @NamedQuery(name = "Pokuta.findByIdPokuta", query = "SELECT p FROM Pokuta p WHERE p.idPokuta = :idPokuta"),
    @NamedQuery(name = "Pokuta.findByPozicanie", query = "SELECT p FROM Pokuta p WHERE p.pozicanie = :pozicanie"),
    @NamedQuery(name = "Pokuta.findByVratenie", query = "SELECT p FROM Pokuta p WHERE p.vratenie = :vratenie"),
    @NamedQuery(name = "Pokuta.findByCena", query = "SELECT p FROM Pokuta p WHERE p.cena = :cena")})
public class Pokuta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pokuta")
    private Integer idPokuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pozicanie")
    @Temporal(TemporalType.DATE)
    private Date pozicanie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vratenie")
    @Temporal(TemporalType.DATE)
    private Date vratenie;
    @Column(name = "cena")
    private Integer cena;
    @OneToMany(mappedBy = "idPokuta")
    private Collection<Zakaznik> zakaznikCollection;

    public Pokuta() {
    }

    public Pokuta(Integer idPokuta) {
        this.idPokuta = idPokuta;
    }

    public Pokuta(Integer idPokuta, Date pozicanie, Date vratenie) {
        this.idPokuta = idPokuta;
        this.pozicanie = pozicanie;
        this.vratenie = vratenie;
    }

    public Integer getIdPokuta() {
        return idPokuta;
    }

    public void setIdPokuta(Integer idPokuta) {
        this.idPokuta = idPokuta;
    }

    public Date getPozicanie() {
        return pozicanie;
    }

    public void setPozicanie(Date pozicanie) {
        this.pozicanie = pozicanie;
    }

    public Date getVratenie() {
        return vratenie;
    }

    public void setVratenie(Date vratenie) {
        this.vratenie = vratenie;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    @XmlTransient
    public Collection<Zakaznik> getZakaznikCollection() {
        return zakaznikCollection;
    }

    public void setZakaznikCollection(Collection<Zakaznik> zakaznikCollection) {
        this.zakaznikCollection = zakaznikCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPokuta != null ? idPokuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pokuta)) {
            return false;
        }
        Pokuta other = (Pokuta) object;
        if ((this.idPokuta == null && other.idPokuta != null) || (this.idPokuta != null && !this.idPokuta.equals(other.idPokuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Pokuta[ idPokuta=" + idPokuta + " ]";
    }
    
}
