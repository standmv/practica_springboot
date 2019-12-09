package com.demoyageek.practica_springboot.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    // Opción JPA
    @Qualifier("usuarioServices")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Clase para encriptar contraseña
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        // Configuración JPA.
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Marcando las reglas para permitir unicamente los usuarios
        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/webjars/**").permitAll() // permitiendo llamadas a esas urls.
                .antMatchers("/dbconsole/**").permitAll().antMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/index/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/usuarios/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/**").fullyAuthenticated()
                .anyRequest().authenticated() // cualquier llamada debe ser validada
                .and().formLogin().loginPage("/login") // indicando la ruta que estaremos utilizando.
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error") // en caso de fallar puedo indicar otra pagina.
                .permitAll().and().logout().permitAll();

        // deshabilitando las seguridad contra los frame internos.
        // Necesario para H2.
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}

