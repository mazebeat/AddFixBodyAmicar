/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.dao;

import cl.intelidata.amicar.jpa.ClientesJpaController;

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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"), @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente"), @NamedQuery(name = "Clientes.findByRutCliente", query = "SELECT c FROM Clientes c WHERE c.rutCliente = :rutCliente"), @NamedQuery(name = "Clientes.findByEmailCliente", query = "SELECT c FROM Clientes c WHERE c.emailCliente = :emailCliente"), @NamedQuery(name = "Clientes.findByNombreCliente", query = "SELECT c FROM Clientes c WHERE c.nombreCliente = :nombreCliente"), @NamedQuery(name = "Clientes.findBySexoCliente", query = "SELECT c FROM Clientes c WHERE c.sexoCliente = :sexoCliente"), @NamedQuery(name = "Clientes.findByFonoCliente", query = "SELECT c FROM Clientes c WHERE c.fonoCliente = :fonoCliente"), @NamedQuery(name = "Clientes.findByAutomovilCliente", query = "SELECT c FROM Clientes c WHERE c.automovilCliente = :automovilCliente"), @NamedQuery(name = "Clientes.findByIdGrupo", query = "SELECT c FROM Clientes c WHERE c.idGrupo = :idGrupo"), @NamedQuery(name = "Clientes.findByIdBody", query = "SELECT c FROM Clientes c WHERE c.idBody = :idBody"), @NamedQuery(name = "Clientes.findByFecha", query = "SELECT c FROM Clientes c WHERE c.fecha = :fecha"), @NamedQuery(name = "Clientes.findByRutAndEmailCliente", query = "SELECT c FROM Clientes c WHERE c.rutCliente = :rutCliente AND c.emailCliente = :emailCliente")})
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false)
	@Column(name = "idCliente", nullable = false) private                         Integer       idCliente;
	@Column(name = "rutCliente", length = 12) private                             String        rutCliente;
	@Column(name = "emailCliente", length = 45) private                           String        emailCliente;
	@Column(name = "nombreCliente", length = 45) private                          String        nombreCliente;
	@Column(name = "sexoCliente", length = 2) private                             String        sexoCliente;
	@Column(name = "fonoCliente", length = 45) private                            String        fonoCliente;
	@Column(name = "automovilCliente", length = 45) private                       String        automovilCliente;
	@Column(name = "idGrupo") private                                             Integer       idGrupo;
	@Column(name = "idBody") private                                              Integer       idBody;
	@Column(name = "fecha") @Temporal(TemporalType.TIMESTAMP) private             Date          fecha;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientesidCliente") private List<Proceso> procesoList;

	public Clientes() {
	}

	public Clientes(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getSexoCliente() {
		return sexoCliente;
	}

	public void setSexoCliente(String sexoCliente) {
		this.sexoCliente = sexoCliente;
	}

	public String getFonoCliente() {
		return fonoCliente;
	}

	public void setFonoCliente(String fonoCliente) {
		this.fonoCliente = fonoCliente;
	}

	public String getAutomovilCliente() {
		return automovilCliente;
	}

	public void setAutomovilCliente(String automovilCliente) {
		this.automovilCliente = automovilCliente;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Integer getIdBody() {
		return idBody;
	}

	public void setIdBody(Integer idBody) {
		this.idBody = idBody;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
		hash += (idCliente != null ? idCliente.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Clientes)) {
			return false;
		}
		Clientes other = (Clientes)object;
		if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cl.intelidata.amicar.dao.Clientes[ idCliente=" + idCliente + " ]";
	}

	public Clientes findByRutAndMail(String rut, String mail) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AddFixBody");
		ClientesJpaController cjpa = new ClientesJpaController(emf);
		return cjpa.findByRutAndMail(rut, mail);
	}

}
