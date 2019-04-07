/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="t_scontrini_righe")
public class ScontrinoR implements Serializable {
    //id_riga, id_scontrino, id_prodotto, prezzo_vend_lordo, qta
    
    @Id
    @Column(name="id_riga")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="prezzo_vend_lordo")
    private double prezzoVL;
    
    @Column(name="qta")
    private int qta;
    
    @OneToOne
    @JoinColumn(name = "id_prodotto", referencedColumnName = "id_prodotto")
    private Prodotto prodotto;
    
    @ManyToOne
    @JoinColumn(name ="id_scontrino", referencedColumnName = "id_scontrino")
    private ScontrinoT testa;    

    public ScontrinoR() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrezzoVL() {
        return prezzoVL;
    }

    public void setPrezzoVL(double prezzoVL) {
        this.prezzoVL = prezzoVL;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ScontrinoR other = (ScontrinoR) obj;
        return this.id == other.id;
    }
    
    
}
