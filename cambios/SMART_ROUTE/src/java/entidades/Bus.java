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
 * Bus:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
@Entity
@Table(name = "bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b")
    , @NamedQuery(name = "Bus.findByIdBus", query = "SELECT b FROM Bus b WHERE b.idBus = :idBus")
    , @NamedQuery(name = "Bus.findByNombre", query = "SELECT b FROM Bus b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "Bus.findByCantPasajeros", query = "SELECT b FROM Bus b WHERE b.cantPasajeros = :cantPasajeros")})
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BUS")
    private Integer idBus;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CANT_PASAJEROS")
    private Integer cantPasajeros;
    @OneToMany(mappedBy = "bus")
    private List<Viaje> viajeList;

    public Bus() {
    }

    public Bus(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(Integer cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    @XmlTransient
    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBus != null ? idBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.idBus == null && other.idBus != null) || (this.idBus != null && !this.idBus.equals(other.idBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bus[ idBus=" + idBus + " ]";
    }

}
