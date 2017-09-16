/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.modelos.Libros;
import com.sv.udb.controladores.LibrosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author walte
 */
@Named(value = "librosBean")
@ViewScoped
public class LibrosBean implements Serializable {

    @EJB
    private LibrosFacadeLocal librosFacade;    
    
    private boolean guardando;
    private Libros objeLibro;
    private List<Libros> listLibro;
    
    /**
     * Creates a new instance of LibrosBean
     */
    public LibrosBean() {
    }

    public boolean isGuardando() {
        return guardando;
    }

    public Libros getObjeLibro() {
        return objeLibro;
    }

    public void setObjeLibro(Libros objeLibro) {
        this.objeLibro = objeLibro;
    }

    public List<Libros> getListLibro() {
        return listLibro;
    }
    
    //Se ejecuta despues de que la página carga
    @PostConstruct
    public void init()
    {
        this.objeLibro = new Libros();
        this.listLibro = this.librosFacade.findAll();
    }
    
    public void nuev()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        this.objeLibro = new Libros();
        this.guardando = true;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void cons()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        Map<String, String> mapaPrms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int codi = Integer.parseInt(mapaPrms.get("id"));
        this.objeLibro = this.librosFacade.find(codi);
        this.guardando = false;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.librosFacade.create(this.objeLibro);
            this.listLibro.add(this.objeLibro);
            this.objeLibro = new Libros();
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al guardar ')");
        }
        finally
        {
            
        }
    }
    
    public void edit()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.librosFacade.edit(this.objeLibro);
            this.setItem(this.objeLibro);
            this.objeLibro = new Libros();
            this.guardando = true;
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos modificados')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'No se modificó')");
        }
        finally
        {
            
        }
    }
    
    public void elim()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.librosFacade.remove(this.objeLibro);
            this.listLibro.remove(this.objeLibro);
            this.objeLibro = new Libros();
            this.guardando = true;
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos eliminados')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'No se eliminó')");
        }
        finally
        {
            
        }
    }
    
    private void setItem(Libros item)
    {
        int itemIndex = this.listLibro.indexOf(item);
            if (itemIndex != -1) {
            this.listLibro.set(itemIndex, item);
        }
    }
}
