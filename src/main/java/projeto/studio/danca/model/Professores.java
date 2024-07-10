/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.studio.danca.model;

/**
 *
 * @author aliss
 */ 

import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Professores extends Pessoas implements Serializable{
    
    @Column(name = "Data_Admissão")
    @Temporal(TemporalType.DATE)//dia, mes e ano
    private Calendar data_adm;
    
    @OneToMany
    private List<FolhaPagamento> F_pagamento= new ArrayList();
    
    @OneToMany
    private List<Modalidades> modalidade= new ArrayList();
  
    public Calendar getData_adm() {
        return data_adm;
    }

    public void setData_adm(Calendar data_adm) {
        this.data_adm = data_adm;
    }
    
    
}
