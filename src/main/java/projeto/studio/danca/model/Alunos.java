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
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alunos extends Pessoas implements Serializable{
    @Column(name = "Data_inicio")
    @Temporal(TemporalType.DATE)
    private Calendar datainicio;
    
    @Column(name = "DataPgto")
    
    private Integer dataPgto;

    public Calendar getData_inicio() {
        return datainicio;
    }

    public void setData_inicio(Calendar data_inicio) {
        this.datainicio = data_inicio;
    }

    public Integer getData_Pgto() {
        return dataPgto;
    }

    public void setData_Pgto(Integer data_Pgto) {
        this.dataPgto = data_Pgto;
    }
    
    
    
}
