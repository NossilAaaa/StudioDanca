/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.studio.danca;

import projeto.studio.danca.dao.PersistenciaJPA;

/**
 *
 * @author aliss
 */
public class TestePersistenciaProduto {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistenciaProduto() {
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
         // criar meu obj Produto
         Produto p = new Produto();
         p.setDescricao("Computador");
//         p.setValor(Double.parseDouble("5000"));
         p.setValor(5000.0);
         
         // persistir objeto 
         jpa.persist(p);
         
         // buscar objeto persistido
         Produto persistidoProduto = (Produto)jpa.find(Produto.class, p.getId());
         
         // verificar se objeto persistido é igual ao criado
         
         Assert.assertEquals(p.getDescricao(), 
                 persistidoProduto.getDescricao());
         
         
         
     }
}
