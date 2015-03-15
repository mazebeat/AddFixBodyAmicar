/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maze
 */
@Entity
@Table(name = "proceso")
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p"),
    @NamedQuery(name = "Proceso.findByIdProceso", query = "SELECT p FROM Proceso p WHERE p.idProceso = :idProceso"),
    @NamedQuery(name = "Proceso.findByFechaEnvio", query = "SELECT p FROM Proceso p WHERE p.fechaEnvio = :fechaEnvio"),
    @NamedQuery(name = "Proceso.findByFechaAperturaMail", query = "SELECT p FROM Proceso p WHERE p.fechaAperturaMail = :fechaAperturaMail"),
    @NamedQuery(name = "Proceso.findByFechaClickLink", query = "SELECT p FROM Proceso p WHERE p.fechaClickLink = :fechaClickLink")})
public class Proceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProceso")
    private Integer idProceso;
    @Column(name = "fechaEnvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;
    @Column(name = "fechaAperturaMail")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAperturaMail;
    @Column(name = "fechaClickLink")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaClickLink;
    @JoinColumn(name = "vendedores_idVendedor", referencedColumnName = "idVendedor")
    @ManyToOne(optional = false)
    private Vendedores vendedoresidVendedor;
    @JoinColumn(name = "ejecutivos_idEjecutivo", referencedColumnName = "idEjecutivo")
    @ManyToOne(optional = false)
    private Ejecutivos ejecutivosidEjecutivo;
    @JoinColumn(name = "clientes_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Clientes clientesidCliente;

    public Proceso() {
    }

    public Proceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaAperturaMail() {
        return fechaAperturaMail;
    }

    public void setFechaAperturaMail(Date fechaAperturaMail) {
        this.fechaAperturaMail = fechaAperturaMail;
    }

    public Date getFechaClickLink() {
        return fechaClickLink;
    }

    public void setFechaClickLink(Date fechaClickLink) {
        this.fechaClickLink = fechaClickLink;
    }

    public Vendedores getVendedoresidVendedor() {
        return vendedoresidVendedor;
    }

    public void setVendedoresidVendedor(Vendedores vendedoresidVendedor) {
        this.vendedoresidVendedor = vendedoresidVendedor;
    }

    public Ejecutivos getEjecutivosidEjecutivo() {
        return ejecutivosidEjecutivo;
    }

    public void setEjecutivosidEjecutivo(Ejecutivos ejecutivosidEjecutivo) {
        this.ejecutivosidEjecutivo = ejecutivosidEjecutivo;
    }

    public Clientes getClientesidCliente() {
        return clientesidCliente;
    }

    public void setClientesidCliente(Clientes clientesidCliente) {
        this.clientesidCliente = clientesidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        if ((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Proceso[ idProceso=" + idProceso + " ]";
    }
    
}
