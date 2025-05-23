package jpa;
/*
    JpaRepository
    - Jpa CRUD를 간편하게 처리하기 위한 유틸 클래스
 */
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaRepository<T,ID> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-unit");;
    private EntityManager em;
    private Class<T> entityClass;

    public JpaRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    //save
    public T save(T entity) {
        em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity); // 엔티티 저장
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return entity;
    }

    //find
    public T findByID(ID id) {
        em = emf.createEntityManager();
        return em.find(entityClass, id);
    }

    //findALL
    public List<T> findALL() {
        em = emf.createEntityManager();
        try{
            String sql = "select e from "+entityClass.getSimpleName()+" e";
            List<T> list = em.createQuery(sql).getResultList();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
        return null;
    }

    //update
    //delete

}
