/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalejb.exception;

/**
 *
 * @author Erika Moreno
 */
public class BadRequestException extends Exception {
     public BadRequestException(String string) {
        super(string);
    }
}
