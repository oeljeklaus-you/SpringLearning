package cn.edu.hust.dao;

import cn.edu.hust.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person,Integer>,CountNum {
    Person findByName(String name);

}
