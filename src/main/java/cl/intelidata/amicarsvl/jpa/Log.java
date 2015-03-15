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
import javax.persistence.Id;
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
@Table(name = "log")
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByIdlog", query = "SELECT l FROM Log l WHERE l.idlog = :idlog"),
    @NamedQuery(name = "Log.findByIdVendedor", query = "SELECT l FROM Log l WHERE l.idVendedor = :idVendedor"),
    @NamedQuery(name = "Log.findByIdCliente", query = "SELECT l FROM Log l WHERE l.idCliente = :idCliente"),
    @NamedQuery(name = "Log.findByIdEjecutivo", query = "SELECT l FROM Log l WHERE l.idEjecutivo = :idEjecutivo"),
    @NamedQuery(name = "Log.findByFechaLog", query = "SELECT l FROM Log l WHERE l.fechaLog = :fechaLog")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idlog")
    private Integer idlog;
    @Column(name = "idVendedor")
    private Integer idVendedor;
    @Column(name = "idCliente")
    private Integer idCliente;
    @Column(name = "idEjecutivo")
    private Integer idEjecutivo;
    @Column(name = "fechaLog")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLog;

    /**
     *
     */
    public Log() {
    }

    /**
     *
     * @param idlog
     */
    public Log(Integer idlog) {
        this.idlog = idlog;
    }

    /**
     *
     * @return
     */
    public Integer getIdlog() {
        return idlog;
    }

    /**
     *
     * @param idlog
     */
    public void setIdlog(Integer idlog) {
        this.idlog = idlog;
    }

    /**
     *
     * @return
     */
    public Integer getIdVendedor() {
        return idVendedor;
    }

    /**
     *
     * @param idVendedor
     */
    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
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
    public Date getFechaLog() {
        return fechaLog;
    }

    /**
     *
     * @param fechaLog
     */
    public void setFechaLog(Date fechaLog) {
        this.fechaLog = fechaLog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlog != null ? idlog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.idlog == null && other.idlog != null) || (this.idlog != null && !this.idlog.equals(other.idlog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Log[ idlog=" + idlog + " ]";
    }
    
}
