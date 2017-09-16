/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Tipos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author walte
 */
@Local
public interface TiposFacadeLocal {

    void create(Tipos tipos);

    void edit(Tipos tipos);

    void remove(Tipos tipos);

    Tipos find(Object id);

    List<Tipos> findAll();

    List<Tipos> findRange(int[] range);

    int count();
    
}
