package org.example;

import org.example.config.Appconfig;
import org.example.scope.PrototypeBean;
import org.example.scope.SingletonBean;
import org.example.vehicle.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Create Spring IoC Container
        // Read the configuration class
        // Create and manage Spring beans
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

        //Retrieve Spring Beans from Spring IoC Container

        SingletonBean singletonBean = applicationContext.getBean(SingletonBean.class);
        SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = applicationContext.getBean(SingletonBean.class);

        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean.hashCode());

        PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);

        applicationContext.getBean("lazyLoader");
    }
}