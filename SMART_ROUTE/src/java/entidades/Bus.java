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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @date 14/01/2018
 */
@Entity
@Table(name = "bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b")
    , @NamedQuery(name = "Bus.findById", query = "SELECT b FROM Bus b WHERE b.id = :id")
    , @NamedQuery(name = "Bus.findByRuta", query = "SELECT b FROM Bus b WHERE b.ruta1 = :ruta or b.ruta2 = :ruta")
    , @NamedQuery(name = "Bus.findByTarifa", query = "SELECT b FROM Bus b WHERE b.tarifa = :tarifa")})
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tarifa")
    private int tarifa;
    @JoinColumn(name = "empresa", referencedColumnName = "nombre")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;
    @JoinColumn(name = "ruta1", referencedColumnName = "nombre")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ruta ruta1;
    @JoinColumn(name = "ruta2", referencedColumnName = "nombre")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ruta ruta2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bus", fetch = FetchType.LAZY)
    private List<Horario> horarioList;

    public Bus() {
    }

    public Bus(Long id) {
        this.id = id;
    }

    public Bus(Long id, String descripcion, int tarifa) {
        this.id = id;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Ruta getRuta1() {
        return ruta1;
    }

    public void setRuta1(Ruta ruta1) {
        this.ruta1 = ruta1;
    }

    public Ruta getRuta2() {
        return ruta2;
    }

    public void setRuta2(Ruta ruta2) {
        this.ruta2 = ruta2;
    }

    @XmlTransient
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
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
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bus[ id=" + id + " ]";
    }

}
