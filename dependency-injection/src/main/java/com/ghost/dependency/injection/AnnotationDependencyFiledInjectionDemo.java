package com.ghost.dependency.injection;

import com.ghost.commons.bean.User;
import com.ghost.commons.bean.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description
 * @Date 2021/2/20 16:07
 * @Version 1.0
 */
public class AnnotationDependencyFiledInjectionDemo {

    @Autowired
    private  UserHolder userHolder;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyFiledInjectionDemo.class);
        // 创建xmlBeanDefinitionReader 对象
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        // 设置文件位置
        String xmlResourcePath = "classpath:/MATE-INF/dependency-injection-context.xml";
        // 加载资源并生成BeanDefinition对象
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 启动应用上下文
        applicationContext.refresh();
        // 获取 AnnotationDependencyFiledInjectionDemo 对象
        AnnotationDependencyFiledInjectionDemo bean = applicationContext.getBean(AnnotationDependencyFiledInjectionDemo.class);
        // 获取注入的 User 对象
        UserHolder userHolder = bean.userHolder;
        System.out.println(userHolder);

    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }


}
