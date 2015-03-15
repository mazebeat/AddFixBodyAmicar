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
@Table(name = "correoserrorformato")
@NamedQueries({
    @NamedQuery(name = "Correoserrorformato.findAll", query = "SELECT c FROM Correoserrorformato c"),
    @NamedQuery(name = "Correoserrorformato.findByIdCliente", query = "SELECT c FROM Correoserrorformato c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Correoserrorformato.findByRutCliente", query = "SELECT c FROM Correoserrorformato c WHERE c.rutCliente = :rutCliente"),
    @NamedQuery(name = "Correoserrorformato.findByEmailCliente", query = "SELECT c FROM Correoserrorformato c WHERE c.emailCliente = :emailCliente"),
    @NamedQuery(name = "Correoserrorformato.findByNombreCliente", query = "SELECT c FROM Correoserrorformato c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Correoserrorformato.findByFonoCelular", query = "SELECT c FROM Correoserrorformato c WHERE c.fonoCelular = :fonoCelular"),
    @NamedQuery(name = "Correoserrorformato.findByFonoComercial", query = "SELECT c FROM Correoserrorformato c WHERE c.fonoComercial = :fonoComercial"),
    @NamedQuery(name = "Correoserrorformato.findByFonoParticular", query = "SELECT c FROM Correoserrorformato c WHERE c.fonoParticular = :fonoParticular"),
    @NamedQuery(name = "Correoserrorformato.findByMarcaAuto", query = "SELECT c FROM Correoserrorformato c WHERE c.marcaAuto = :marcaAuto"),
    @NamedQuery(name = "Correoserrorformato.findByModeloAuto", query = "SELECT c FROM Correoserrorformato c WHERE c.modeloAuto = :modeloAuto"),
    @NamedQuery(name = "Correoserrorformato.findByValorAuto", query = "SELECT c FROM Correoserrorformato c WHERE c.valorAuto = :valorAuto"),
    @NamedQuery(name = "Correoserrorformato.findByIdGrupo", query = "SELECT c FROM Correoserrorformato c WHERE c.idGrupo = :idGrupo"),
    @NamedQuery(name = "Correoserrorformato.findByIdBody", query = "SELECT c FROM Correoserrorformato c WHERE c.idBody = :idBody"),
    @NamedQuery(name = "Correoserrorformato.findByFecha", query = "SELECT c FROM Correoserrorformato c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Correoserrorformato.findByNombreJrn", query = "SELECT c FROM Correoserrorformato c WHERE c.nombreJrn = :nombreJrn")})
public class Correoserrorformato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Column(name = "rutCliente")
    private String rutCliente;
    @Column(name = "emailCliente")
    private String emailCliente;
    @Column(name = "nombreCliente")
    private String nombreCliente;
    @Column(name = "fonoCelular")
    private String fonoCelular;
    @Column(name = "fonoComercial")
    private String fonoComercial;
    @Column(name = "fonoParticular")
    private String fonoParticular;
    @Column(name = "marcaAuto")
    private String marcaAuto;
    @Column(name = "modeloAuto")
    private String modeloAuto;
    @Column(name = "valorAuto")
    private String valorAuto;
    @Column(name = "idGrupo")
    private Integer idGrupo;
    @Column(name = "idBody")
    private Integer idBody;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "nombreJrn")
    private String nombreJrn;

    /**
     *
     */
    public Correoserrorformato() {
    }

    /**
     *
     * @param idCliente
     */
    public Correoserrorformato(Integer idCliente) {
        this.idCliente = idCliente;
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
    public String getRutCliente() {
        return rutCliente;
    }

    /**
     *
     * @param rutCliente
     */
    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    /**
     *
     * @return
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     *
     * @param emailCliente
     */
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    /**
     *
     * @return
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     *
     * @param nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     *
     * @return
     */
    public String getFonoCelular() {
        return fonoCelular;
    }

    /**
     *
     * @param fonoCelular
     */
    public void setFonoCelular(String fonoCelular) {
        this.fonoCelular = fonoCelular;
    }

    /**
     *
     * @return
     */
    public String getFonoComercial() {
        return fonoComercial;
    }

    /**
     *
     * @param fonoComercial
     */
    public void setFonoComercial(String fonoComercial) {
        this.fonoComercial = fonoComercial;
    }

    /**
     *
     * @return
     */
    public String getFonoParticular() {
        return fonoParticular;
    }

    /**
     *
     * @param fonoParticular
     */
    public void setFonoParticular(String fonoParticular) {
        this.fonoParticular = fonoParticular;
    }

    /**
     *
     * @return
     */
    public String getMarcaAuto() {
        return marcaAuto;
    }

    /**
     *
     * @param marcaAuto
     */
    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    /**
     *
     * @return
     */
    public String getModeloAuto() {
        return modeloAuto;
    }

    /**
     *
     * @param modeloAuto
     */
    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    /**
     *
     * @return
     */
    public String getValorAuto() {
        return valorAuto;
    }

    /**
     *
     * @param valorAuto
     */
    public void setValorAuto(String valorAuto) {
        this.valorAuto = valorAuto;
    }

    /**
     *
     * @return
     */
    public Integer getIdGrupo() {
        return idGrupo;
    }

    /**
     *
     * @param idGrupo
     */
    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
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

    /**
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public String getNombreJrn() {
        return nombreJrn;
    }

    /**
     *
     * @param nombreJrn
     */
    public void setNombreJrn(String nombreJrn) {
        this.nombreJrn = nombreJrn;
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
        if (!(object instanceof Correoserrorformato)) {
            return false;
        }
        Correoserrorformato other = (Correoserrorformato) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Correoserrorformato[ idCliente=" + idCliente + " ]";
    }
    
}
