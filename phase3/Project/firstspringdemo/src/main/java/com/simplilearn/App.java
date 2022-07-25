package com.simplilearn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //normal Use wo spring
        /*HelloWorld h=new HelloWorld();
        h.print();*/

        Resource resource=new ClassPathResource("beans.xml");
        BeanFactory beanFactory=new XmlBeanFactory(resource);
        HelloWorld h= (HelloWorld) beanFactory.getBean("obj"); // we are not using new HelloWorld();
        h.print();

        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld= (HelloWorld) context.getBean("obj");
        helloWorld.print();

        Student student= (Student) context.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.getPassport().getPassportNo());

    }
}
