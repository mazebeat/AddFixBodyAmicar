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
@Table(name = "clientessemanal")
@NamedQueries({
    @NamedQuery(name = "Clientessemanal.findAll", query = "SELECT c FROM Clientessemanal c"),
    @NamedQuery(name = "Clientessemanal.findByIdCliente", query = "SELECT c FROM Clientessemanal c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Clientessemanal.findByRutCliente", query = "SELECT c FROM Clientessemanal c WHERE c.rutCliente = :rutCliente"),
    @NamedQuery(name = "Clientessemanal.findByEmailCliente", query = "SELECT c FROM Clientessemanal c WHERE c.emailCliente = :emailCliente"),
    @NamedQuery(name = "Clientessemanal.findByNombreCliente", query = "SELECT c FROM Clientessemanal c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Clientessemanal.findByFonoCelular", query = "SELECT c FROM Clientessemanal c WHERE c.fonoCelular = :fonoCelular"),
    @NamedQuery(name = "Clientessemanal.findByFonoComercial", query = "SELECT c FROM Clientessemanal c WHERE c.fonoComercial = :fonoComercial"),
    @NamedQuery(name = "Clientessemanal.findByFonoParticular", query = "SELECT c FROM Clientessemanal c WHERE c.fonoParticular = :fonoParticular"),
    @NamedQuery(name = "Clientessemanal.findByMarcaAuto", query = "SELECT c FROM Clientessemanal c WHERE c.marcaAuto = :marcaAuto"),
    @NamedQuery(name = "Clientessemanal.findByModeloAuto", query = "SELECT c FROM Clientessemanal c WHERE c.modeloAuto = :modeloAuto"),
    @NamedQuery(name = "Clientessemanal.findByValorAuto", query = "SELECT c FROM Clientessemanal c WHERE c.valorAuto = :valorAuto"),
    @NamedQuery(name = "Clientessemanal.findByIdGrupo", query = "SELECT c FROM Clientessemanal c WHERE c.idGrupo = :idGrupo"),
    @NamedQuery(name = "Clientessemanal.findByIdBody", query = "SELECT c FROM Clientessemanal c WHERE c.idBody = :idBody"),
    @NamedQuery(name = "Clientessemanal.findByFecha", query = "SELECT c FROM Clientessemanal c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Clientessemanal.findByNombreJrn", query = "SELECT c FROM Clientessemanal c WHERE c.nombreJrn = :nombreJrn")})
public class Clientessemanal implements Serializable {
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

    public Clientessemanal() {
    }

    public Clientessemanal(Integer idCliente) {
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

    public String getFonoCelular() {
        return fonoCelular;
    }

    public void setFonoCelular(String fonoCelular) {
        this.fonoCelular = fonoCelular;
    }

    public String getFonoComercial() {
        return fonoComercial;
    }

    public void setFonoComercial(String fonoComercial) {
        this.fonoComercial = fonoComercial;
    }

    public String getFonoParticular() {
        return fonoParticular;
    }

    public void setFonoParticular(String fonoParticular) {
        this.fonoParticular = fonoParticular;
    }

    public String getMarcaAuto() {
        return marcaAuto;
    }

    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    public String getModeloAuto() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public String getValorAuto() {
        return valorAuto;
    }

    public void setValorAuto(String valorAuto) {
        this.valorAuto = valorAuto;
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

    public String getNombreJrn() {
        return nombreJrn;
    }

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
        if (!(object instanceof Clientessemanal)) {
            return false;
        }
        Clientessemanal other = (Clientessemanal) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.intelidata.amicarsvl.jpa.Clientessemanal[ idCliente=" + idCliente + " ]";
    }
    
}
