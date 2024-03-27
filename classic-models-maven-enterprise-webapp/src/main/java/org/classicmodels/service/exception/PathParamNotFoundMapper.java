/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dhiihd
 */

@Provider
public class PathParamNotFoundMapper  implements ExceptionMapper<PathParamNotFoundException> {
     
        public Response toResponse(PathParamNotFoundException exception) 
        {
            System.out.println(exception);
            return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();  
        }
}