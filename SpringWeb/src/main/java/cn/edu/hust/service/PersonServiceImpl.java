package cn.edu.hust.service;

import cn.edu.hust.bean.Person;
import cn.edu.hust.dao.IPersonRepository;
import cn.edu.hust.dao.PersonDaoImpl;
import cn.edu.hust.dao.PersonHibernateDao;
import cn.edu.hust.dao.PersonJpaDao;
import cn.edu.hust.redis.PersonRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.registry.infomodel.PersonName;

@Service
public class PersonServiceImpl {
    @Autowired
    private PersonDaoImpl personDao;
    /**需要使用hibernate时去掉注解
    @Autowired
    private PersonHibernateDao personHibernateDao;**/
    @Autowired
    private PersonJpaDao personJpaDao;

    @Autowired
    private PersonRedis personRedis;

    @Autowired
    private IPersonRepository iPersonRepository;

    public Person findOneById(int id)
    {
        return this.personDao.findOneById(id);
    }

    public int insertPerson(Person person)
    {
        return this.personDao.insertPerson(person);
    }


    public Person findOneByHibernate(int id)
    {
        /**
        return this.personHibernateDao.findOne(id);**/
        /**return this.personJpaDao.getPerson(id);**/
        Person person=personDao.findOneById(id);
        personRedis.savePerson2Redis(person.getName(),person);
        return person;
    }
}
