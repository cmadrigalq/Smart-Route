package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Punto:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 14/01/2018
 */
@Entity
@Table(name = "punto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punto.findAll", query = "SELECT p FROM Punto p")
    , @NamedQuery(name = "Punto.findById", query = "SELECT p FROM Punto p WHERE p.id = :id")
    , @NamedQuery(name = "Punto.findByLatitud", query = "SELECT p FROM Punto p WHERE p.latitud = :latitud")
    , @NamedQuery(name = "Punto.findByLongitud", query = "SELECT p FROM Punto p WHERE p.longitud = :longitud")})
public class Punto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "latitud")
    private double latitud;
    @Basic(optional = false)
    @Column(name = "longitud")
    private double longitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puntoGeografico", fetch = FetchType.LAZY)
    private List<Parada> paradaList;

    public Punto() {
    }

    public Punto(Long id) {
        this.id = id;
    }

    public Punto(Long id, double latitud, double longitud) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @XmlTransient
    public List<Parada> getParadaList() {
        return paradaList;
    }

    public void setParadaList(List<Parada> paradaList) {
        this.paradaList = paradaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punto)) {
            return false;
        }
        Punto other = (Punto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Punto[ id=" + id + " ]";
    }

}
