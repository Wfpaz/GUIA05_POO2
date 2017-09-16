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
@Table(name = "libros", catalog = "dropbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l")
    , @NamedQuery(name = "Libros.findByCodiLibr", query = "SELECT l FROM Libros l WHERE l.codiLibr = :codiLibr")
    , @NamedQuery(name = "Libros.findByNombLibr", query = "SELECT l FROM Libros l WHERE l.nombLibr = :nombLibr")
    , @NamedQuery(name = "Libros.findByAutoLibr", query = "SELECT l FROM Libros l WHERE l.autoLibr = :autoLibr")
    , @NamedQuery(name = "Libros.findByGeneLibr", query = "SELECT l FROM Libros l WHERE l.geneLibr = :geneLibr")
    , @NamedQuery(name = "Libros.findByAnioLibr", query = "SELECT l FROM Libros l WHERE l.anioLibr = :anioLibr")
    , @NamedQuery(name = "Libros.findByEstaLibr", query = "SELECT l FROM Libros l WHERE l.estaLibr = :estaLibr")})
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_libr")
    private Integer codiLibr;
    @Basic(optional = false)
    @Size(min = 1, max = 250)
    @Column(name = "nomb_libr")
    private String nombLibr;
    @Size(max = 250)
    @Column(name = "auto_libr")
    private String autoLibr;
    @Size(max = 100)
    @Column(name = "gene_libr")
    private String geneLibr;
    @Column(name = "anio_libr")
    private Integer anioLibr;
    @Column(name = "esta_libr")
    private Integer estaLibr;
    @OneToMany(mappedBy = "codiLibr", fetch = FetchType.EAGER)
    private List<Prestamos> prestamosList;

    public Libros() {
    }

    public Libros(Integer codiLibr) {
        this.codiLibr = codiLibr;
    }

    public Libros(Integer codiLibr, String nombLibr) {
        this.codiLibr = codiLibr;
        this.nombLibr = nombLibr;
    }

    public Integer getCodiLibr() {
        return codiLibr;
    }

    public void setCodiLibr(Integer codiLibr) {
        this.codiLibr = codiLibr;
    }

    public String getNombLibr() {
        return nombLibr;
    }

    public void setNombLibr(String nombLibr) {
        this.nombLibr = nombLibr;
    }

    public String getAutoLibr() {
        return autoLibr;
    }

    public void setAutoLibr(String autoLibr) {
        this.autoLibr = autoLibr;
    }

    public String getGeneLibr() {
        return geneLibr;
    }

    public void setGeneLibr(String geneLibr) {
        this.geneLibr = geneLibr;
    }

    public Integer getAnioLibr() {
        return anioLibr;
    }

    public void setAnioLibr(Integer anioLibr) {
        this.anioLibr = anioLibr;
    }

    public Integer getEstaLibr() {
        return estaLibr;
    }

    public void setEstaLibr(Integer estaLibr) {
        this.estaLibr = estaLibr;
    }

    @XmlTransient
    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiLibr != null ? codiLibr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.codiLibr == null && other.codiLibr != null) || (this.codiLibr != null && !this.codiLibr.equals(other.codiLibr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Libros[ codiLibr=" + codiLibr + " ]";
    }
    
}
