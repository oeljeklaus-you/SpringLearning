package cn.edu.hust.dao;

import cn.edu.hust.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PersonDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person findOneById(int id)
    {
        String sql="select *from person where id=?";
        return this.jdbcTemplate.queryForObject(sql,new PersonMapper(),new Object[]{id});
    }

    public int insertPerson(Person person)
    {
        String sql="insert person(id,name,age) values(?,?,?)";
        return this.jdbcTemplate.update(sql,person.getId(),person.getName(),person.getAge());
    }

    class PersonMapper implements RowMapper<Person>
    {
        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
        }
    }
}
