package com.ghost.spring.ioc.overview.dependency.lookup;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description
 * @Date 2021/2/1 16:56
 * @Version 1.0
 */
public class DependencyLookUp {


    public static void main(String[] args) {
        //加载配置文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext( "classpath:META-INF/ioc-dependency-look-up.xml");
        //通过name进行依赖查找
        dependencyLookUpByName(beanFactory);
        //通过type进行依赖查找
        dependencyLookUpByType(beanFactory,User.class);
        //延时依赖查找
        dependencyLookUpByNameDelay(beanFactory);

    }

    private static void dependencyLookUpByNameDelay(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找："+user);
    }

    public  static void  dependencyLookUpByName(BeanFactory beanFactory){
         User user = (User) beanFactory.getBean("user");
         System.out.println("通过名字依赖查找："+user);
     }

    private static  void dependencyLookUpByType(BeanFactory beanFactory, Class<User> userClass) {
        User bean = beanFactory.getBean(userClass);
        System.out.println("通过类型依赖查找："+bean);
    }








}
