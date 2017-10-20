package servletshibernate;

import daohibernate.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import springdao.*;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.transaction.Transactional;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

/**
 * Created by k.kotov on 16.10.2017.
 */
@WebListener
@Transactional
public class SpringWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationContext.class);


       // Create the 'root' Spring application context


       // Manage the lifecycle of the root application context
      servletContext.addListener(new ContextLoaderListener(appContext));

       // Create the dispatcher servlet's Spring application context


       // Register and map the dispatcher servlet



        //ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
          //     new DispatcherServlet(appContext));
        //dispatcher.setLoadOnStartup(1);
        //dispatcher.addMapping("/");






        // Filter.
        //FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);

        //fr.setInitParameter("encoding", "UTF-8");
        //fr.setInitParameter("forceEncoding", "true");
        //fr.addMappingForUrlPatterns(null, true, "/*");
    }

}
