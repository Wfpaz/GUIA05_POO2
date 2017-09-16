/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Archivos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author walte
 */
@Local
public interface ArchivosFacadeLocal {

    void create(Archivos archivos);

    void edit(Archivos archivos);

    void remove(Archivos archivos);

    Archivos find(Object id);

    List<Archivos> findAll();

    List<Archivos> findRange(int[] range);

    int count();
    
}
