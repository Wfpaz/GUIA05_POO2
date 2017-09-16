/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.controladores.UsuariosFacadeLocal;
import com.sv.udb.modelos.Usuarios;
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
@Named(value = "usuariosBean")
@ViewScoped
public class UsuariosBean implements Serializable{

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    private boolean guardando;
    private Usuarios objeTipo;
    private List<Usuarios> listTipo;
    
    /**
     * Creates a new instance of UsuariosBean
     */
    public UsuariosBean() {
    }

    public boolean isGuardando() {
        return guardando;
    }

    public Usuarios getObjeTipo() {
        return objeTipo;
    }

    public void setObjeTipo(Usuarios objeTipo) {
        this.objeTipo = objeTipo;
    }

    public List<Usuarios> getListTipo() {
        return listTipo;
    }
    //Se ejecuta despues de que la página carga
    @PostConstruct
    public void init()
    {
        this.objeTipo = new Usuarios();
        this.listTipo = this.usuariosFacade.findAll();
    }
    
    public void nuev()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        this.objeTipo = new Usuarios();
        this.guardando = true;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void cons()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        Map<String, String> mapaPrms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int codi = Integer.parseInt(mapaPrms.get("codiUsua"));
        this.objeTipo = this.usuariosFacade.find(codi);
        this.guardando = false;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.usuariosFacade.create(this.objeTipo);
            this.listTipo.add(this.objeTipo);
            this.objeTipo = new Usuarios();
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
            this.usuariosFacade.edit(this.objeTipo);
            this.setItem(this.objeTipo);
            this.objeTipo = new Usuarios();
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
            this.usuariosFacade.remove(this.objeTipo);
            this.listTipo.remove(this.objeTipo);
            this.objeTipo = new Usuarios();
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
    
    private void setItem(Usuarios item)
    {
        int itemIndex = this.listTipo.indexOf(item);
            if (itemIndex != -1) {
            this.listTipo.set(itemIndex, item);
        }
    }
}
