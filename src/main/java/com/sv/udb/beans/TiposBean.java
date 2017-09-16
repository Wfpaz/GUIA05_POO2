/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.controladores.TiposFacadeLocal;
import com.sv.udb.modelos.Tipos;
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
 * @author JMagoSV
 */
@Named(value = "tiposBean")
@ViewScoped
public class TiposBean implements Serializable{

    @EJB
    private TiposFacadeLocal tiposFacade;
    
    private boolean guardando;
    private Tipos objeTipo;
    private List<Tipos> listTipo;
    /**
     * Creates a new instance of TiposBean
     */
    public TiposBean() {
    }

    public boolean isGuardando() {
        return guardando;
    }

    public Tipos getObjeTipo() {
        return objeTipo;
    }

    public void setObjeTipo(Tipos objeTipo) {
        this.objeTipo = objeTipo;
    }

    public List<Tipos> getListTipo() {
        return listTipo;
    }
    
    //Se ejecuta despues de que la página carga
    @PostConstruct
    public void init()
    {
        this.objeTipo = new Tipos();
        this.listTipo = this.tiposFacade.findAll();
    }
    
    public void nuev()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        this.objeTipo = new Tipos();
        this.guardando = true;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void cons()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        Map<String, String> mapaPrms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int codi = Integer.parseInt(mapaPrms.get("codiTipo"));
        this.objeTipo = this.tiposFacade.find(codi);
        this.guardando = false;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.tiposFacade.create(this.objeTipo);
            this.listTipo.add(this.objeTipo);
            this.objeTipo = new Tipos();
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
            this.tiposFacade.edit(this.objeTipo);
            this.setItem(this.objeTipo);
            this.objeTipo = new Tipos();
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
            this.tiposFacade.remove(this.objeTipo);
            this.listTipo.remove(this.objeTipo);
            this.objeTipo = new Tipos();
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
    
    private void setItem(Tipos item)
    {
        int itemIndex = this.listTipo.indexOf(item);
            if (itemIndex != -1) {
            this.listTipo.set(itemIndex, item);
        }
    }
}
