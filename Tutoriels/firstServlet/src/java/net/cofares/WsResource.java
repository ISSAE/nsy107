/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares;

import data.CoupleVecteur;
import data.Vecteur;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author pascalfares
 */
@Path("ws")
public class WsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WsResource
     */
    public WsResource() {
    }

    /**
     * Retrieves representation of an instance of net.cofares.WsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{x}/{y}")
    @Produces("text/plain")
    public String getText(@PathParam("x") int x, @PathParam("y") int y ) {
        //TODO return proper representation object
       return "Add ..." + (x+y);
    }
    
    @GET
    @Path("{x}")
    @Produces("text/plain")
    public String getText(@PathParam("x") int x ) {
        //TODO return proper representation object
       return "Juste x" + x;
    }
    
    @GET
    @Path("v")
    @Produces({"application/xml", "application/json", "text/plain"})
    public Vecteur getText() {
        //TODO return proper representation object
        Vecteur v = new Vecteur();
        v.setX(10);
        v.setY(20);
       return v;
    }
    
    @GET
    @Path("cv")
    @Produces({"application/xml", "application/json", "text/plain"})
    public CoupleVecteur getVext() {
        //TODO return proper representation object
        CoupleVecteur v = new CoupleVecteur(10,20,15,25);
        
       return v;
    }
    

    /**
     * PUT method for updating or creating an instance of WsResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Vecteur putText(CoupleVecteur content) {
        Vecteur v = new Vecteur();
        v.setX(content.getV1().getX()+content.getV2().getX());
         v.setY(content.getV1().getY()+content.getV2().getY());
         return v;
    }
}
