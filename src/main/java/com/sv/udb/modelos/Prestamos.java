/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JMagoSV
 */
@Entity
@Table(name = "prestamos", catalog = "dropbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamos.findAll", query = "SELECT p FROM Prestamos p")
    , @NamedQuery(name = "Prestamos.findByCodiPres", query = "SELECT p FROM Prestamos p WHERE p.codiPres = :codiPres")
    , @NamedQuery(name = "Prestamos.findByFechPres", query = "SELECT p FROM Prestamos p WHERE p.fechPres = :fechPres")
    , @NamedQuery(name = "Prestamos.findByFechDevo", query = "SELECT p FROM Prestamos p WHERE p.fechDevo = :fechDevo")})
public class Prestamos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_pres")
    private Integer codiPres;
    @Column(name = "fech_pres")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechPres;
    @Column(name = "fech_devo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechDevo;
    @JoinColumn(name = "codi_libr", referencedColumnName = "codi_libr")
    @ManyToOne(fetch = FetchType.EAGER)
    private Libros codiLibr;
    @JoinColumn(name = "codi_usua", referencedColumnName = "codi_usua")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuarios codiUsua;

    public Prestamos() {
    }

    public Prestamos(Integer codiPres) {
        this.codiPres = codiPres;
    }

    public Integer getCodiPres() {
        return codiPres;
    }

    public void setCodiPres(Integer codiPres) {
        this.codiPres = codiPres;
    }

    public Date getFechPres() {
        return fechPres;
    }

    public void setFechPres(Date fechPres) {
        this.fechPres = fechPres;
    }

    public Date getFechDevo() {
        return fechDevo;
    }

    public void setFechDevo(Date fechDevo) {
        this.fechDevo = fechDevo;
    }

    public Libros getCodiLibr() {
        return codiLibr;
    }

    public void setCodiLibr(Libros codiLibr) {
        this.codiLibr = codiLibr;
    }

    public Usuarios getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Usuarios codiUsua) {
        this.codiUsua = codiUsua;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiPres != null ? codiPres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamos)) {
            return false;
        }
        Prestamos other = (Prestamos) object;
        if ((this.codiPres == null && other.codiPres != null) || (this.codiPres != null && !this.codiPres.equals(other.codiPres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Prestamos[ codiPres=" + codiPres + " ]";
    }
    
}
