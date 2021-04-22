/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.repository;

import co.edu.ucundinamarca.hospitalejb.entity.Consulta;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.NoResultException;

/**
 *
 * @author ander
 */
@Local
public interface IConsultaRepo {
    
    public List<Consulta> buscar();
    
    public Consulta buscarPorId(Integer id) throws NoResultException;
    
    public void guardar(Consulta consulta);
    
    public void editar(Consulta consulta);
    
    public void eliminar(Consulta consulta);
    
    
}

