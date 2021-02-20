package com.ghost.spring.bean.definition;

import com.ghost.spring.ioc.overview.dependency.lookup.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description  BeanDefinition创建示例
 * @Date 2021/2/7 17:58
 * @Version 1.0
 */
public class BeanDefinitionCreationDemo {


    public static void main(String[] args) {
        //通过 BeanDefinitionBuilder 创建 BeanDefinition 对象
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id",1L)
                .addPropertyValue("name","xiaomage");
        //获取BeanDefinition对象
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        //通过 AbstractBeanDefinition 以及派生类 构建 BeanDefinition 对象
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        //批量操作 bean 对象属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        //第一种方式设置bean对象属性
        propertyValues
                .add("id",1L)
                .add("name","xiaomage");

        //第二中方式设置 bean 对象属性
        propertyValues.addPropertyValue("id",1L);
        propertyValues.addPropertyValue("name","xiaomage");
        genericBeanDefinition.setPropertyValues(propertyValues);

    }


    public static  AbstractBeanDefinition getBeanDefinition(){
        //通过 BeanDefinitionBuilder 构建 BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //设置 Bean 属性
        beanDefinitionBuilder
                .addPropertyValue("id",1L)
                .addPropertyValue("name","xiaomage");
        //设置作用域
        //beanDefinitionBuilder.setScope();
        //设置是否懒加载
        //beanDefinitionBuilder.setLazyInit(true);
        return beanDefinitionBuilder.getBeanDefinition();
    }
}
