/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.repository.imp;


import co.edu.ucundinamarca.hospitalejb.entity.Medico;
import co.edu.ucundinamarca.hospitalejb.exception.IntegridadException;
import co.edu.ucundinamarca.hospitalejb.exception.NoContentException;
import co.edu.ucundinamarca.hospitalejb.exception.NotFoundObjectException;
import co.edu.ucundinamarca.hospitalejb.repository.IMedicoRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAllowedException;

/**
 *
 * @author Erika Moreno
 */
@Stateless
public class MedicoRepoImp implements IMedicoRepo {

       @PersistenceContext(unitName = "com.edu.unicundi_ServiciosRest-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Medico> listar() throws NoContentException, NotAllowedException {
        TypedQuery<Medico> query = this.em.createQuery("SELECT c from Medico c", Medico.class);
        return query.getResultList();
    }

    @Override
    public Medico BuscarPorId(Integer id) throws NoContentException, NotAllowedException {
        return em.find(Medico.class, id);
    }

    @Override
    public void guardar(Medico medico) throws IntegridadException, BadRequestException, NotAllowedException {
        em.persist(medico);
    }

    @Override
    public void eliminar(Medico medico) throws NotFoundObjectException, NotAllowedException {
        em.remove(medico);
    }

    @Override
    public void editar(Medico medico) throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException {
        em.merge(medico);
    }

    @Override
    public Medico buscarMedico(int id) {
        try{
           Query query =em.createQuery("SELECT e from Medico e WHERE e.id = ?1", Medico.class);
           query.setParameter(1, id);
           return (Medico) query.getSingleResult();
        }catch(NoResultException ex ){
            return null;
        }
    }

}
