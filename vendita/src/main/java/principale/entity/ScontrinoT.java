/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="t_scontrini_righe")
public class ScontrinoT implements Serializable {
    //id_scontrino, data, id_negozio
    @Id
    @Column(name="id_scontrino")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="data_scontrino")
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate data;
    
    @ManyToOne
    @JoinColumn(name = "id_negozio", referencedColumnName = "id_negozio")
    private Negozio negozio;

    public ScontrinoT() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final ScontrinoT other = (ScontrinoT) obj;
        return this.id == other.id;
    }
    
    
    
    
    
    
}
