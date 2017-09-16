/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.controladores.PrestamosFacadeLocal;
import com.sv.udb.modelos.Prestamos;
import java.io.Serializable;
import java.util.Date;
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
@Named(value = "prestamosBean")
@ViewScoped
public class PrestamosBean implements Serializable{

    @EJB
    private PrestamosFacadeLocal prestamosFacade;
    
    

    private boolean guardando;
    private Prestamos objeTipo;
    private List<Prestamos> listTipo;
    
    /**
     * Creates a new instance of PrestamosBean
     */
    public PrestamosBean() {
    }

    public boolean isGuardando() {
        return guardando;
    }

    public Prestamos getObjeTipo() {
        return objeTipo;
    }

    public void setObjeTipo(Prestamos objeTipo) {
        this.objeTipo = objeTipo;
    }

    public List<Prestamos> getListTipo() {
        return listTipo;
    }
    //Se ejecuta despues de que la página carga
    @PostConstruct
    public void init()
    {
        this.objeTipo = new Prestamos();
        this.listTipo = this.prestamosFacade.findAll();
    }
    
    public void nuev()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        this.objeTipo = new Prestamos();
        this.guardando = true;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void cons()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        Map<String, String> mapaPrms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int codi = Integer.parseInt(mapaPrms.get("id"));
        this.objeTipo = this.prestamosFacade.find(codi);
        this.guardando = false;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.prestamosFacade.create(this.objeTipo);
            this.listTipo.add(this.objeTipo);
            this.objeTipo = new Prestamos();
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
            this.objeTipo.setFechDevo();
            this.prestamosFacade.edit(this.objeTipo);
            this.setItem(this.objeTipo);
            this.objeTipo = new Prestamos();
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
            this.prestamosFacade.remove(this.objeTipo);
            this.listTipo.remove(this.objeTipo);
            this.objeTipo = new Prestamos();
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
    
    private void setItem(Prestamos item)
    {
        int itemIndex = this.listTipo.indexOf(item);
            if (itemIndex != -1) {
            this.listTipo.set(itemIndex, item);
        }
    }
}