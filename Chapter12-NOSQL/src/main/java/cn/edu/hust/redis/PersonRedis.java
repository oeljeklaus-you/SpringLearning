package cn.edu.hust.redis;

import cn.edu.hust.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRedis {
    @Autowired
    private RedisTemplate<String,Person> redisTemplate;

    public boolean savePerson2Redis(String key,Person person)
    {
        this.redisTemplate.opsForValue().set(key,person);
        return true;
    }
}
