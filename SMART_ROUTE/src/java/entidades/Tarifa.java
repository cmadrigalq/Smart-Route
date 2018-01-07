package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Tarifa:
 *
 * @version 1.0.0  
 * @author Cynthia Madrigal Quesada
 * @date 06/01/2018
 */
@Entity
@Table(name = "tarifa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t")
    , @NamedQuery(name = "Tarifa.findByIdTarifa", query = "SELECT t FROM Tarifa t WHERE t.idTarifa = :idTarifa")
    , @NamedQuery(name = "Tarifa.findByTarifa", query = "SELECT t FROM Tarifa t WHERE t.tarifa = :tarifa")
    , @NamedQuery(name = "Tarifa.findByInicio", query = "SELECT t FROM Tarifa t WHERE t.inicio = :inicio")})
public class Tarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TARIFA")
    private Integer idTarifa;
    @Column(name = "TARIFA")
    private Integer tarifa;
    @Column(name = "INICIO")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @OneToMany(mappedBy = "tarifa")
    private List<Ruta> rutaList;

    public Tarifa() {
    }

    public Tarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Integer getTarifa() {
        return tarifa;
    }

    public void setTarifa(Integer tarifa) {
        this.tarifa = tarifa;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    @XmlTransient
    public List<Ruta> getRutaList() {
        return rutaList;
    }

    public void setRutaList(List<Ruta> rutaList) {
        this.rutaList = rutaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifa != null ? idTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.idTarifa == null && other.idTarifa != null) || (this.idTarifa != null && !this.idTarifa.equals(other.idTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tarifa[ idTarifa=" + idTarifa + " ]";
    }

}
