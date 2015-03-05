/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.dao;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Maze
 */
@Entity
@Table(name = "body")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Body.findAll", query = "SELECT b FROM Body b"), @NamedQuery(name = "Body.findByIdBody", query = "SELECT b FROM Body b WHERE b.idBody = :idBody"), @NamedQuery(name = "Body.findByBodyNombre", query = "SELECT b FROM Body b WHERE b.bodyNombre = :bodyNombre")})
public class Body implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Basic(optional = false) @Column(name = "idBody", nullable = false) private Integer idBody;
	@Column(name = "bodyNombre", length = 45) private                               String  bodyNombre;

	public Body() {
	}

	public Body(Integer idBody) {
		this.idBody = idBody;
	}

	public Integer getIdBody() {
		return idBody;
	}

	public void setIdBody(Integer idBody) {
		this.idBody = idBody;
	}

	public String getBodyNombre() {
		return bodyNombre;
	}

	public void setBodyNombre(String bodyNombre) {
		this.bodyNombre = bodyNombre;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idBody != null ? idBody.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Body)) {
			return false;
		}
		Body other = (Body)object;
		if ((this.idBody == null && other.idBody != null) || (this.idBody != null && !this.idBody.equals(other.idBody))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cl.intelidata.amicar.dao.Body[ idBody=" + idBody + " ]";
	}

}
