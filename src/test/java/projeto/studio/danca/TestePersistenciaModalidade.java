package projeto.studio.danca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
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

public class TestePersistenciaModalidade {

    PersistenciaJPA jpa = new PersistenciaJPA();

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaContrato_Pagamento() throws Exception {
        // Criar e persistir Modalidades
        modalidades m = new modalidades();
        m.setDescricao("Dança da Chuva");
        jpa.persist(m);

        // Criar e persistir Pacotes
        Pacotes p = new Pacotes();
        p.setDescricao("Pacote Dança da Chuva");
        p.setModalidade(m);
        p.setValor(1500.0);
        jpa.persist(p);

        // Criar e persistir ItensContr
        ItensContr ic1 = new ItensContr();
        ic1.setPacote(p);
        jpa.persist(ic1);

        // Criar e persistir Alunos
        Alunos a = new Alunos();
        a.setEmail("teste@teste.com");
        a.setEndereco("Rua da Raiva");
        a.setTelefone("1111111111");
        a.setNome("Rony");
        a.setDataPgto(10);
        jpa.persist(a);

        // Criar e persistir Contratos
        Contratos contrato = new Contratos();
        contrato.setValorDesconto(100.0);
        contrato.setFormaPgto(FormaPgto.PIX); // Exemplo de enum FormaPgto
        contrato.setAluno(a);
        contrato.setItensContr(ic1);
        contrato.setDataInicio(Calendar.getInstance());
        jpa.persist(contrato);

        // Criar e persistir Pagamento
        Calendar c = Calendar.getInstance();
        c.set(2024, Calendar.MAY, 20);
        
        Pagamento p1 = new Pagamento();
        p1.setContratos(contrato);
        p1.setDataPgto(Calendar.getInstance());
        p1.setDataVcto(c);
        p1.setValor(1350.0);
        jpa.persist(p1);

        // Criar e persistir Professores
        Professores prof = new Professores();
        prof.setData_aniver(c);
        prof.setData_adm(c);
        prof.setEmail("teste2@text.com");
        prof.setEndereco("999543");
        prof.setTelefone("999999");
        prof.setNome("Augusto");

        List<modalidades> moda = new ArrayList<>();
        moda.add(m);
        prof.setmodalidade(moda);
        jpa.persist(prof);

        // Criar e persistir FolhaPgmt
        FolhaPgmt FP = new FolhaPgmt();
        FP.setData_pgto(c);
        FP.setValor_receber(1500.0);
        FP.setProfessor(prof);
        jpa.persist(FP);

        // Adicionar FolhaPgmt ao professor e atualizar o professor
        List<FolhaPgmt> pag = new ArrayList<>();
        pag.add(FP);
        prof.setF_pagamento(pag);
        jpa.persist(prof); // Atualizar o professor com a folha de pagamento
    }
}
