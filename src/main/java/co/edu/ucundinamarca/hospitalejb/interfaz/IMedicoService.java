/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.interfaz;

import co.edu.ucundinamarca.hospitalejb.entity.Medico;
import co.edu.ucundinamarca.hospitalejb.exception.ModelNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ander
 */
@Local
public interface IMedicoService {
    
    public List<Medico> buscar();
    
    public Medico buscarPorId(Integer id) throws ModelNotFoundException;
    
    public void guardar(Medico medico);
    
    public void editar(Medico medico) throws ModelNotFoundException;
    
    public void eliminar(Integer idMedico)  throws ModelNotFoundException;    
    
}
