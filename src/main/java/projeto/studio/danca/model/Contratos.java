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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Contratos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false)
    private Calendar dataInicio;

    public Contratos() {
        
        dataInicio=Calendar.getInstance(); 
    }
    
   
    @Column(name = "ValorDesconto",columnDefinition = "decimal(12,2)")
    private Double valorDesconto;
    
    @Column(nullable = false,  name = "FormaPagamento")
    @Enumerated(EnumType.STRING)//usado para vincular o enum 
    private FormaPgto formaPgto;
    
   
   @OneToMany(mappedBy = "contratos", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<ItensContrato> itensCont= new ArrayList();
   
   private void adiciona_itens(ItensContrato obj){
                 itensCont.add(obj);
   }
    private void remove_itens(ItensContrato obj){
                 itensCont.remove(obj);
   }
    public Double getValor_desconto() {
        return valorDesconto;
    }

    public void setValor_desconto(Double valor_desconto) {
        this.valorDesconto = valorDesconto;
    }

    public FormaPgto getForma_pgto() {
        return formaPgto;
    }

    public void setForma_pgto(FormaPgto forma_pgto) {
        this.formaPgto = formaPgto;
    }
    
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
      public Calendar getData_inicio() {
        return dataInicio;
    }

    public void setData_inicio(Calendar data_inicio) {
        this.dataInicio = dataInicio;
    }

}
