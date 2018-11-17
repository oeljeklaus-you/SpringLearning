package cn.edu.hust.config;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching //使用该注解开启缓存
public class CachingConfig {
    //声明缓存管理器,这是以注解的方式声明缓存管理器
    //会创建一个切面并触发spring缓存注解的切点,根据使用的注解以及缓存的状态,这个切面会从缓存中获取数据
    //将数据添加到缓存之中或从缓存中移除某个值
    /**
    @Bean
    public CacheManager cacheManager()
    {
        return new ConcurrentMapCacheManager();
    }**/

    //这里使用EhCache,配置EhCacheCacheManager
    @Bean
    public EhCacheCacheManager cacheManager(CacheManager cm)
    {
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache()
    {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean=new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("classpah:cache/ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }
}
