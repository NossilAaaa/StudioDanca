
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.studio.danca.dao;

import projeto.studio.danca.model.modalidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import projeto.studio.danca.model.Professores;

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
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        EntityManager em = getEntityManager();
        return em.find(c, id);//encontra um determinado registro 
    }

    public void persist(Object o) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public void remover(Object o) throws Exception {
//        No método remover, antes de chamar remove, usamos merge se o objeto não estiver gerenciado.
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                o = em.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    /*public List<modalidades> getModalidades() {
        List<modalidades> modalidade = null;
        try {
            modalidade = entity.createQuery("SELECT m FROM modalidades m", modalidades.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao obter modalidades: " + e.getMessage());
        }
        return modalidade;
    }
     */
    public List<modalidades> getModalidades() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<modalidades> query
                    = em.createQuery("SELECT m FROM modalidades m", modalidades.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Professores> getProfessores() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Professores> query = 
                    em.createQuery("SELECT m FROM Professores m", 
                            Professores.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
