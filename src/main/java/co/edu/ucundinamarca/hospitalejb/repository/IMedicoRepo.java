/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.repository;

import co.edu.ucundinamarca.hospitalejb.entity.Medico;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.NoResultException;

/**
 *
 * @author ander
 */
@Local
public interface IMedicoRepo {
    
    public List<Medico> buscar();
    
    public Medico buscarPorId(Integer id) throws NoResultException;
    
    public void guardar(Medico medico);
    
    public void editar(Medico medico);
    
    public void eliminar(Medico medico);
        
    
}
