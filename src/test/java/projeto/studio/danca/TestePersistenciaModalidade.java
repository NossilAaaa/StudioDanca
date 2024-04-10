/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.studio.danca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projeto.studio.danca.dao.PersistenciaJPA;
import projeto.studio.danca.model.Modalidades;

/**
 *
 * @author aliss
 */
public class TestePersistenciaModalidade {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistenciaModalidade() {
    }
    
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
     @Test
     public void testePersistenciaProduto() throws Exception {
         Modalidades m = new Modalidades();
         m.setDescricao("Modalidade: Street");
//         
       
         
         // persistir objeto 
         jpa.persist(m);
         
         // buscar objeto persistido
         Modalidades persistidoModalidade = (Modalidades)jpa.find(Modalidades.class, m.getId());
         
         // verificar se objeto persistido é igual ao criado
         
         
         
         
     }
}
