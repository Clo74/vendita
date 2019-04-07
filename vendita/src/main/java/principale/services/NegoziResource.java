/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.services;

import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import principale.business.NegozioStore;
import principale.entity.Negozio;

/**
 *
 * @author tss
 */
@Path("/negozi")
public class NegoziResource {
    
    @Inject
    NegozioStore store;
    
    @GET
    public List<Negozio> findAllR() {
        return store.findAll();
    }
    
    @GET
    @Path("{id}")
    public Negozio findR(@PathParam("id") int id){
        return store.find(id);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Negozio a, @Context UriInfo uriInfo) {
        Negozio saved = store.update(a);
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(Negozio n,@PathParam("id") Integer id ) {
        n.setId(id);
        store.update(n);
    }
    
}
