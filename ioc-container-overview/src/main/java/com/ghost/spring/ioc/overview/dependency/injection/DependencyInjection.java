package com.ghost.spring.ioc.overview.dependency.injection;


import com.ghost.spring.ioc.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description
 * @Date 2021/2/2 11:03
 * @Version 1.0
 */
public class DependencyInjection {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/ioc-dependency-injection.xml");

        BeanFactory beanFactory1 = new ClassPathXmlApplicationContext("classpath:META-INF/ioc-dependency-injection.xml");
        //依赖来源一：用户自定义bean
        UserRepository userR = applicationContext.getBean("userRepository", UserRepository.class);
        //依赖来源二：依赖注入（內建依赖）
        BeanFactory beanFactory = userR.getBeanFactory();
        //依赖来源三：容器内建bean
        Environment environment = applicationContext.getBean(Environment.class);

        System.out.println(userR.getUsers());

        System.out.println(beanFactory1 == applicationContext);
        System.out.println(applicationContext);
        System.out.println(beanFactory);
    }
}
