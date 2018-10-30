package cn.edu.hust.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * PropertySource注解的值是配置文件的位置
 */
@Component
@PropertySource("classpath:person.properties")
public class Person {

    @Autowired
    Environment environment;
    private String name=environment.getProperty("name");
    private int age=environment.getProperty("age",Integer.class);

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
