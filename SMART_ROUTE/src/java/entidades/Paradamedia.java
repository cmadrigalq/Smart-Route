package entidades;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Paradamedia:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
@Entity
@Table(name = "paradamedia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paradamedia.findAll", query = "SELECT p FROM Paradamedia p")
    , @NamedQuery(name = "Paradamedia.findByIdParadaM", query = "SELECT p FROM Paradamedia p WHERE p.idParadaM = :idParadaM")
    , @NamedQuery(name = "Paradamedia.findByLugar", query = "SELECT p FROM Paradamedia p WHERE p.lugar = :lugar")})
public class Paradamedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PARADA_M")
    private Integer idParadaM;
    @Column(name = "LUGAR")
    private String lugar;
    @JoinColumn(name = "POSICION", referencedColumnName = "ID_POS")
    @ManyToOne
    private Posicion posicion;
    @JoinColumn(name = "VIAJE", referencedColumnName = "ID_VIAJE")
    @ManyToOne
    private Viaje viaje;

    public Paradamedia() {
    }

    public Paradamedia(Integer idParadaM) {
        this.idParadaM = idParadaM;
    }

    public Integer getIdParadaM() {
        return idParadaM;
    }

    public void setIdParadaM(Integer idParadaM) {
        this.idParadaM = idParadaM;
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

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParadaM != null ? idParadaM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paradamedia)) {
            return false;
        }
        Paradamedia other = (Paradamedia) object;
        if ((this.idParadaM == null && other.idParadaM != null) || (this.idParadaM != null && !this.idParadaM.equals(other.idParadaM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Paradamedia[ idParadaM=" + idParadaM + " ]";
    }

}
