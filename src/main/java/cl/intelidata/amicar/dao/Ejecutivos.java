/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.dao;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Maze
 */
@Entity
@Table(name = "ejecutivos")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Ejecutivos.findAll", query = "SELECT e FROM Ejecutivos e"), @NamedQuery(name = "Ejecutivos.findByIdEjecutivo", query = "SELECT e FROM Ejecutivos e WHERE e.idEjecutivo = :idEjecutivo"), @NamedQuery(name = "Ejecutivos.findByNombreEjecutivo", query = "SELECT e FROM Ejecutivos e WHERE e.nombreEjecutivo = :nombreEjecutivo"), @NamedQuery(name = "Ejecutivos.findByCorreoEjecutivo", query = "SELECT e FROM Ejecutivos e WHERE e.correoEjecutivo = :correoEjecutivo"), @NamedQuery(name = "Ejecutivos.findByFechaIngreso", query = "SELECT e FROM Ejecutivos e WHERE e.fechaIngreso = :fechaIngreso"), @NamedQuery(name = "Ejecutivos.findByFechaModificacion", query = "SELECT e FROM Ejecutivos e WHERE e.fechaModificacion = :fechaModificacion")})
public class Ejecutivos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false)
	@Column(name = "idEjecutivo", nullable = false) private                           Integer       idEjecutivo;
	@Column(name = "nombreEjecutivo", length = 100) private                           String        nombreEjecutivo;
	@Column(name = "correoEjecutivo", length = 45) private                            String        correoEjecutivo;
	@Column(name = "fechaIngreso") @Temporal(TemporalType.TIMESTAMP) private          Date          fechaIngreso;
	@Column(name = "fechaModificacion", length = 45) private                          String        fechaModificacion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ejecutivosidEjecutivo") private List<Proceso> procesoList;
	@JoinColumn(name = "locales_idLocal1", referencedColumnName = "idLocal", nullable = false)
	@ManyToOne(optional = false) private                                              Locales       localesidLocal1;

	public Ejecutivos() {
	}

	public Ejecutivos(Integer idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}

	public Integer getIdEjecutivo() {
		return idEjecutivo;
	}

	public void setIdEjecutivo(Integer idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}

	public String getNombreEjecutivo() {
		return nombreEjecutivo;
	}

	public void setNombreEjecutivo(String nombreEjecutivo) {
		this.nombreEjecutivo = nombreEjecutivo;
	}

	public String getCorreoEjecutivo() {
		return correoEjecutivo;
	}

	public void setCorreoEjecutivo(String correoEjecutivo) {
		this.correoEjecutivo = correoEjecutivo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@XmlTransient
	public List<Proceso> getProcesoList() {
		return procesoList;
	}

	public void setProcesoList(List<Proceso> procesoList) {
		this.procesoList = procesoList;
	}

	public Locales getLocalesidLocal1() {
		return localesidLocal1;
	}

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
		Ejecutivos other = (Ejecutivos)object;
		if ((this.idEjecutivo == null && other.idEjecutivo != null) || (this.idEjecutivo != null && !this.idEjecutivo.equals(other.idEjecutivo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cl.intelidata.amicar.dao.Ejecutivos[ idEjecutivo=" + idEjecutivo + " ]";
	}

}
