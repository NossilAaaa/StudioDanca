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
public class Alunos extends Pessoas{
    
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar datainicio;
    
    @Column(name = "DataPgto")
    private Integer dataPgto;

    public Alunos() {
        
    }

    public Alunos(Calendar datainicio, Integer dataPgto) {
        this.datainicio = datainicio;
        this.dataPgto = dataPgto;
    }

    public Calendar getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Calendar datainicio) {
        this.datainicio = datainicio;
    }

    public Integer getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Integer dataPgto) {
        this.dataPgto = dataPgto;
    }

    
    
    
    
    
    
}
