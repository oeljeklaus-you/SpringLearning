package cn.edu.hust.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * 假设有这样的需求，需要为每一个用户的每一个会话创建一个购物车，显然bean作用域为单例是不对的
 * 如果bean的作用域为原型也是不对的，因为每一次注入或者加载上下文都会产生一个购物车
 * 我们需要的是什么呢，我们需要的是一个会话一个购物车，所以这里的作用域类型是会话
 * 还有一种情况是什么呢？如果我们需要在这里将都购物车注入到单例的bean中，这时没有用户登陆，那么就没有实例
 * 这个时候，我们需要指定一个代理模式来代理我们需要的，所有我们可以使用proxyMode属性
 * 如果代理的是接口，这里是ScopedProxyMode.INTERFACES,如果是类那么是ScopedProxyMode.TARGET_CLASS
 */
@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

}
