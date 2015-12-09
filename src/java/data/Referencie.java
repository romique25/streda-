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
@Table(name = "referencie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencie.findAll", query = "SELECT r FROM Referencie r"),
    @NamedQuery(name = "Referencie.findByIdReferencie", query = "SELECT r FROM Referencie r WHERE r.idReferencie = :idReferencie"),
    @NamedQuery(name = "Referencie.findByNazov", query = "SELECT r FROM Referencie r WHERE r.nazov = :nazov")})
public class Referencie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_referencie")
    private Integer idReferencie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nazov")
    private String nazov;
    @OneToMany(mappedBy = "idReferencie")
    private Collection<Zakaznik> zakaznikCollection;

    public Referencie() {
    }

    public Referencie(Integer idReferencie) {
        this.idReferencie = idReferencie;
    }

    public Referencie(Integer idReferencie, String nazov) {
        this.idReferencie = idReferencie;
        this.nazov = nazov;
    }

    public Integer getIdReferencie() {
        return idReferencie;
    }

    public void setIdReferencie(Integer idReferencie) {
        this.idReferencie = idReferencie;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
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
        hash += (idReferencie != null ? idReferencie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencie)) {
            return false;
        }
        Referencie other = (Referencie) object;
        if ((this.idReferencie == null && other.idReferencie != null) || (this.idReferencie != null && !this.idReferencie.equals(other.idReferencie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Referencie[ idReferencie=" + idReferencie + " ]";
    }
    
}
