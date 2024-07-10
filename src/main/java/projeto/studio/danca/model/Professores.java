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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
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
    
    @Column
    @Temporal(TemporalType.DATE)//dia, mes e ano
    private Calendar data_aniver;
    
    @OneToMany
    private Collection<FolhaPgmt> F_pagamento;
    
    @ManyToMany
    private Collection<modalidades> modalidade;
    
  
    public Calendar getData_adm() {
        return data_adm;
    }

    public void setData_adm(Calendar data_adm) {
        this.data_adm = data_adm;
    }

    public Calendar getData_aniver() {
        return data_aniver;
    }

    public void setData_aniver(Calendar data_aniver) {
        this.data_aniver = data_aniver;
    }

    public Collection<FolhaPgmt> getF_pagamento() {
        return F_pagamento;
    }

    public void setF_pagamento(List<FolhaPgmt> F_pagamento) {
        this.F_pagamento = F_pagamento;
    }

    public Collection<modalidades> getmodalidade() {
        return modalidade;
    }

    public void setmodalidade(List<modalidades> modalidade) {
        this.modalidade = modalidade;
    }
    
    
}
