/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.service;

import co.edu.ucundinamarca.hospitalejb.entity.Consulta;
import co.edu.ucundinamarca.hospitalejb.entity.DetalleConsulta;
import co.edu.ucundinamarca.hospitalejb.exception.ModelNotFoundException;
import co.edu.ucundinamarca.hospitalejb.interfaz.IConsultaService;
import co.edu.ucundinamarca.hospitalejb.repository.IConsultaRepo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ander
 */
@Stateless
public class ConsultaServiceImpl implements IConsultaService{

    @EJB
    private IConsultaRepo repo;
    
    @Override
    public List<Consulta> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consulta buscarPorId(Integer id) throws ModelNotFoundException {
          Consulta consulta = repo.buscarPorId(id);
    
          if(consulta != null)
            return consulta;
          else 
            throw new ModelNotFoundException("Consulta no enontrada");        
    }

    
    
    @Override
    public void guardar(Consulta consulta) {
        if(consulta.getDetalleConsulta() != null) {
            for (DetalleConsulta dc : consulta.getDetalleConsulta()) {
                dc.setConsulta(consulta);
            }
        }
        repo.guardar(consulta);
    }

    @Override
    public void editar(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer idConsulta) throws ModelNotFoundException{
          Consulta consulta = repo.buscarPorId(idConsulta);
          if(consulta != null)
            repo.eliminar(consulta);
          else 
              throw new ModelNotFoundException("Consulta no enontrada");
    }
    
}
