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
 
