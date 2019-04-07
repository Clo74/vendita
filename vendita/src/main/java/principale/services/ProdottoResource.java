/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import principale.business.ProdottoStore;
import principale.entity.Prodotto;

/**
 *
 * @author tss
 */

public class ProdottoResource {
    
    @Inject
    ProdottoStore store2;

//    
    private int id;
//    
    @GET
    public Prodotto findR() {
        return store2.find(id);
    }
//    @GET
//    public String findR() {
//        return "CIAO";
//    }
    
    
    public void setId(int id) {
        this.id = id;
    }    
}
