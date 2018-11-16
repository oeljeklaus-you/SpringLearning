package cn.edu.hust.config;

import cn.edu.hust.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    @Bean
    public JedisConnectionFactory jedisConnectionFactory()
    {
        JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory(new JedisPoolConfig());
        jedisConnectionFactory.setHostName("node1");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("root");
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String,Person> redisTemplate(JedisConnectionFactory jedisConnectionFactory)
    {
        RedisTemplate<String,Person> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }
}
