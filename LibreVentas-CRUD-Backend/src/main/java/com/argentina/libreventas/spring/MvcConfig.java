package com.argentina.libreventas.spring;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig extends Object implements WebMvcConfigurer {
        
    public MvcConfig() {
        super();

    }

    @Bean
    WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return (factory) -> factory.setRegisterDefaultServlet(true);
    }
/** acá ¿hay que ir? agregando las URL de cada sección del CRUD, incluso las redirecciones **/
    
    @Override
    public void addViewControllers(final ViewControllerRegistry registro) {
        registro.addViewController("/listaproductos.html");
        registro.addViewController("/agregarproducto.html");
        registro.addViewController("/agregarp");
        registro.addRedirectViewController("/", "/listaproductos.html");
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registro) {
        registro.addResourceHandler(
                "/img/**",
                "/js/**",
                "/css/**"
        ).addResourceLocations(
                "classpath:/static/img/",
                "classpath:/static/js/",
                "classpath:/static/css/"
        );

    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer config) {
        config.enable();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registro) {

        final LocaleChangeInterceptor interceptor
                = new LocaleChangeInterceptor();
        registro.addInterceptor(interceptor);

    }

}
