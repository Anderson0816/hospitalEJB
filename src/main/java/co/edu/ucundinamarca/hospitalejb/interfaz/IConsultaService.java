/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.interfaz;

import co.edu.ucundinamarca.hospitalejb.entity.Consulta;
import co.edu.ucundinamarca.hospitalejb.exception.ModelNotFoundException;
import java.util.List;
import javax.ejb.Local;



/**
 *
 * @author ASUS
 */
@Local
public interface IConsultaService {
    
     public List<Consulta> buscar();
    
    public Consulta buscarPorId(Integer id) throws ModelNotFoundException;
    
    public void guardar(Consulta consulta);
    
    public void editar(Consulta consulta);
    
    public void eliminar(Integer idConsulta)  throws ModelNotFoundException;   
    
}

