/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.studio.danca.model;

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

/**
 *
 * @author 20212PF.CC0020
 */
@Entity
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, name = "dataVcto")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataVcto;

    @Column(name = "Valor", precision = 10, scale = 2)
    private Double valor;

    @Column(name = "Data_Pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPgto;

    @Column(name = "Valor_Pagamento", columnDefinition = "decimal(12,2)")
    private Double valorPgto;

    @ManyToOne
    @JoinColumn(name = "contratos", nullable = false)
    private Contratos contratos;

    public Contratos getContratos() {
        return contratos;
    }

    public void setContratos(Contratos contratos) {
        this.contratos = contratos;
    }
        /*
    public void GerarPagamento(Integer mes_ref){
       if (mes_ref <=dataVcto.get(Calendar.DAY_OF_MONTH)){
            setDataPgto(Calendar.getInstance());
       } else {
             setDataPgto(null);
       }
   }  */   

    public Integer getId(Integer id){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataVcto() {
        return dataVcto;
    }

    public void setDataVcto(Calendar dataVcto) {
        this.dataVcto = dataVcto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Calendar dataPgto) {
        this.dataPgto = dataPgto;
    }

    public Double getValorPgto() {
        return valorPgto;
    }

    public void setValorPgto(Double valorPgto) {
        this.valorPgto = valorPgto;
    }

}
