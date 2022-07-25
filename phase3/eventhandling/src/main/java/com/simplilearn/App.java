package com.simplilearn;

import com.simplilearn.customevent.CustomEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        context.start();
        context.stop();

        CustomEventPublisher pub= (CustomEventPublisher) context.getBean("cep");
        pub.publish();
    }
}
