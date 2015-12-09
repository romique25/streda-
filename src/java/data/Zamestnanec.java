/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inan
 */
@Entity
@Table(name = "zamestnanec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zamestnanec.findAll", query = "SELECT z FROM Zamestnanec z"),
    @NamedQuery(name = "Zamestnanec.findByIdZamestnanec", query = "SELECT z FROM Zamestnanec z WHERE z.idZamestnanec = :idZamestnanec"),
    @NamedQuery(name = "Zamestnanec.findByMeno", query = "SELECT z FROM Zamestnanec z WHERE z.meno = :meno"),
    @NamedQuery(name = "Zamestnanec.findByPriezvisko", query = "SELECT z FROM Zamestnanec z WHERE z.priezvisko = :priezvisko"),
    @NamedQuery(name = "Zamestnanec.findByVek", query = "SELECT z FROM Zamestnanec z WHERE z.vek = :vek"),
    @NamedQuery(name = "Zamestnanec.findByCislo", query = "SELECT z FROM Zamestnanec z WHERE z.cislo = :cislo"),
    @NamedQuery(name = "Zamestnanec.findByLogin", query = "SELECT z FROM Zamestnanec z WHERE z.login = :login"),
    @NamedQuery(name = "Zamestnanec.findByHeslo", query = "SELECT z FROM Zamestnanec z WHERE z.heslo = :heslo")})
public class Zamestnanec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zamestnanec")
    private Integer idZamestnanec;
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

    public Zamestnanec() {
    }

    public Zamestnanec(Integer idZamestnanec) {
        this.idZamestnanec = idZamestnanec;
    }

    public Zamestnanec(Integer idZamestnanec, String meno, String priezvisko, int vek, int cislo, String login, String heslo) {
        this.idZamestnanec = idZamestnanec;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
        this.cislo = cislo;
        this.login = login;
        this.heslo = heslo;
    }

    public Integer getIdZamestnanec() {
        return idZamestnanec;
    }

    public void setIdZamestnanec(Integer idZamestnanec) {
        this.idZamestnanec = idZamestnanec;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZamestnanec != null ? idZamestnanec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zamestnanec)) {
            return false;
        }
        Zamestnanec other = (Zamestnanec) object;
        if ((this.idZamestnanec == null && other.idZamestnanec != null) || (this.idZamestnanec != null && !this.idZamestnanec.equals(other.idZamestnanec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Zamestnanec[ idZamestnanec=" + idZamestnanec + " ]";
    }
    
}
