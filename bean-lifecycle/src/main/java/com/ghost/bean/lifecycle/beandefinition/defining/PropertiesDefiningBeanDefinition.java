package com.ghost.bean.lifecycle.beandefinition.defining;

import com.ghost.commons.bean.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description  properties 方式 spring bean 元信息定义
 * @Date 2021/3/9 10:26
 * @Version 1.0
 */
public class PropertiesDefiningBeanDefinition {


    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        ClassPathResource resource = new ClassPathResource("/MATE-INF/user.properties");
        int i = propertiesBeanDefinitionReader.loadBeanDefinitions(resource);
        System.out.println("已加载spring bean 元信息个数：" +i);
        System.out.println(beanFactory.getBean("user",User.class));

    }
}
