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
@Table(name = "listas_archivos", catalog = "dropbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListasArchivos.findAll", query = "SELECT l FROM ListasArchivos l")
    , @NamedQuery(name = "ListasArchivos.findByCodiListArch", query = "SELECT l FROM ListasArchivos l WHERE l.codiListArch = :codiListArch")})
public class ListasArchivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_list_arch")
    private Integer codiListArch;
    @JoinColumn(name = "codi_list", referencedColumnName = "codi_list")
    @ManyToOne(fetch = FetchType.EAGER)
    private Listas codiList;
    @JoinColumn(name = "codi_arch", referencedColumnName = "codi_arch")
    @ManyToOne(fetch = FetchType.EAGER)
    private Archivos codiArch;

    public ListasArchivos() {
    }

    public ListasArchivos(Integer codiListArch) {
        this.codiListArch = codiListArch;
    }

    public Integer getCodiListArch() {
        return codiListArch;
    }

    public void setCodiListArch(Integer codiListArch) {
        this.codiListArch = codiListArch;
    }

    public Listas getCodiList() {
        return codiList;
    }

    public void setCodiList(Listas codiList) {
        this.codiList = codiList;
    }

    public Archivos getCodiArch() {
        return codiArch;
    }

    public void setCodiArch(Archivos codiArch) {
        this.codiArch = codiArch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiListArch != null ? codiListArch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListasArchivos)) {
            return false;
        }
        ListasArchivos other = (ListasArchivos) object;
        if ((this.codiListArch == null && other.codiListArch != null) || (this.codiListArch != null && !this.codiListArch.equals(other.codiListArch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.ListasArchivos[ codiListArch=" + codiListArch + " ]";
    }
    
}
