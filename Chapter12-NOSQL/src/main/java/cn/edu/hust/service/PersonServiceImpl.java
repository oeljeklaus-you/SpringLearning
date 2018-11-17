package cn.edu.hust.service;

import cn.edu.hust.bean.Person;
import cn.edu.hust.dao.PersonHibernateDao;
import cn.edu.hust.redis.PersonRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl {
    @Autowired(required = false)
    private PersonHibernateDao personHibernateDao;

    @Autowired
    private PersonRedis personRedis;
    public Person findOneById(int id)
    {
        return this.personHibernateDao.findOne(id);
    }

    public void insertPerson(Person person)
    {
        this.personHibernateDao.addPerson(person);
    }


    public Person findOneByHibernate(int id)
    {
        Person person=personHibernateDao.findOne(id);
        personRedis.savePerson2Redis(person.getName(),person);
        return person;
    }
}
