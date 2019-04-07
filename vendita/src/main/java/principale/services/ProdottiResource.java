/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.services;

import java.net.URI;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import principale.business.ProdottoStore;
import principale.entity.Prodotto;

/**
 *
 * @author tss
 */
@Path("/prodotti")
public class ProdottiResource {
    
    @Inject
    ProdottoStore store;
    
    @Inject
    ProdottoResource resource;
    
    @Context
    ResourceContext rc;
    
    @GET
    public List<Prodotto> findAllR(){
        return store.findAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Prodotto a, @Context UriInfo uriInfo) {
        Prodotto saved = store.update(a);
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }
    
    @Path("{id}")
    public ProdottoResource find(@PathParam("id") int id){
        resource = rc.getResource(ProdottoResource.class);
        resource.setId(id);
        return resource;
    }


    
}
