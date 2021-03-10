package com.ghost.bean.lifecycle.beandefinition.register;

import com.ghost.commons.bean.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description  spring bean 元信息解析
 * @Date 2021/3/9 10:51
 * @Version 1.0
 */
public class RegisterBeanDefinition {
    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置相关属性
         beanDefinitionBuilder.addPropertyValue("id", 5)
                              .addPropertyValue("name", "王二狗");
         // 获取 beanDefinition
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 将 beanDefinition 注册进容器中
        beanFactory.registerBeanDefinition("user",beanDefinition);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }



}
