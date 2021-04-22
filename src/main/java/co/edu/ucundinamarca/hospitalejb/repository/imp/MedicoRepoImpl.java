/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.repository.imp;

import co.edu.ucundinamarca.hospitalejb.entity.Medico;
import co.edu.ucundinamarca.hospitalejb.repository.IMedicoRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ander
 */
@Stateless
public class MedicoRepoImpl implements IMedicoRepo{

    @PersistenceContext(unitName = "persistenciaDoctor")
    private EntityManager em;    
    
    @Override
    public List<Medico> buscar() {
       TypedQuery<Medico> query = em.createNamedQuery("Medico.listarTodos", Medico.class);
       return query.getResultList();
    }

    @Override
    public Medico buscarPorId(Integer id) throws NoResultException {
        return em.find(Medico.class, id);
    }

    @Override
    public void guardar(Medico medico) {
       em.persist(medico);
    }

    @Override
    public void editar(Medico medico) {
       em.merge(medico);
    }

    @Override
    public void eliminar(Medico medico) {
        em.remove(medico);
    }
    
    
}

