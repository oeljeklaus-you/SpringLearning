package cn.edu.hust.dao;

import cn.edu.hust.bean.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**@Repository**/
public class PersonHibernateDao {
    private SessionFactory sessionFactory;
    @Inject
    public PersonHibernateDao(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }

    private Session currentSession()
    {
        return sessionFactory.openSession();
    }

    public Person findOne(int id)
    {
        return (Person) currentSession().get(Person.class,id);
    }

    public List<Person> findList()
    {
        return currentSession().createCriteria(Person.class).list();
    }
}
