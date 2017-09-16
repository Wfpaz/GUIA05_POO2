/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Listas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author walte
 */
@Local
public interface ListasFacadeLocal {

    void create(Listas listas);

    void edit(Listas listas);

    void remove(Listas listas);

    Listas find(Object id);

    List<Listas> findAll();

    List<Listas> findRange(int[] range);

    int count();
    
}
