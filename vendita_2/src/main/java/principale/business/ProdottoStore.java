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
import principale.entity.Prodotto;

/**
 *
 * @author tss
 */
@Stateless
public class ProdottoStore {

    @PersistenceContext
    EntityManager em;

    
    public List<Prodotto> findAll(){
        return em.createQuery("select p from Prodotto p order by p.descrizione", Prodotto.class)
                .getResultList();
    }

    public Prodotto find(int id) {
        return em.find(Prodotto.class, id);
    }
    
    public Prodotto update(Prodotto prod) {
        return em.merge(prod);
    }
    
    public void delete(int id) {
        em.remove(this.find(id));
    }
    
    public List<Prodotto> findByDesc(String str){
        return em.createQuery("select p from Prodotto p Where p.descrizione LIKE ':str%' ORDER by p.descrizione",Prodotto.class)
                .setParameter("str", str)
                .getResultList();
    }


}
