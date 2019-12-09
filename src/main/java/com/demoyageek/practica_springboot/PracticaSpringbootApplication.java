package com.demoyageek.practica_springboot;

import com.demoyageek.practica_springboot.Services.UsuarioServices;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.demoyageek")
public class PracticaSpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(PracticaSpringbootApplication.class, args);


        UsuarioServices usuarioServices;
        try {
            usuarioServices = (UsuarioServices) applicationContext.getBean("usuarioServices");
            usuarioServices.crearAdmin();

        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

}
