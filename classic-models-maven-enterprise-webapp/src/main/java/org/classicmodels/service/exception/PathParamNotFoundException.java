/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service.exception;

import javax.ws.rs.WebApplicationException;

public class PathParamNotFoundException extends WebApplicationException {

    public PathParamNotFoundException() {
        super();
    }

    public PathParamNotFoundException(String message) {
        super("MyException Message : " + message);
    }

}
