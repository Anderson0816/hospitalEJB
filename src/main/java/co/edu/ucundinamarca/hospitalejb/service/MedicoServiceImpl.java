/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.service;

import co.edu.ucundinamarca.hospitalejb.entity.Medico;
import co.edu.ucundinamarca.hospitalejb.exception.ModelNotFoundException;
import co.edu.ucundinamarca.hospitalejb.interfaz.IMedicoService;
import co.edu.ucundinamarca.hospitalejb.repository.IMedicoRepo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateless;

/**
 *
 * @author ander
 */
@Stateless
public class MedicoServiceImpl implements IMedicoService{

    @EJB
    private IMedicoRepo repo;
    
    
    @Override
    public List<Medico> buscar() {
            return repo.buscar();
    }

    @Override
    public Medico buscarPorId(Integer id) throws ModelNotFoundException {
            Medico medico = repo.buscarPorId(id);
            if(medico == null)
                throw new ModelNotFoundException("Objeto no encontrado");
            return medico;
    }

    @Override
    public void guardar(Medico medico) {
        medico.getDireccion().setMedico(medico);
        repo.guardar(medico);
    }

    @Override
    public void editar(Medico medico) throws ModelNotFoundException {
        if(medico.getId() == null)
        {
           
        }    
        
        Medico medicoEntity = this.buscarPorId(medico.getId());
        medicoEntity.setNombre(medico.getNombre());
        medicoEntity.setApellido(medico.getApellido());
        medicoEntity.setCorreo(medico.getCorreo());
        
        if(medico.getDireccion() != null) {
            medicoEntity.getDireccion().setBarrio(medico.getDireccion().getBarrio());
            medicoEntity.getDireccion().setCodigoPostal(medico.getDireccion().getCodigoPostal());
        }
        
        repo.editar(medicoEntity);
    }

    @Override
    public void eliminar(Integer idMedico) throws ModelNotFoundException {    
           Medico medico = this.buscarPorId(idMedico);
           repo.eliminar(medico);
    }
     @PrePassivate
    public void pre() {

    }

    @PostActivate
    public void pos() {

    }
}

