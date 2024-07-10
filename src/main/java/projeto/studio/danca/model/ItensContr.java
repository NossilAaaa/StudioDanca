/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.studio.danca.model;

/**
 *
 * @author aliss
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Entity
public class ItensContr implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idContrato;
    
    @ManyToOne
    @JoinColumn(name = "pacote_id", nullable = false)
    private Pacotes pacote;

    public ItensContr() {
    }

    public ItensContr(Integer idContrato, Pacotes pacote) {
        this.idContrato = idContrato;
        this.pacote = pacote;
    }
    

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

  
    public void setPacote(Pacotes pacote) {
        this.pacote = pacote;
    }

    public Pacotes getPacote() {
        return pacote;
    }
    
    
    
}
