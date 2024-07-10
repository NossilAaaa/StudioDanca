/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.studio.danca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projeto.studio.danca.dao.PersistenciaJPA;
import projeto.studio.danca.model.Alunos;
import projeto.studio.danca.model.Contratos;
import projeto.studio.danca.model.FolhaPgmt;
import projeto.studio.danca.model.FormaPgto;
import projeto.studio.danca.model.ItensContr;
import projeto.studio.danca.model.Pacotes;
import projeto.studio.danca.model.Pagamento;
import projeto.studio.danca.model.Professores;
import projeto.studio.danca.model.modalidades;

/**
 *
 * @author aliss
 */
public class TestePersistenciaModalidade {

    PersistenciaJPA jpa = new PersistenciaJPA();

    @Before // o que fazer antes da persistencia
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void testePersistenciaProduto() throws Exception {
        modalidades m = new modalidades();
        m.setDescricao("Modalidade: Street");
//         

        // persistir objeto 
        jpa.persist(m);

        // buscar objeto persistido
        modalidades persistidoModalidade = (modalidades) jpa.find(modalidades.class, m.getId());

        // verificar se objeto persistido é igual ao criado
    }

    @Test
    public void testePersistenciaContrato_Pagamento() throws Exception {

        Pacotes p = new Pacotes();
        modalidades m = new modalidades();

        m.setDescricao("Dança da Chuva");

        p.setDescricao("Pacote Danca da Chuva");
        p.setModalidade(m);
        p.setValor(1500.0);

        jpa.persist(m);
        jpa.persist(p);

        ItensContr ic1 = new ItensContr();
        ic1.setPacote(p);

        jpa.persist(ic1);
        Calendar c = Calendar.getInstance();
//        
        Alunos a = new Alunos();

        a.setEmail("teste@teste.com");
        a.setEndereco("Rua da Raiva");
        a.setTelefone("1111111111");
        a.setNome("Rony");
        a.setDataPgto(10);

        jpa.persist(a);
//        
//
//        Contratos contrato = new Contratos();
//        
//       
//        contrato.setValorDesconto(100.0);
//        contrato.setFormaPgto(FormaPgto.PIX); // Exemplo de enum FormaPgt
//        contrato.setAluno(a);
//        contrato.setItensContr(ic1);
//        contrato.setDataInicio(Calendar.getInstance());
//
//        jpa.persist(contrato);
//        

//        Pagamento p1 = new Pagamento();
//        
//        c.set(2024, 4, 20);
//        
//        p1.setContratos(contrato);
//        p1.setDataPgto(Calendar.getInstance());
//        p1.setDataVcto(c);
//        p1.setValor(1350.0);
//        
//        jpa.persist(p1);
//       
//         List<modalidades> moda = new ArrayList<>();
//         moda.add(m);
//         
//         
//        FolhaPgmt FP = new FolhaPgmt();
//       
//        FP.setData_pgto(c);
//        FP.setValor_receber(1500.0);
//        List<FolhaPgmt> pag = new ArrayList<>();
//        pag.add(FP);
//        
        Professores prof = new Professores();
        prof.setData_aniver(c);

        prof.setData_adm(c);
        prof.setEmail("teste2@text.com");
        prof.setEndereco("999543");
        prof.setTelefone("999999");
//        
//        FP.setProfessor(prof);
        prof.setNome("Augusto");
//        prof.setmodalidade(moda);
//        
//        prof.setF_pagamento(pag);
//        
//        
        jpa.persist(prof);
//        
//    
//        jpa.persist(FP);
    }
}
