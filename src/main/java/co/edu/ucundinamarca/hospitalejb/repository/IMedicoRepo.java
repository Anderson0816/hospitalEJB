/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.repository;


import co.edu.ucundinamarca.hospitalejb.entity.Medico;
import co.edu.ucundinamarca.hospitalejb.exception.IntegridadException;
import co.edu.ucundinamarca.hospitalejb.exception.NoContentException;
import co.edu.ucundinamarca.hospitalejb.exception.NotFoundObjectException;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAllowedException;

/**
 *
 * @author Erika Moreno
 */
@Local
public interface IMedicoRepo {
    public List<Medico> listar() throws NoContentException, NotAllowedException;
    public Medico BuscarPorId(Integer id) throws NoContentException, NotAllowedException, NotFoundObjectException;
    public void guardar(Medico medico)throws IntegridadException, BadRequestException, NotAllowedException;
    public void eliminar(Medico medico) throws NotFoundObjectException, NotAllowedException;
    public void editar(Medico medico)throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException;
    public Medico buscarMedico(int id);
}
