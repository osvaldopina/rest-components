package br.gov.bcb.rest.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableHypermediaSupport(type = { EnableHypermediaSupport.HypermediaType.HAL })
@EnableWebMvc
@EnableSpringDataWebSupport
public class Application extends WebMvcConfigurerAdapter {

//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer c) {
//        c.defaultContentType(MediaTypes.HAL_JSON);
//    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).
                favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(true).
                useJaf(false).
                defaultContentType(MediaTypes.HAL_JSON).
                mediaType("json", MediaTypes.HAL_JSON).
                mediaType("json", MediaType.APPLICATION_JSON);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


