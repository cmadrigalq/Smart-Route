package entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Parada:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
@Entity
@Table(name = "parada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parada.findAll", query = "SELECT p FROM Parada p")
    , @NamedQuery(name = "Parada.findByIdParada", query = "SELECT p FROM Parada p WHERE p.idParada = :idParada")})
public class Parada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PARADA")
    private Integer idParada;
    @Column(name = "LUGAR")
    private String lugar;
    @JoinColumn(name = "POSICION", referencedColumnName = "ID_POS")
    @ManyToOne
    private Posicion posicion;
    @OneToMany(mappedBy = "paradaFinal")
    private List<Viaje> viajeList;
    @OneToMany(mappedBy = "paradaInicial")
    private List<Viaje> viajeList1;

    public Parada() {
    }

    public Parada(Integer idParada) {
        this.idParada = idParada;
    }

    public Integer getIdParada() {
        return idParada;
    }

    public void setIdParada(Integer idParada) {
        this.idParada = idParada;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @XmlTransient
    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    @XmlTransient
    public List<Viaje> getViajeList1() {
        return viajeList1;
    }

    public void setViajeList1(List<Viaje> viajeList1) {
        this.viajeList1 = viajeList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParada != null ? idParada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parada)) {
            return false;
        }
        Parada other = (Parada) object;
        if ((this.idParada == null && other.idParada != null) || (this.idParada != null && !this.idParada.equals(other.idParada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Parada[ idParada=" + idParada + " ]";
    }

}
