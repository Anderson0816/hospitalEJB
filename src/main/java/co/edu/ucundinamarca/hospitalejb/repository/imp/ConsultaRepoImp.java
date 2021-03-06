/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.repository.imp;


import co.edu.ucundinamarca.hospitalejb.entity.Consulta;
import co.edu.ucundinamarca.hospitalejb.exception.IntegridadException;
import co.edu.ucundinamarca.hospitalejb.exception.NoContentException;
import co.edu.ucundinamarca.hospitalejb.exception.NotFoundObjectException;
import co.edu.ucundinamarca.hospitalejb.repository.IConsultaRepo;
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
public class ConsultaRepoImp implements IConsultaRepo {

    @PersistenceContext(unitName = "com.edu.unicundi_ServiciosRest-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Consulta> listar() throws NoContentException, NotAllowedException {
        TypedQuery<Consulta> query = this.em.createQuery("SELECT c from Consulta c", Consulta.class);
        return query.getResultList();
    }

    @Override
    public Consulta BuscarPorId(Integer id) throws NoContentException, NotAllowedException {
        return em.find(Consulta.class, id);
    }

    @Override
    public void guardar(Consulta consulta) throws IntegridadException, BadRequestException, NotAllowedException {
        em.persist(consulta);
    }

    @Override
    public void eliminar(Consulta consulta) throws NotFoundObjectException, NotAllowedException {
        em.remove(consulta);
    }

    @Override
    public void editar(Consulta consulta) throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException {
        em.merge(consulta);
    }

    @Override
    public Consulta buscarConsulta(int id) {
        try{
           Query query =em.createQuery("SELECT e from Consulta e WHERE e.id = ?1", Consulta.class);
           query.setParameter(1, id);
           return (Consulta) query.getSingleResult();
        }catch(NoResultException ex ){
            return null;
        }
    }

}
