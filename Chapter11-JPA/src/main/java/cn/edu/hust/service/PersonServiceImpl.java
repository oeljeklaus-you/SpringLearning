package cn.edu.hust.service;

import cn.edu.hust.bean.Person;
import cn.edu.hust.dao.IPersonRepository;
import cn.edu.hust.dao.PersonJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl {
    /**需要使用hibernate时去掉注解
    @Autowired
    private PersonHibernateDao personHibernateDao;**/
    @Autowired
    private PersonJpaDao personJpaDao;

    @Autowired
    private IPersonRepository iPersonRepository;

    public Person findOneById(int id)
    {
        return this.personJpaDao.getPerson(id);
    }

    public void insertPerson(Person person)
    {
        this.personJpaDao.addPerson(person);
    }


    public Person findOneByHibernate(int id)
    {
        /**
        return this.personHibernateDao.findOne(id);**/
        return this.personJpaDao.getPerson(id);
    }
}
