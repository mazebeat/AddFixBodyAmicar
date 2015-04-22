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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maze
 */
@Entity
@Table(name = "locales")
@NamedQueries({
    @NamedQuery(name = "Locales.findAll", query = "SELECT l FROM Locales l"),
    @NamedQuery(name = "Locales.findByIdLocal", query = "SELECT l FROM Locales l WHERE l.idLocal = :idLocal"),
    @NamedQuery(name = "Locales.findByNombreLocal", query = "SELECT l FROM Locales l WHERE l.nombreLocal = :nombreLocal")})
public class Locales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLocal")
    private Integer idLocal;
    @Column(name = "nombreLocal")
    private String nombreLocal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localesidLocal")
    private List<Vendedores> vendedoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localesidLocal1")
    private List<Ejecutivos> ejecutivosList;

    /**
     *
     */
    public Locales() {
    }

    /**
     *
     * @param idLocal
     */
    public Locales(Integer idLocal) {
        this.idLocal = idLocal;
    }

    /**
     *
     * @return
     */
    public Integer getIdLocal() {
        return idLocal;
    }

    /**
     *
     * @param idLocal
     */
    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    /**
     *
     * @return
     */
    public String getNombreLocal() {
        return nombreLocal;
    }

    /**
     *
     * @param nombreLocal
     */
    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    /**
     *
     * @return
     */
    public List<Vendedores> getVendedoresList() {
        return vendedoresList;
    }

    /**
     *
     * @param vendedoresList
     */
    public void setVendedoresList(List<Vendedores> vendedoresList) {
        this.vendedoresList = vendedoresList;
    }

    /**
     *
     * @return
     */
    public List<Ejecutivos> getEjecutivosList() {
        return ejecutivosList;
    }

    /**
     *
     * @param ejecutivosList
     */
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
        Locales other = (Locales) object;
        if ((this.idLocal == null && other.idLocal != null) || (this.idLocal != null && !this.idLocal.equals(other.idLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Locales[ idLocal=" + idLocal + " ]";
    }
    
}
