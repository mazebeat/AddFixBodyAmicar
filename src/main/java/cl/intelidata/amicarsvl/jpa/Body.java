/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Maze
 */
@Entity
@Table(name = "body")
@NamedQueries({
    @NamedQuery(name = "Body.findAll", query = "SELECT b FROM Body b"),
    @NamedQuery(name = "Body.findByIdBody", query = "SELECT b FROM Body b WHERE b.idBody = :idBody"),
    @NamedQuery(name = "Body.findByBodyNombre", query = "SELECT b FROM Body b WHERE b.bodyNombre = :bodyNombre")})
public class Body implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idBody")
    private Integer idBody;
    @Column(name = "bodyNombre")
    private String bodyNombre;

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
        Body other = (Body) object;
        if ((this.idBody == null && other.idBody != null) || (this.idBody != null && !this.idBody.equals(other.idBody))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Body[ idBody=" + idBody + " ]";
    }
    
}
