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
 * Parada:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 14/01/2018
 */
@Entity
@Table(name = "parada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parada.findAll", query = "SELECT p FROM Parada p")
    , @NamedQuery(name = "Parada.findById", query = "SELECT p FROM Parada p WHERE p.id = :id")})
public class Parada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "primeraParada", fetch = FetchType.LAZY)
    private List<Ruta> rutaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ultimaParada", fetch = FetchType.LAZY)
    private List<Ruta> rutaList1;
    @OneToMany(mappedBy = "siguienteParada", fetch = FetchType.LAZY)
    private List<Parada> paradaList;
    @JoinColumn(name = "siguienteParada", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Parada siguienteParada;
    @JoinColumn(name = "puntoGeografico", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Punto puntoGeografico;

    public Parada() {
    }

    public Parada(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient
    public List<Ruta> getRutaList() {
        return rutaList;
    }

    public void setRutaList(List<Ruta> rutaList) {
        this.rutaList = rutaList;
    }

    @XmlTransient
    public List<Ruta> getRutaList1() {
        return rutaList1;
    }

    public void setRutaList1(List<Ruta> rutaList1) {
        this.rutaList1 = rutaList1;
    }

    @XmlTransient
    public List<Parada> getParadaList() {
        return paradaList;
    }

    public void setParadaList(List<Parada> paradaList) {
        this.paradaList = paradaList;
    }

    public Parada getSiguienteParada() {
        return siguienteParada;
    }

    public void setSiguienteParada(Parada siguienteParada) {
        this.siguienteParada = siguienteParada;
    }

    public Punto getPuntoGeografico() {
        return puntoGeografico;
    }

    public void setPuntoGeografico(Punto puntoGeografico) {
        this.puntoGeografico = puntoGeografico;
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
        if (!(object instanceof Parada)) {
            return false;
        }
        Parada other = (Parada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Parada[ id=" + id + " ]";
    }

}
