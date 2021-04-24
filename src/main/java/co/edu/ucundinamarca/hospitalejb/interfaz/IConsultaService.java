/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.interfaz;


import co.edu.ucundinamarca.hospitalejb.entity.Consulta;
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
public interface IConsultaService {
    public List<Consulta> listar() throws NoContentException, NotAllowedException;
    public Consulta BuscarPorId(Integer id) throws NoContentException, NotAllowedException, NotFoundObjectException;
    public void guardar(Consulta consulta)throws IntegridadException, BadRequestException, NotAllowedException;
    public void eliminar(Integer idConsulta) throws NotFoundObjectException, NotAllowedException;
    public void editar(Consulta consulta)throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException;
}
