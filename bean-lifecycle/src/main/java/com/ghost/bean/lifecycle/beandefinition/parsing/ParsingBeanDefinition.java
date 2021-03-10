package com.ghost.bean.lifecycle.beandefinition.parsing;

import com.ghost.commons.bean.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.UtilNamespaceHandler;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description  spring bean 元信息解析
 * @Date 2021/3/9 10:51
 * @Version 1.0
 */
public class ParsingBeanDefinition {
    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
         beanDefinitionBuilder.addPropertyValue("id", 5)
                              .addPropertyValue("name", "王二狗");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
      //  ystem.out.println(beanFactory.getBean("user"));
        beanFactory.registerBeanDefinition("user",beanDefinition);
        System.out.println(beanFactory.getBean("user"));
    }



}
