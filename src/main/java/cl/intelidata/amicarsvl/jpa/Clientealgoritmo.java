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
@Table(name = "clientealgoritmo")
@NamedQueries({
    @NamedQuery(name = "Clientealgoritmo.findAll", query = "SELECT c FROM Clientealgoritmo c"),
    @NamedQuery(name = "Clientealgoritmo.findByIdClienteAlgoritmo", query = "SELECT c FROM Clientealgoritmo c WHERE c.idClienteAlgoritmo = :idClienteAlgoritmo"),
    @NamedQuery(name = "Clientealgoritmo.findByIdCliente", query = "SELECT c FROM Clientealgoritmo c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Clientealgoritmo.findByIdBody", query = "SELECT c FROM Clientealgoritmo c WHERE c.idBody = :idBody")})
public class Clientealgoritmo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idClienteAlgoritmo")
    private Integer idClienteAlgoritmo;
    @Column(name = "idCliente")
    private Integer idCliente;
    @Column(name = "idBody")
    private Integer idBody;

    /**
     *
     */
    public Clientealgoritmo() {
    }

    /**
     *
     * @param idClienteAlgoritmo
     */
    public Clientealgoritmo(Integer idClienteAlgoritmo) {
        this.idClienteAlgoritmo = idClienteAlgoritmo;
    }

    /**
     *
     * @return
     */
    public Integer getIdClienteAlgoritmo() {
        return idClienteAlgoritmo;
    }

    /**
     *
     * @param idClienteAlgoritmo
     */
    public void setIdClienteAlgoritmo(Integer idClienteAlgoritmo) {
        this.idClienteAlgoritmo = idClienteAlgoritmo;
    }

    /**
     *
     * @return
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return
     */
    public Integer getIdBody() {
        return idBody;
    }

    /**
     *
     * @param idBody
     */
    public void setIdBody(Integer idBody) {
        this.idBody = idBody;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteAlgoritmo != null ? idClienteAlgoritmo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientealgoritmo)) {
            return false;
        }
        Clientealgoritmo other = (Clientealgoritmo) object;
        if ((this.idClienteAlgoritmo == null && other.idClienteAlgoritmo != null) || (this.idClienteAlgoritmo != null && !this.idClienteAlgoritmo.equals(other.idClienteAlgoritmo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Clientealgoritmo[ idClienteAlgoritmo=" + idClienteAlgoritmo + " ]";
    }
    
}
