package com.mont.rasmooplus.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    //responsável pela configuracao de autorizacao -> Acesso a URLs
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/subscription-type").permitAll()
        .antMatchers(HttpMethod.GET, "/subscription-type/*").permitAll().anyRequest().authenticated();
    }

    //responsável pela configuracao de autenticacao -> login e senha
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
    }

   //responsável pelo acesso de arquivos estáticos -> hmtl, css, js, imagens
    @Override
    public void configure(WebSecurity web) throws Exception {
        // TODO Auto-generated method stub
    }
}
