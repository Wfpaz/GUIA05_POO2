/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.ListasArchivos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author walte
 */
@Stateless
public class ListasArchivosFacade extends AbstractFacade<ListasArchivos> implements ListasArchivosFacadeLocal {

    @PersistenceContext(unitName = "Poopu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListasArchivosFacade() {
        super(ListasArchivos.class);
    }
    
}
