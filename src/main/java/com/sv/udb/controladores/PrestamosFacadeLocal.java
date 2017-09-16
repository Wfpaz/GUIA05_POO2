/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Prestamos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author walte
 */
@Local
public interface PrestamosFacadeLocal {

    void create(Prestamos prestamos);

    void edit(Prestamos prestamos);

    void remove(Prestamos prestamos);

    Prestamos find(Object id);

    List<Prestamos> findAll();

    List<Prestamos> findRange(int[] range);

    int count();
    
}
