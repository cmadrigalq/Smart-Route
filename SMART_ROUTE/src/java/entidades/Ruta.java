package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Ruta:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 14/01/2018
 */
@Entity
@Table(name = "ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r")
    , @NamedQuery(name = "Ruta.findByNombre", query = "SELECT r FROM Ruta r WHERE r.nombre = :nombre")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta1", fetch = FetchType.LAZY)
    private List<Bus> busList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta2", fetch = FetchType.LAZY)
    private List<Bus> busList1;
    @JoinColumn(name = "primeraParada", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Parada primeraParada;
    @JoinColumn(name = "ultimaParada", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Parada ultimaParada;

    public Ruta() {
    }

    public Ruta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    @XmlTransient
    public List<Bus> getBusList1() {
        return busList1;
    }

    public void setBusList1(List<Bus> busList1) {
        this.busList1 = busList1;
    }

    public Parada getPrimeraParada() {
        return primeraParada;
    }

    public void setPrimeraParada(Parada primeraParada) {
        this.primeraParada = primeraParada;
    }

    public Parada getUltimaParada() {
        return ultimaParada;
    }

    public void setUltimaParada(Parada ultimaParada) {
        this.ultimaParada = ultimaParada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ruta[ nombre=" + nombre + " ]";
    }

}
