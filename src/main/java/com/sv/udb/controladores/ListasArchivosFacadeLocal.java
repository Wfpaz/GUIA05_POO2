/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.ListasArchivos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author walte
 */
@Local
public interface ListasArchivosFacadeLocal {

    void create(ListasArchivos listasArchivos);

    void edit(ListasArchivos listasArchivos);

    void remove(ListasArchivos listasArchivos);

    ListasArchivos find(Object id);

    List<ListasArchivos> findAll();

    List<ListasArchivos> findRange(int[] range);

    int count();
    
}
