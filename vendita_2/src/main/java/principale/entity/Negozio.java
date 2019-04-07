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
@Table(name = "t_negozi")
public class Negozio implements Serializable {
    //id_negozio, descrizione, indirizzo, tel, email

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_negozio")
    private int id;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

//    public Negozio(String descrizione, String indirizzo, String tel, String email) {
//        this.descrizione = descrizione;
//        this.indirizzo = indirizzo;
//        this.tel = tel;
//        this.email = email;
//    }

    public Negozio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
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
        final Negozio other = (Negozio) obj;
        return this.id == other.id;
    }
    
    

}
