package com.zsq.demo1.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 以代码的方式实现DespactcherServlet的创建，规避web.xml中配置的方式，靠拢springboot
 */
public class MyWebApplicationInitializer /*implements WebApplicationInitializer*/ {
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        // Spring IOC 容器创建
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        // Spring 配置类
        ac.register(AppConfig.class);
        ac.refresh();

        // 创建DispatcherServlet 并存放容器中
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("*.do");
    }

}
