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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pacotes implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false, length = 120)
    private String descricao;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private Double valor;
    
    @ManyToOne
    @JoinColumn(name = "modalidades_id")
    private modalidades modalidade;

    public Pacotes() {
    }

    public Pacotes(Integer id, String descricao, Double valor, modalidades modalidade) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.modalidade = modalidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public modalidades getModalidade() {
        return modalidade;
    }

    public void setModalidade(modalidades modalidade) {
        this.modalidade = modalidade;
    }
    
    
    
    
}
