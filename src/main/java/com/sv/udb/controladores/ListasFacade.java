/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Listas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author walte
 */
@Stateless
public class ListasFacade extends AbstractFacade<Listas> implements ListasFacadeLocal {

    @PersistenceContext(unitName = "Poopu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListasFacade() {
        super(Listas.class);
    }
    
}
