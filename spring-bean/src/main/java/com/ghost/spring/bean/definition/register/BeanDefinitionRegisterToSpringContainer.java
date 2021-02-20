package com.ghost.spring.bean.definition.register;

import com.ghost.spring.bean.definition.BeanDefinitionCreationDemo;
import com.ghost.spring.ioc.overview.dependency.lookup.User;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description  将 BeanDefinition 对象加载到 spring container 示例
 * @Date 2021/2/7 18:49
 * @Version 1.0
 */
public class BeanDefinitionRegisterToSpringContainer {


    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDefinitionRegisterToSpringContainer.class);
        // 通过命名方式将对象注册到 container
        registerBeanDefinition(applicationContext,"测试");
        // 未命名方式将对象注册到 container
        registerBeanDefinition(applicationContext);
        // 启动应用上下文
        applicationContext.refresh();
        // 获取bean对象
        applicationContext.getBeansOfType(User.class);
        System.out.println(applicationContext.getBeansOfType(User.class));
        // 关闭应用上下文
        applicationContext.close();




    }

    /**
     * 命名方式注册 BeanDefinition
     * @param beanName
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry ,String beanName){

        if (StringUtils.hasText(beanName)) {
            //通过 BeanDefinitionRegister 将 Bean 对象注册到 container
            beanDefinitionRegistry.registerBeanDefinition(beanName,BeanDefinitionCreationDemo.getBeanDefinition());
        }else {
            // 通过 BeanDefinitionReaderUtils#registerWithGeneratedName 将 Bean 注册到 container
            BeanDefinitionReaderUtils.registerWithGeneratedName(BeanDefinitionCreationDemo.getBeanDefinition() ,beanDefinitionRegistry);
        }
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry, null);
    }
}
