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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "zakaznik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zakaznik.findAll", query = "SELECT z FROM Zakaznik z"),
    @NamedQuery(name = "Zakaznik.findByIdZakaznik", query = "SELECT z FROM Zakaznik z WHERE z.idZakaznik = :idZakaznik"),
    @NamedQuery(name = "Zakaznik.findByMeno", query = "SELECT z FROM Zakaznik z WHERE z.meno = :meno"),
    @NamedQuery(name = "Zakaznik.findByPriezvisko", query = "SELECT z FROM Zakaznik z WHERE z.priezvisko = :priezvisko"),
    @NamedQuery(name = "Zakaznik.findByVek", query = "SELECT z FROM Zakaznik z WHERE z.vek = :vek"),
    @NamedQuery(name = "Zakaznik.findByCislo", query = "SELECT z FROM Zakaznik z WHERE z.cislo = :cislo"),
    @NamedQuery(name = "Zakaznik.findByLogin", query = "SELECT z FROM Zakaznik z WHERE z.login = :login"),
    @NamedQuery(name = "Zakaznik.findByHeslo", query = "SELECT z FROM Zakaznik z WHERE z.heslo = :heslo")})
public class Zakaznik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zakaznik")
    private Integer idZakaznik;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "meno")
    private String meno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "priezvisko")
    private String priezvisko;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vek")
    private int vek;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cislo")
    private int cislo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "heslo")
    private String heslo;
    @JoinColumn(name = "id_adresa", referencedColumnName = "id_adresa")
    @ManyToOne
    private Adresa idAdresa;
    @JoinColumn(name = "id_referencie", referencedColumnName = "id_referencie")
    @ManyToOne
    private Referencie idReferencie;
    @JoinColumn(name = "id_pokuta", referencedColumnName = "id_pokuta")
    @ManyToOne
    private Pokuta idPokuta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zakaznik")
    private Collection<Pozicka> pozickaCollection;

    public Zakaznik() {
    }

    public Zakaznik(Integer idZakaznik) {
        this.idZakaznik = idZakaznik;
    }

    public Zakaznik(Integer idZakaznik, String meno, String priezvisko, int vek, int cislo, String login, String heslo) {
        this.idZakaznik = idZakaznik;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
        this.cislo = cislo;
        this.login = login;
        this.heslo = heslo;
    }

    public Integer getIdZakaznik() {
        return idZakaznik;
    }

    public void setIdZakaznik(Integer idZakaznik) {
        this.idZakaznik = idZakaznik;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public int getCislo() {
        return cislo;
    }

    public void setCislo(int cislo) {
        this.cislo = cislo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public Adresa getIdAdresa() {
        return idAdresa;
    }

    public void setIdAdresa(Adresa idAdresa) {
        this.idAdresa = idAdresa;
    }

    public Referencie getIdReferencie() {
        return idReferencie;
    }

    public void setIdReferencie(Referencie idReferencie) {
        this.idReferencie = idReferencie;
    }

    public Pokuta getIdPokuta() {
        return idPokuta;
    }

    public void setIdPokuta(Pokuta idPokuta) {
        this.idPokuta = idPokuta;
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
        hash += (idZakaznik != null ? idZakaznik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zakaznik)) {
            return false;
        }
        Zakaznik other = (Zakaznik) object;
        if ((this.idZakaznik == null && other.idZakaznik != null) || (this.idZakaznik != null && !this.idZakaznik.equals(other.idZakaznik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Zakaznik[ idZakaznik=" + idZakaznik + " ]";
    }
    
}
