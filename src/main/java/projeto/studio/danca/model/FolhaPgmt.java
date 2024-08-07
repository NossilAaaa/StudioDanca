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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FolhaPgmt  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "Data_Pgto")
    @Temporal(TemporalType.DATE)
    private Calendar data_pgto;
    
    @Column(name = "Valor_a_Receber")
    private Double valor_receber;
    
    @ManyToOne
    @JoinColumn(name = "Professores")
    private Professores professor;
    
    public void calcularFolhames(){
       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData_pgto() {
        return data_pgto;
    }

    public void setData_pgto(Calendar data_pgto) {
        this.data_pgto = data_pgto;
    }

    public Double getValor_receber() {
        return valor_receber;
    }

    public void setValor_receber(Double valor_receber) {
        this.valor_receber = valor_receber;
    }

    public Professores getProfessor() {
        return professor;
    }

    public void setProfessor(Professores professor) {
        this.professor = professor;
    }
    
    
}
