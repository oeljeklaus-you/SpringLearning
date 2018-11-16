package cn.edu.hust.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

public class IPersonRepositoryImpl {
    @PersistenceContext
    private EntityManager em;

    public int countPersonNum()
    {
        String sql="update person set age = "+25+" where id =1";
        return em.createQuery(sql).executeUpdate();
    }
}
