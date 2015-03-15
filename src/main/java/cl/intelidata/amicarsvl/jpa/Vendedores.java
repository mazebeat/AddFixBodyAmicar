/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import java.io.Serializable;
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

/**
 *
 * @author Maze
 */
@Entity
@Table(name = "vendedores")
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v"),
    @NamedQuery(name = "Vendedores.findByIdVendedor", query = "SELECT v FROM Vendedores v WHERE v.idVendedor = :idVendedor"),
    @NamedQuery(name = "Vendedores.findByRutVendedor", query = "SELECT v FROM Vendedores v WHERE v.rutVendedor = :rutVendedor"),
    @NamedQuery(name = "Vendedores.findByNombreVendedor", query = "SELECT v FROM Vendedores v WHERE v.nombreVendedor = :nombreVendedor")})
public class Vendedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVendedor")
    private Integer idVendedor;
    @Column(name = "rutVendedor")
    private String rutVendedor;
    @Column(name = "nombreVendedor")
    private String nombreVendedor;
    @JoinColumn(name = "locales_idLocal", referencedColumnName = "idLocal")
    @ManyToOne(optional = false)
    private Locales localesidLocal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedoresidVendedor")
    private List<Proceso> procesoList;

    /**
     *
     */
    public Vendedores() {
    }

    /**
     *
     * @param idVendedor
     */
    public Vendedores(Integer idVendedor) {
        this.idVendedor = idVendedor;
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
    public String getRutVendedor() {
        return rutVendedor;
    }

    /**
     *
     * @param rutVendedor
     */
    public void setRutVendedor(String rutVendedor) {
        this.rutVendedor = rutVendedor;
    }

    /**
     *
     * @return
     */
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    /**
     *
     * @param nombreVendedor
     */
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    /**
     *
     * @return
     */
    public Locales getLocalesidLocal() {
        return localesidLocal;
    }

    /**
     *
     * @param localesidLocal
     */
    public void setLocalesidLocal(Locales localesidLocal) {
        this.localesidLocal = localesidLocal;
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
        Vendedores other = (Vendedores) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Vendedores[ idVendedor=" + idVendedor + " ]";
    }
    
}
