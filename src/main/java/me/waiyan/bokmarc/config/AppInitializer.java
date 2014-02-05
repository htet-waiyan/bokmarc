package me.waiyan.bokmarc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCtx) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(WebAppConfig.class);
		context.setServletContext(servletCtx);
		
		ServletRegistration.Dynamic dispatcher=servletCtx.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
	
	private AnnotationConfigWebApplicationContext getContext(){
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("me.waiyan.bokmarc.config");
		
		return context;
	}

}
