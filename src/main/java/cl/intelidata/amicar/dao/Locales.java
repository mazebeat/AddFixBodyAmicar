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
import java.util.List;

/**
 * @author Maze
 */
@Entity
@Table(name = "locales")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Locales.findAll", query = "SELECT l FROM Locales l"), @NamedQuery(name = "Locales.findByIdLocal", query = "SELECT l FROM Locales l WHERE l.idLocal = :idLocal"), @NamedQuery(name = "Locales.findByNombreLocal", query = "SELECT l FROM Locales l WHERE l.nombreLocal = :nombreLocal")})
public class Locales implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false)
	@Column(name = "idLocal", nullable = false) private                         Integer          idLocal;
	@Column(name = "nombreLocal", length = 255) private                         String           nombreLocal;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "localesidLocal") private  List<Vendedores> vendedoresList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "localesidLocal1") private List<Ejecutivos> ejecutivosList;

	public Locales() {
	}

	public Locales(Integer idLocal) {
		this.idLocal = idLocal;
	}

	public Integer getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	@XmlTransient
	public List<Vendedores> getVendedoresList() {
		return vendedoresList;
	}

	public void setVendedoresList(List<Vendedores> vendedoresList) {
		this.vendedoresList = vendedoresList;
	}

	@XmlTransient
	public List<Ejecutivos> getEjecutivosList() {
		return ejecutivosList;
	}

	public void setEjecutivosList(List<Ejecutivos> ejecutivosList) {
		this.ejecutivosList = ejecutivosList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idLocal != null ? idLocal.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Locales)) {
			return false;
		}
		Locales other = (Locales)object;
		if ((this.idLocal == null && other.idLocal != null) || (this.idLocal != null && !this.idLocal.equals(other.idLocal))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cl.intelidata.amicar.dao.Locales[ idLocal=" + idLocal + " ]";
	}

}
