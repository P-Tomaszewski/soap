package pattomaszewski.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

public class SoapConfig extends WsConfigurerAdapter {
    public static final String CAR_NAMESPACE = "http://sri4.pattomaszewski/cars";

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformSchemaLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "car")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema carSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CarPort");
        wsdl11Definition.setLocationUri("/ws/cars");
        wsdl11Definition.setTargetNamespace(CAR_NAMESPACE);
        wsdl11Definition.setSchema(carSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {return new SimpleXsdSchema(new ClassPathResource("cars.xsd"));
    }
}
