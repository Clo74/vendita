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
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name ="t_prodotti")
public class Prodotto implements Serializable {
    //id_prodotto, tipo, descrizione, prezzo_acq, prezzo_vend_netto, iva, prezzo_vend_lordo, qta

    @Id
    @Column(name = "id_prodotto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "prezzo_acq")
    private double prezzoA;

    @Column(name = "prezzo_vend_netto")
    private double prezzoVN;

    @Column(name = "iva")
    private double iva;

    @Column(name = "prezzo_vend_lordo")
    private double prezzoVL;

    @Column(name = "qta")
    private double qta;

    public Prodotto() {
    }

//    public Prodotto(String tipo, String descrizione, double prezzoA, double prezzoVN, double iva, double prezzoVL, double qta) {
//        this.tipo = tipo;
//        this.descrizione = descrizione;
//        this.prezzoA = prezzoA;
//        this.prezzoVN = prezzoVN;
//        this.iva = iva;
//        this.prezzoVL = prezzoVL;
//        this.qta = qta;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzoA() {
        return prezzoA;
    }

    public void setPrezzoA(double prezzoA) {
        this.prezzoA = prezzoA;
    }

    public double getPrezzoVN() {
        return prezzoVN;
    }

    public void setPrezzoVN(double prezzoVN) {
        this.prezzoVN = prezzoVN;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrezzoVL() {
        return prezzoVL;
    }

    public void setPrezzoVL(double prezzoVL) {
        this.prezzoVL = prezzoVL;
    }

    public double getQta() {
        return qta;
    }

    public void setQta(double qta) {
        this.qta = qta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
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
        final Prodotto other = (Prodotto) obj;
        return this.id == other.id;
    }
    
    
    
}
