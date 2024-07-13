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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contratos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataInicio;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private Double valorDesconto;
  
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Alunos aluno;
    
    @ManyToOne
    @JoinColumn(name = "itens_id")
    private ItensContr ItensContr;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaPgto FormaPgto;
    

   
    public Contratos(Integer id, Calendar dataInicio, Double valorDesconto, Alunos aluno, ItensContr ItensContr, FormaPgto FormaPgto) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.valorDesconto = valorDesconto;
        this.aluno = aluno;
        this.ItensContr = ItensContr;
        this.FormaPgto = FormaPgto;
    }

    public Contratos() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setFormaPgto(FormaPgto FormaPgto) {
        this.FormaPgto = FormaPgto;
    }

    public FormaPgto getFormaPgto() {
        return FormaPgto;
    }

    public void setItensContr(ItensContr ItensContr) {
        this.ItensContr = ItensContr;
    }

    public ItensContr getItensContr() {
        return ItensContr;
    }

    public Alunos getAluno() {
        return aluno;
    }

    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }

}
