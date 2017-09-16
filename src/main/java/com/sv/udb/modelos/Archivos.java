/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JMagoSV
 */
@Entity
@Table(name = "archivos", catalog = "dropbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivos.findAll", query = "SELECT a FROM Archivos a")
    , @NamedQuery(name = "Archivos.findByCodiArch", query = "SELECT a FROM Archivos a WHERE a.codiArch = :codiArch")
    , @NamedQuery(name = "Archivos.findByNombArch", query = "SELECT a FROM Archivos a WHERE a.nombArch = :nombArch")
    , @NamedQuery(name = "Archivos.findByExteArch", query = "SELECT a FROM Archivos a WHERE a.exteArch = :exteArch")})
public class Archivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_arch")
    private Integer codiArch;
    @Size(max = 250)
    @Column(name = "nomb_arch")
    private String nombArch;
    @Lob
    @Column(name = "bina_arch")
    private byte[] binaArch;
    @Size(max = 250)
    @Column(name = "exte_arch")
    private String exteArch;
    @JoinColumn(name = "codi_tipo", referencedColumnName = "codi_tipo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tipos codiTipo;
    @OneToMany(mappedBy = "codiArch", fetch = FetchType.EAGER)
    private List<ListasArchivos> listasArchivosList;

    public Archivos() {
    }

    public Archivos(Integer codiArch) {
        this.codiArch = codiArch;
    }

    public Integer getCodiArch() {
        return codiArch;
    }

    public void setCodiArch(Integer codiArch) {
        this.codiArch = codiArch;
    }

    public String getNombArch() {
        return nombArch;
    }

    public void setNombArch(String nombArch) {
        this.nombArch = nombArch;
    }

    public byte[] getBinaArch() {
        return binaArch;
    }

    public void setBinaArch(byte[] binaArch) {
        this.binaArch = binaArch;
    }

    public String getExteArch() {
        return exteArch;
    }

    public void setExteArch(String exteArch) {
        this.exteArch = exteArch;
    }

    public Tipos getCodiTipo() {
        return codiTipo;
    }

    public void setCodiTipo(Tipos codiTipo) {
        this.codiTipo = codiTipo;
    }

    @XmlTransient
    public List<ListasArchivos> getListasArchivosList() {
        return listasArchivosList;
    }

    public void setListasArchivosList(List<ListasArchivos> listasArchivosList) {
        this.listasArchivosList = listasArchivosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiArch != null ? codiArch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivos)) {
            return false;
        }
        Archivos other = (Archivos) object;
        if ((this.codiArch == null && other.codiArch != null) || (this.codiArch != null && !this.codiArch.equals(other.codiArch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Archivos[ codiArch=" + codiArch + " ]";
    }
    
}
