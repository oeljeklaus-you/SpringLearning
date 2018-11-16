package cn.edu.hust.dao;

import cn.edu.hust.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
@Transactional
public class PersonJpaDao {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public void addPerson(Person person)
    {
        this.entityManagerFactory.createEntityManager().persist(person);
    }

    public Person getPerson(int id)
    {
        return entityManagerFactory.createEntityManager().find(Person.class,id);
    }
}
