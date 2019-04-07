/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import principale.entity.Negozio;

/**
 *
 * @author tss
 */
@Stateless
public class NegozioStore {
     
    @PersistenceContext
    EntityManager em;
    
    public List<Negozio> findAll() {
        return em.createQuery("select n from Negozio n order by n.descrizione", Negozio.class)
                .getResultList();
    }
    
    public Negozio find(int id) {
        return em.find(Negozio.class, id);
    }
    
    public void delete(int id) {
        em.remove(find(id));
    }
    
    public Negozio update(Negozio neg) {
        return em.merge(neg);
    }
    
    
}
