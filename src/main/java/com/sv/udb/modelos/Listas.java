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
@Table(name = "listas", catalog = "dropbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listas.findAll", query = "SELECT l FROM Listas l")
    , @NamedQuery(name = "Listas.findByCodiList", query = "SELECT l FROM Listas l WHERE l.codiList = :codiList")
    , @NamedQuery(name = "Listas.findByNombList", query = "SELECT l FROM Listas l WHERE l.nombList = :nombList")})
public class Listas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_list")
    private Integer codiList;
    @Size(max = 250)
    @Column(name = "nomb_list")
    private String nombList;
    @OneToMany(mappedBy = "codiList", fetch = FetchType.EAGER)
    private List<ListasArchivos> listasArchivosList;
    @JoinColumn(name = "codi_usua", referencedColumnName = "codi_usua")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuarios codiUsua;

    public Listas() {
    }

    public Listas(Integer codiList) {
        this.codiList = codiList;
    }

    public Integer getCodiList() {
        return codiList;
    }

    public void setCodiList(Integer codiList) {
        this.codiList = codiList;
    }

    public String getNombList() {
        return nombList;
    }

    public void setNombList(String nombList) {
        this.nombList = nombList;
    }

    @XmlTransient
    public List<ListasArchivos> getListasArchivosList() {
        return listasArchivosList;
    }

    public void setListasArchivosList(List<ListasArchivos> listasArchivosList) {
        this.listasArchivosList = listasArchivosList;
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
        hash += (codiList != null ? codiList.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listas)) {
            return false;
        }
        Listas other = (Listas) object;
        if ((this.codiList == null && other.codiList != null) || (this.codiList != null && !this.codiList.equals(other.codiList))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Listas[ codiList=" + codiList + " ]";
    }
    
}
