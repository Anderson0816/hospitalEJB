/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "administrativo")
public class Administrativo implements Serializable {
    
    @Id
    private Integer id;
    
    @Size(min = 3, max = 10, message = "Debe tener entre 3 y 10 letras")
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;
    
    @Size(min = 3, max = 25, message = "Debe tener entre 3 y 25 letras")
    @Column(name = "nombre", nullable = false, length =  255)
    private String nombre;

    @Size(min = 3, max = 25, message = "Debe tener entre 3 y 25 letras")
    @Column(name = "apellido", nullable = false, length =  255)
    private String apellido;    
    
    @Column(name = "edad", nullable = false)
    private Integer edad;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }        
}

   

