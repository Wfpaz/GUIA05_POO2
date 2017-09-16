/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JMagoSV
 */
@Entity
@Table(name = "permisos_usuarios", catalog = "dropbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisosUsuarios.findAll", query = "SELECT p FROM PermisosUsuarios p")
    , @NamedQuery(name = "PermisosUsuarios.findByCodiPermUsua", query = "SELECT p FROM PermisosUsuarios p WHERE p.codiPermUsua = :codiPermUsua")
    , @NamedQuery(name = "PermisosUsuarios.findByEstaPermUsua", query = "SELECT p FROM PermisosUsuarios p WHERE p.estaPermUsua = :estaPermUsua")})
public class PermisosUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_perm_usua")
    private Integer codiPermUsua;
    @Column(name = "esta_perm_usua")
    private Integer estaPermUsua;
    @JoinColumn(name = "codi_usua", referencedColumnName = "codi_perm")
    @ManyToOne(fetch = FetchType.EAGER)
    private Permisos codiUsua;
    @JoinColumn(name = "codi_perm", referencedColumnName = "codi_usua")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuarios codiPerm;

    public PermisosUsuarios() {
    }

    public PermisosUsuarios(Integer codiPermUsua) {
        this.codiPermUsua = codiPermUsua;
    }

    public Integer getCodiPermUsua() {
        return codiPermUsua;
    }

    public void setCodiPermUsua(Integer codiPermUsua) {
        this.codiPermUsua = codiPermUsua;
    }

    public Integer getEstaPermUsua() {
        return estaPermUsua;
    }

    public void setEstaPermUsua(Integer estaPermUsua) {
        this.estaPermUsua = estaPermUsua;
    }

    public Permisos getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Permisos codiUsua) {
        this.codiUsua = codiUsua;
    }

    public Usuarios getCodiPerm() {
        return codiPerm;
    }

    public void setCodiPerm(Usuarios codiPerm) {
        this.codiPerm = codiPerm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiPermUsua != null ? codiPermUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosUsuarios)) {
            return false;
        }
        PermisosUsuarios other = (PermisosUsuarios) object;
        if ((this.codiPermUsua == null && other.codiPermUsua != null) || (this.codiPermUsua != null && !this.codiPermUsua.equals(other.codiPermUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.PermisosUsuarios[ codiPermUsua=" + codiPermUsua + " ]";
    }
    
}
