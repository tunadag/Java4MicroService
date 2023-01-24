package com.tunadag.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthMicroServiceSecurityConfig {

    @Bean
    protected JwtTokenFilter getJwtTokenFilter(){
        return new JwtTokenFilter();
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
        /**
         * _csrf kapatma ve açma işlemlerinde kullanılır. Sistemimizin güvende kalmasını sağlamak için kullanılır.
         */
        httpSecurity.csrf().disable();
        /**
         * Öncelikle gelen tüm isteklere doğrulama uygulayacağımızı bildiriyoruz.
         * ** antMatchers -> izin verilecek yada verilmeyecek endpoint lerin belirlendiği alan
         * ** anyRequest -> herhangi bir istek
         * ** authenticated -> oturum açmaya tabi tut, kimlik doğrulama yap
         */
        httpSecurity.authorizeRequests()
                .antMatchers("/v3/api-docs/**",
                        "/swagger-ui/**", "/v1/dev/auth/dologin",
                        "/v1/dev/auth/register").permitAll() // bu uzantılı isteklere izin ver, kimlik doğrulamaya tabi tutma
                .anyRequest().authenticated();

        /**
         * Bir filtre uygulanacak bunun nasıl yapılacağı ve hangi şekilde yapılacağının belirtilmesine ihtiyaç vardır.
         * Bunun parametrelerini yazacağız.
         * 1- Filter nesnesi
         * 2- Filter Type Class
         */
        httpSecurity.addFilterBefore(getJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        /**
         * Gelen isteeklere oturum açma zorunluluğu getirildikten sonra
         * bir Login page e yönlendirme yapmak gereklidir, bunun aktif edilmesi aşağıdaki şekilde olur. Ayrıca
         * kendinize ait bir Login page kullanmak isterseniz bu sayfanın uzantısını buraya girmeniz gereklidir.
         */
        httpSecurity.formLogin();
        return httpSecurity.build();
    }
}
