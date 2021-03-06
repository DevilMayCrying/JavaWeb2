package com.javaweb.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//new ClassPathXmlApplicationContext(xmlFilePath).getBean(beanName)
public class ApplicationContextHelper implements ApplicationContextAware { 
	
    private static ApplicationContext applicationContext;  
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {   
    	ApplicationContextHelper.applicationContext = applicationContext;    
    }  
        
    public static ApplicationContext getApplicationContext(){  
        return applicationContext;  
    }  
   
    public static Object getBean(String beanName) {    
        return applicationContext.getBean(beanName);    
    } 
    
}   