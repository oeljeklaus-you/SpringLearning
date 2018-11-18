package cn.edu.hust.config;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


import java.util.ArrayList;
import java.util.List;

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

    //这里使用EhCache,配置EhCacheCacheManager，Spring的EhCacheCacheManager需要注入Ehcache的CacheManager实例
    @Bean
    public EhCacheCacheManager cacheManager(net.sf.ehcache.CacheManager cm)
    {
        return new EhCacheCacheManager(cm);
    }

    //配置EhCacheManagerFactoryBean用于创建Ehcache的CacheManager实例
    @Bean
    public EhCacheManagerFactoryBean ehcache()
    {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean=new EhCacheManagerFactoryBean();
        //这里需要配置ehcache的xml文件在哪里
        ehCacheManagerFactoryBean.setConfigLocation(
                new ClassPathResource("classpah:cache/ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }


    /**
    //组合多个CacheManager
    @Bean
    public CacheManager cacheManger(net.sf.ehcache.CacheManager cm,javax.cache.CacheManager jcm)
    {
        CompositeCacheManager compositeCacheManager=new CompositeCacheManager();
        List<CacheManager> managerList=new ArrayList<CacheManager>();
        managerList.add(new JCacheCacheManager((jcm)));
        managerList.add(new EhCacheCacheManager(cm));
        compositeCacheManager.setCacheManagers(managerList);
        return compositeCacheManager;
    }**/
}
