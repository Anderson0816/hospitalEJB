/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.repository.imp;

import co.edu.ucundinamarca.hospitalejb.entity.Consulta;
import co.edu.ucundinamarca.hospitalejb.repository.IConsultaRepo;
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
public class ConsultaRepoImpl implements IConsultaRepo {

    @PersistenceContext(unitName = "persistenciaDoctor")
    private EntityManager em;    
    
    @Override
    public List<Consulta> buscar() {
       TypedQuery<Consulta> query = em.createNamedQuery("Consulta.listarTodos", Consulta.class);
       return query.getResultList();
    }

    @Override
    public Consulta buscarPorId(Integer id) throws NoResultException {
        return em.find(Consulta.class, id);
    }

    @Override
    public void guardar(Consulta consulta) {
       em.persist(consulta);
    }

    @Override
    public void editar(Consulta consulta) {
       em.merge(consulta);
    }

    @Override
    public void eliminar(Consulta consulta) {
        em.remove(consulta);
    }
    
}

