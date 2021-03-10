package com.ghost.bean.lifecycle.beandefinition.instantiation;

import com.ghost.commons.bean.SuperUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description
 * @Date 2021/3/10 9:23
 * @Version 1.0
 */
public class BeanPostProcessorBeforeInitialization extends InstantiationAwareBeanPostProcessorAdapter {

    // 重写该方法，在spring bean 实例化之前进行处理
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof SuperUser && "superUser".equals(beanName)) {
            System.out.println("在 SuperUser 对象实力化之前对该对象进行处理");
              return new SuperUser();
        }
        return bean;
    }

    // 重写该方法，在 spring bean 实例化之后对 bean 进行相关得处理
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof SuperUser && "superUser".equals(beanName)) {
            System.out.println("在 SuperUser 对象实力化之后对该对象进行处理");
            ((SuperUser) bean).setAddress("HANGZHOU");
            ((SuperUser) bean).setName("WANGWU");
            return bean;
        }
        return bean;
    }

}
