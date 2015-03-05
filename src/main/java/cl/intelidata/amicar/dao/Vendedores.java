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
@Table(name = "vendedores")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v"), @NamedQuery(name = "Vendedores.findByIdVendedor", query = "SELECT v FROM Vendedores v WHERE v.idVendedor = :idVendedor"), @NamedQuery(name = "Vendedores.findByRutVendedor", query = "SELECT v FROM Vendedores v WHERE v.rutVendedor = :rutVendedor"), @NamedQuery(name = "Vendedores.findByNombreVendedor", query = "SELECT v FROM Vendedores v WHERE v.nombreVendedor = :nombreVendedor")})
public class Vendedores implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false)
	@Column(name = "idVendedor", nullable = false) private                           Integer       idVendedor;
	@Column(name = "rutVendedor", length = 12) private                               String        rutVendedor;
	@Column(name = "nombreVendedor", length = 100) private                           String        nombreVendedor;
	@JoinColumn(name = "locales_idLocal", referencedColumnName = "idLocal", nullable = false)
	@ManyToOne(optional = false) private                                             Locales       localesidLocal;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedoresidVendedor") private List<Proceso> procesoList;

	public Vendedores() {
	}

	public Vendedores(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getRutVendedor() {
		return rutVendedor;
	}

	public void setRutVendedor(String rutVendedor) {
		this.rutVendedor = rutVendedor;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public Locales getLocalesidLocal() {
		return localesidLocal;
	}

	public void setLocalesidLocal(Locales localesidLocal) {
		this.localesidLocal = localesidLocal;
	}

	@XmlTransient
	public List<Proceso> getProcesoList() {
		return procesoList;
	}

	public void setProcesoList(List<Proceso> procesoList) {
		this.procesoList = procesoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idVendedor != null ? idVendedor.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Vendedores)) {
			return false;
		}
		Vendedores other = (Vendedores)object;
		if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cl.intelidata.amicar.dao.Vendedores[ idVendedor=" + idVendedor + " ]";
	}

}
