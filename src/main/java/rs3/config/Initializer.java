package rs3.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer implements WebApplicationInitializer {

    private static final String DISPATCHER_REST_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SOAP_SERVLET_NAME = "soap_dispatcher";

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebAppConfig.class, SoapConfig.class, SecurityConfig.class);

        servletContext.addListener(new ContextLoaderListener(ctx));

        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_REST_SERVLET_NAME,
                new DispatcherServlet(ctx));
        servlet.addMapping("/"); // todo Узнать почему если мапить "/*" возвращаемый тип "application/octet-stream"
        servlet.setLoadOnStartup(1);
        MessageDispatcherServlet servletSoap = new MessageDispatcherServlet(ctx);
        servletSoap.setTransformWsdlLocations(true);
        ServletRegistration.Dynamic servlet1 = servletContext.addServlet(DISPATCHER_SOAP_SERVLET_NAME,
                new MessageDispatcherServlet(ctx));
        servlet1.addMapping("/soap/*");
        servlet1.setLoadOnStartup(1);
    }
}