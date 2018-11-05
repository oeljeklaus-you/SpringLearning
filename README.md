# Spring学习笔记
## 装配Bean
### 自动化装配
 在工程目录文件内"cn.edu.hust.autowriting"包内进行自动装配,学习到的知识有如下:
 
 @Autowired 注解可以放在任何想要的方法和属性中,表示注入,这与Spring的主要思想DI(依赖注入)有关
 
 @Component注解表示一个组件
 
 在XML配置中配置包的扫描,一般只是配置需要扫描的基础包,Spring可以扫描下面的子包了。
 
 具体的配置如下:
 ![Spring配置包扫描](img/Spring配置包扫描.png)
### JavaConfig配置
 在工程目录文件内"cn.edu.hust.javaConfig"包内进行自动装配,学习到的知识有如下:
 
 @ComponentScan 注解表示扫描的包，内部的属性有个basePackages,表示需要扫描的包,这是一个数组,可以扫描多个
 
 @Configuration 注解表示开发者可以像Java代码一项配置文件,但是切记不要和业务代码混合
 
 @Bean 注解来表示一个bean，一般方法的返回名字和bean的名字一样
### XML配置
 在使用XML配置之前,首先需要在XML配置文件的顶部声明多个XML模式文件,这些定义了配置Spring的XML元素。
 
 使用Spring至少要使用core内容,涉及的XML声明模式有beans、context;具体的配置如下:
 ![Spring XML模式声明](img/Spring XML模式声明.png)
 
 对于一般的beans配置情况,如果需要配置的类里面有例如setter等方法注入,具体配置如下:
 ![一般bean的配置](img/一般bean的配置.png)
 
 对于构造器的配置如下,这里可以有一个类在构造器中引用其他的bean,还有注入字面值以及集合的配置,具体情况如下:
 ![构造器配置](img/构造器配置.png)
 
### 总结
 根据应用场景的不同,各种配置的方法都有优缺点;有时候xml配置更加利于维护,有时候javaConfig的配置更加便利;有时候
 
 两者方法混合更加好,需要根据不同的应用场景选择。
 
## 高级装配
 在生产过程中,我们会发现如下的情况,很多在开发环境可以使用的配置在实际的情况下却不能适应,那么我们如何更好的
 
 在开发环境和生产环境中切换呢？这里我们使用prefile文件进行环境的切换。
 
### Java配置中切换
 这里需要使用@Profile注解进行切换,我们可以使用这个注解使用在不同的类上,Spring容器会根据不同的Profile来进行是否
 
 加载这个bean到Spring容器;当然在Spring3.1以后,我们可以将这个注解放在方法上面根据Profile的不同激活。
 
### XML配置文件中切换

 我们可以将整个配置文件进行prfile化,我们可以将所有的profile bean装配在整个配置文件中,这里我们需要进行如下的配置:
 ![profile装配的xml文件](img/profile装配的xml文件.png)

 当然,如果不方便的话,我们也可以使用的配置针对于同一个数据库连接管理池配置不同的bean,然后使用不同的profile激活
 ![不同的profile激活](img/不同的profile激活.png) 
 
#### 那么如何激活profile呢?
 可以设置两个属性来激活profile
 
   spring.profiles.active 该属性是用来确定激活那个profle的
   
   spring.profiles.default 如果上面的属性没有设置,那么采用默认的激活
   
 如果以上两个值均没有设置,那么将没有profile激活
 
 我们可以使用多个方式来设置两个值:
 
  1.作为DispatchServlet的初始化参数
  
  2.作为Web应用的上下文参数
  
  3.作为JNDI条目
  
  4.作为环境变量
  
  5.作为JVM的系统属性
  
  6.在集成测试类上,可以使用@ActiveProfiles来进行测试
  
 我们可以在测试的时候使用@ActiveProfiles来激活profile
 
### 条件化bean
 如果你需要指定某一个bean在满足某种条件下进行创建,你可以使用@Conditional注解来进行条件话bean。
 
 @Conditional注解有一个属性classes来指定但满足某些条件的时候才开始实例化bean。
 
 内部的原理如下,如果满足条件,matches方法将会返回true;反之,则为
 
 ![@Conditional注解内部原理.png](img/@Conditional注解内部原理.png)

### 处理自动装配的歧义
 在工程目录文件内"cn.edu.hust.cancelMulti"包内进行处理自动装配的歧义demo
 
 有时候我们可能遇到这样的情况,如果实现某个接口的类不只一个,那么有个类需要依赖这个类,当需要注入的时候就会产生歧义.
 
 如何解决整个歧义呢? 歧义产生的错误是org.springframework.beans.factory.NoUniqueBeanDefinitionException
 
 对于经典的xml配置,我们可以在选定的bean中设置primary=true;如果在注解的配置中,我们可以配置@Primary
 
#### 限定自动配置的bean
 上面的注解只是优先的选用哪一个bean,如果使用上面的注解或者在xml配置还是有歧义,我们应该怎么办呢?
 
 我们可以使用限定的注解来进行配置,具体配置如下
 ![限定符注解配置](img/限定符注解配置.png)
 
 在实际的运行情况下,尽管我们可以配置了为一个@Primary注解,但是运行处理的结果还是@Qualifier注解配置的类的结果
 
 但是这里的@Qualifier需要指定类的ID,一般来说,类的id是类的首字母小写的单词,但是这个注解与id的名字是紧密耦合的
 
 所以我们可以现在选定的类上加上@Qualifier自定义一个合适的名字在进行注入.
 
### bean的作用域
 bean的作用域一般是单例的，但是在某种情况下，使用同一个实例可能污染。基于以上考虑，Spring创建了不同的作用域
 
 单例:在整个应用中,Spring只创建一个实例
 
 原型:每次注入或者获取Sring应用上下文都会创建一个新的bean实例.
 
 会话:在Web应用中,都会给每个会话创建一个bean实例。
 
 请求:在web应用中,为每一次请求创建一个bean实例。
 
 使用注解可以利用@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)这样来显示的表示bean的作用域,也可以使用
 
 字面量来进行，但是为了避免出错最好使用定义的常量来表示。
 
#### 会话bean和请求的bean

 设想一下这样的应用场景,需要为每一个用户的每一个会话创建一个购物车，显然bean作用域为单例是不对的
 
 如果bean的作用域为原型也是不对的，因为每一次注入或者加载上下文都会产生一个购物车
 
 我们需要的是什么呢，我们需要的是一个会话一个购物车，所以这里的作用域类型是会话
 
 还有一种情况是什么呢？如果我们需要在这里将都购物车注入到单例的bean中，这时没有用户登陆，那么就没有实例

 这个时候，我们需要指定一个代理模式来代理我们需要的，所有我们可以使用proxyMode属性
              
 如果代理的是接口，这里是ScopedProxyMode.INTERFACES,如果是类那么是ScopedProxyMode.TARGET_CLASS。
 ![会话bean](img/会话bean.png)
 
 对于整体的代理流程,用下面这张图可以表示
 ![代理流程](img/代理流程.png)
 
 如果需要在xml中配置bean的作用域,需要说明的是如果目标值那个设置为true使用cglib代理，可以使用如下的配置
 ![xml配置bean作用域](img/xml配置bean作用域.png)
 
### 运行注入值
 在工程目录文件内"cn.edu.hust.property"包内进行运行市注入值
 
 在前面几节的内容中，使用了硬编码，在实际生产环境中肯定是不行的所以要使用可配置的文件。
 
 这里如果使用注解，可以使用@PropertySource和Environment来实现,具体情况如下
 ![PropertySource注解](img/PropertySource注解.png)
 
 如果使用的xml配置文件的方式,可以使用如下配置方式来解析:
 ![xml配置解析配置文件](img/xml配置解析配置文件.png)

## 面向切面的Spring
 在软件开发中散布于多出的功能成为横切关注点,例如安全功能、日志功能等。
### 什么是面向切面变编程
 切面提供了继承和委托的另一种可选方案，而且在很多应用场景下更清晰简洁。在使用切面编程时,我们仍然需要在一个地方
 
 定义通用的功能，但是可以通过声明的方式定义这个功能要以何种方式要在何处应用，而无需修改影响的类。横切关注点可以
 
 被模块化为特殊的类，这些类被称为切面。这样做有两个好处:1.现在每个关注点都集中于一个地方，而不是分散在多处代码中;
 
 2.服务模块更加简洁，因为它们只包含核心功能点的代码。
 
#### 定义AOP术语
 描述切面的常用术语有通知、切点和连接点。
 
 切面功能织入程序的过程如下:
 ![切面功能织入程序过程](img/切面功能织入程序过程.png)
 
 在AOP术语中,切面的工作被称为通知。Spring有5种类型的通知:
 
 1.前置通知:在目标方法调用之前调用通知功能。
 
 2.后置通知:在目标方法调用之后调用通知,此时并不关心方法的输出是什么。
 
 3.返回通知:在目标方法成功执行之后调用通知。
 
 4.异常通知:在目标方法抛出异常之后调用通知。
 
 5.环绕通知:通知包裹了被通知的方法,在被通知的方法调用之前和调用之后执行自定义的行为。
 
 连接点:应用可能有数以千计的时机应用通知。这些时机成为连接点。连接点是在应用执行过程中能够插入切面的一个点。
 
 这个点可以是调用方法、抛出异常、甚至是修改一个字段时。
 
 切点:切点的定义会通知所要织入的一个或者多个连接点。通常是明确的方法或者类,或者是利用正则表达式所匹配的类和方法名
 
 来指定这些切点。
 
 切面:通知和切点的结合。
 
 织入:把切面应用到目标对象并创建的代理对象的过程。切面在指定的连接点被织入到目标对象中。
 
 在目标对象生命周期有多个点可以织入;
 
 1.编译期:切面在目标类编译时被织入。AspectJ是用这种织入方法织入切面的。
 
 2.类加载期:切面在目标类加载到JVM时织入。这种方式需要特定的类加载器,他可以把目标类被引用之前增强该目标类的字节码
 
 AspectJ 5的加载时织入就支持以这种方式织入切面。
 
 3.运行期:切面在运行的某个时候被织入。一般情况下，在织入的时候，AOP容器会为目标对象创建一个代理对象。
#### Spring对AOP的支持
 Spring提供了4种类型的AOP的支持:
 
 1.基于经典的Spring AOP
 
 2.纯POJO切面
 
 3.@AspectJ注解驱动的切面
 
 4.注入式AspectJ切面(适用于Spring各种版本)
 
 Spring AOP是基于动态代理的，所以都是方法拦截。
 
 Spring在运行时通知对象
 
   通过在代理类中包裹切面,Spring运行期把切面织入到Spring管理的bean中。代理类封装了目标类，并拦截被通知方法
   
   的调用，再把调用转发给真正的目标bean。
   
 Spring 基于动态代理，所以Spring只支持方法连接点。
 
### 通过切面来选择连接点
 在Spring AOP中，要用AspectJ的切点表达式语言来定义切点。
 
 Spring是基于代理的，而某些切点表达式是与基于代理的AOP无关的。
 
 关于Spring基于AspectJ的切点表达式如下:
 ![AspctJ切点表达式](img/AspctJ切点表达式.png)
 
#### 编写切面
 1。首先定义一个接口
 '''
 
 public interface Watch {
     void watch();
 }
 
 '''
 
 2。编写切面
 ![切面的编写](img/切面的编写.png)
 
 3。编写目标类
 ![aop的目标类](img/aop的目标类.png)
 
 4。关于AspectJ注解来声明通知方法
 ![AspectJ注解来声明通知方法](img/AspectJ注解来声明通知方法.png)
 
 需要使用@EnableAspectJAutoProxy和在xml配置文件中启动aop，xml配置如下
 
 <aop:aspectj-autoproxy/>
 
#### 创建环绕通知
 环绕通知是最强大的通知类型。它能将你写的逻辑通知目标方法完全包装起来。

 创建环绕通知如下:
 ![创建环绕通知](img/创建环绕通知.png)
 
#### 处理通知中的参数
 以前处理的通知方法中，没有处理方法中有参数的情况；这里可以像以前一样定义，不过可以使用AspectJ的表达式来表示
 
 在前一小节中，我们只需要添加"&&args(形式参数)"。具体的情况如下
 ![处理通知中的参数](img/处理通知中的参数.png)
 
#### 通过注解添加新的功能
 利用被称为引用的AOP概念，切面可以为Spring bean添加方法。
 
 ![使用注解添加新的功能](img/使用注解添加新的功能.png)
 
 这里涉及@DeclareParents注解，可以利用Spring AOP的功能添加新的方法。
 
### 在XML中声明切面
 在切面类中，以前的通知方法或者类都是通过AspectJ注解来实现的，这里只需要移除这些注解在XML配置即可。
 
 首先是在XML配置aop切面配置文件如下
 ![aop xml配置](img/aop xml配置.png)
 
 对于环绕通知类似与传递参数与注解，这里我们仅仅需要修改配置文件即可。
 ![aop xml配置传递参数](img/aop xml配置传递参数.png)
 
## 构建Spring web应用程序
### Spring MVC起步
 Spring把请求在调度Servlet、处理器映射、控制器以及视图解析器之间移动；每一个Spring MVC中的组件都有特定
 
 的目的，并且它没有那么那么复杂。请求在SpringMVC的流程如下
 ![请求在SpringMVC的流程](img/请求在SpringMVC的流程.png)
 
 请求的第一站首先要经过Spring的DispatchServlet，与大多数Java的web一样，Spring MVC的所有请求
 
 都会经过一个前端控制器Servlet。前端控制器是常用Web应用程序模式，在这里一个单实例的servlet将请求委托给
 
 应用程序的其他组件来执行实际处理，在SpringMVC中，DispatchServlet就是前端控制器。
 
 DispatchServlet的任务是将请求发给Spring MVC的控制器，控制器是一个用于处理请求的Spring组件。由于
 
 控制器存在多个，首先要确定该请求交给哪一个控制器处理，这就首先要交给处理器映射器来进行请求的判断。
 
 处理器请求映射器根据请求携带的URL信息来进行决策。一旦决定由那个控制器来处理，DispatchServlet就直接交个
 
 这个控制器，然后处理完成后就会产生一些信息，这些信息需要返回给用户浏览器呈现给用户。这些信息称之为模型。
 
 控制器还需要做的一件是事情就是将模型数据打包，然后标出用于渲染的视图名，将这些信息发给DispatchServlet
 
 。DispatchServlet将会使用视图解析器来将逻辑视图来进行特定的视图实现，最后一步是视图的实现，进行视图渲染。
 
#### 搭建Spring MVC
 DispatchServlet是Spring MVC的核心，它负责将请求路由发送到其他组件中。
 
 DsipatchServlet这样的Servlet可以配置在web.xml中，这个文件放置在war包里面。
 
 这里使用Java方式将DispatchServlet配置在web.xml文件中。
 
 对于一般的项目配置都在web.xml配置中,这里只是记录web.xml的配置,web.xml配置如下
 ![web.xml配置](img/web.xml配置如下.png)
 
 Spring一般需要加载两个Spring应用上下文,首先是我们这里配置SpringMVC的应用上下文
 
 然后这里需要配置视图解析器,将SpringMVC和Spring beans配置分开配置
 ![视图解析器配置](img/视图解析器配置.png)
 
 对于一般的Spring Beans配置如下:
 ![Spring一般bean的配置](img/Spring一般配置.png)
 
### 编写一般的控制器
 编写一般额控制器，使用@Controller来声明控制器;在一般的方法中,使用@RequestMapping注解在方法中声明请求路径
 ![一般的Controller](img/一般的Controller.png)
 
 在这个控制器中,返回的值表示需要渲染的视图名称 DispatchServlet要求视图解析器将这个逻辑的视图转化为实际视图
 
 如果觉得控制器的请求路径较大可以在类级别上使用@RequestMapping窄化请求路径。
 
#### 数据模型传递到视图
 如果需要将参数传递到视图中，需要怎么解决呢?在上一节中,可以将数据放在Model中,然后在jsp中配置即可。
 ![Model传递到视图](img/Model传递到视图.png)
 传递到视图需要注意的是页面jsp中,需要与上图中的model的名字一致,然后在jsp中使用${person.name}取值
 
### 接收请求的参数
 
  
  
 