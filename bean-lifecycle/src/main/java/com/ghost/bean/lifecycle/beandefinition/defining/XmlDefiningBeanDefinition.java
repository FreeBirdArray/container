package com.ghost.bean.lifecycle.beandefinition.defining;

import com.ghost.bean.lifecycle.beandefinition.instantiation.BeanPostProcessorBeforeInitialization;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description   XML 方式 spring bean 元信息定义
 * @Date 2021/3/9 9:53
 * @Version 1.0
 */
public class XmlDefiningBeanDefinition {


    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostProcessorBeforeInitialization());
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        Resource resource = new ClassPathResource("/MATE-INF/dependency-lookup-context.xml");
        int i = xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        System.out.println("已加载spring bean 元信息个数："+i);
        System.out.println("use r:"+beanFactory.getBean("superUser"));
     //   System.out.println("user:" + beanFactory.getBean("user"));
    }
}
