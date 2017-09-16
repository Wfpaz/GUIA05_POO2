/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.PermisosUsuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author walte
 */
@Local
public interface PermisosUsuariosFacadeLocal {

    void create(PermisosUsuarios permisosUsuarios);

    void edit(PermisosUsuarios permisosUsuarios);

    void remove(PermisosUsuarios permisosUsuarios);

    PermisosUsuarios find(Object id);

    List<PermisosUsuarios> findAll();

    List<PermisosUsuarios> findRange(int[] range);

    int count();
    
}
