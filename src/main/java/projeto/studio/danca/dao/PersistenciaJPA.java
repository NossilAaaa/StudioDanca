
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.studio.danca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aliss
 */
public class PersistenciaJPA implements InterfacePersisttencia {

   
    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("br.edu.ifsul.bcc.too.avaliacao.segundaetapa.semestre_2023_2.modelo_projeto.studio.danca_jar_1.0-SNAPSHOTPU");
        entity = factory.createEntityManager();
    }
    
    
    
    
    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    @Override
    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
    }

   
}
