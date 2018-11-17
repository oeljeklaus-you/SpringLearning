package cn.edu.hust.service;

import cn.edu.hust.bean.Person;

import cn.edu.hust.dao.PersonDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl {
    @Autowired
    private PersonDaoImpl personDao;

    public Person findOneById(int id)
    {
        return this.personDao.findOneById(id);
    }

    public int insertPerson(Person person)
    {
        return this.personDao.insertPerson(person);
    }

}
