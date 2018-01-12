package entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Posicion:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
@Entity
@Table(name = "posicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posicion.findAll", query = "SELECT p FROM Posicion p")
    , @NamedQuery(name = "Posicion.findByIdPos", query = "SELECT p FROM Posicion p WHERE p.idPos = :idPos")
    , @NamedQuery(name = "Posicion.findByLatitud", query = "SELECT p FROM Posicion p WHERE p.latitud = :latitud")
    , @NamedQuery(name = "Posicion.findByLongitud", query = "SELECT p FROM Posicion p WHERE p.longitud = :longitud")})
public class Posicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POS")
    private Integer idPos;
    
    @Column(name = "LATITUD")
    private Integer latitud;
    
    @Column(name = "LONGITUD")
    private Integer longitud;
    @OneToMany(mappedBy = "posicion")
    private List<Paradamedia> paradamediaList;
    @OneToMany(mappedBy = "posicion")
    private List<Parada> paradaList;

    public Posicion() {
    }

    public Posicion(Integer idPos) {
        this.idPos = idPos;
    }

    public Integer getIdPos() {
        return idPos;
    }

    public void setIdPos(Integer idPos) {
        this.idPos = idPos;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    @XmlTransient
    public List<Paradamedia> getParadamediaList() {
        return paradamediaList;
    }

    public void setParadamediaList(List<Paradamedia> paradamediaList) {
        this.paradamediaList = paradamediaList;
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
        hash += (idPos != null ? idPos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posicion)) {
            return false;
        }
        Posicion other = (Posicion) object;
        if ((this.idPos == null && other.idPos != null) || (this.idPos != null && !this.idPos.equals(other.idPos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Posicion[ idPos=" + idPos + " ]";
    }

}
