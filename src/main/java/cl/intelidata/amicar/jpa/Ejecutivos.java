/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maze
 */
@Entity
@Table(name = "ejecutivos")
@NamedQueries({
    @NamedQuery(name = "Ejecutivos.findAll", query = "SELECT e FROM Ejecutivos e"),
    @NamedQuery(name = "Ejecutivos.findByIdEjecutivo", query = "SELECT e FROM Ejecutivos e WHERE e.idEjecutivo = :idEjecutivo"),
    @NamedQuery(name = "Ejecutivos.findByNombreEjecutivo", query = "SELECT e FROM Ejecutivos e WHERE e.nombreEjecutivo = :nombreEjecutivo"),
    @NamedQuery(name = "Ejecutivos.findByCorreoEjecutivo", query = "SELECT e FROM Ejecutivos e WHERE e.correoEjecutivo = :correoEjecutivo"),
    @NamedQuery(name = "Ejecutivos.findByFechaIngreso", query = "SELECT e FROM Ejecutivos e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Ejecutivos.findByFechaModificacion", query = "SELECT e FROM Ejecutivos e WHERE e.fechaModificacion = :fechaModificacion")})
public class Ejecutivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEjecutivo")
    private Integer idEjecutivo;
    @Column(name = "nombreEjecutivo")
    private String nombreEjecutivo;
    @Column(name = "correoEjecutivo")
    private String correoEjecutivo;
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "fechaModificacion")
    private String fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejecutivosidEjecutivo")
    private List<Proceso> procesoList;
    @JoinColumn(name = "locales_idLocal1", referencedColumnName = "idLocal")
    @ManyToOne(optional = false)
    private Locales localesidLocal1;

    /**
     *
     */
    public Ejecutivos() {
    }

    /**
     *
     * @param idEjecutivo
     */
    public Ejecutivos(Integer idEjecutivo) {
        this.idEjecutivo = idEjecutivo;
    }

    /**
     *
     * @return
     */
    public Integer getIdEjecutivo() {
        return idEjecutivo;
    }

    /**
     *
     * @param idEjecutivo
     */
    public void setIdEjecutivo(Integer idEjecutivo) {
        this.idEjecutivo = idEjecutivo;
    }

    /**
     *
     * @return
     */
    public String getNombreEjecutivo() {
        return nombreEjecutivo;
    }

    /**
     *
     * @param nombreEjecutivo
     */
    public void setNombreEjecutivo(String nombreEjecutivo) {
        this.nombreEjecutivo = nombreEjecutivo;
    }

    /**
     *
     * @return
     */
    public String getCorreoEjecutivo() {
        return correoEjecutivo;
    }

    /**
     *
     * @param correoEjecutivo
     */
    public void setCorreoEjecutivo(String correoEjecutivo) {
        this.correoEjecutivo = correoEjecutivo;
    }

    /**
     *
     * @return
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     *
     * @param fechaIngreso
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     *
     * @return
     */
    public String getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     *
     * @param fechaModificacion
     */
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /**
     *
     * @return
     */
    public List<Proceso> getProcesoList() {
        return procesoList;
    }

    /**
     *
     * @param procesoList
     */
    public void setProcesoList(List<Proceso> procesoList) {
        this.procesoList = procesoList;
    }

    /**
     *
     * @return
     */
    public Locales getLocalesidLocal1() {
        return localesidLocal1;
    }

    /**
     *
     * @param localesidLocal1
     */
    public void setLocalesidLocal1(Locales localesidLocal1) {
        this.localesidLocal1 = localesidLocal1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEjecutivo != null ? idEjecutivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejecutivos)) {
            return false;
        }
        Ejecutivos other = (Ejecutivos) object;
        if ((this.idEjecutivo == null && other.idEjecutivo != null) || (this.idEjecutivo != null && !this.idEjecutivo.equals(other.idEjecutivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Ejecutivos[ idEjecutivo=" + idEjecutivo + " ]";
    }
    
}
