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
 * Viaje:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
@Entity
@Table(name = "viaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v")
    , @NamedQuery(name = "Viaje.findByIdViaje", query = "SELECT v FROM Viaje v WHERE v.idViaje = :idViaje")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VIAJE")
    private Integer idViaje;
    @OneToMany(mappedBy = "viaje")
    private List<Paradamedia> paradamediaList;
    @JoinColumn(name = "BUS", referencedColumnName = "ID_BUS")
    @ManyToOne
    private Bus bus;
    @JoinColumn(name = "HORARIO", referencedColumnName = "ID_HORARIO")
    @ManyToOne
    private Horario horario;
    @JoinColumn(name = "PARADA_FINAL", referencedColumnName = "ID_PARADA")
    @ManyToOne
    private Parada paradaFinal;
    @JoinColumn(name = "PARADA_INICIAL", referencedColumnName = "ID_PARADA")
    @ManyToOne
    private Parada paradaInicial;
    @JoinColumn(name = "RUTA", referencedColumnName = "ID_RUTA")
    @ManyToOne
    private Ruta ruta;

    public Viaje() {
    }

    public Viaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    @XmlTransient
    public List<Paradamedia> getParadamediaList() {
        return paradamediaList;
    }

    public void setParadamediaList(List<Paradamedia> paradamediaList) {
        this.paradamediaList = paradamediaList;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Parada getParadaFinal() {
        return paradaFinal;
    }

    public void setParadaFinal(Parada paradaFinal) {
        this.paradaFinal = paradaFinal;
    }

    public Parada getParadaInicial() {
        return paradaInicial;
    }

    public void setParadaInicial(Parada paradaInicial) {
        this.paradaInicial = paradaInicial;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViaje != null ? idViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.idViaje == null && other.idViaje != null) || (this.idViaje != null && !this.idViaje.equals(other.idViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Viaje[ idViaje=" + idViaje + " ]";
    }

}
