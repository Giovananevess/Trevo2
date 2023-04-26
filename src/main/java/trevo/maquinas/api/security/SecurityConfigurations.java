package trevo.maquinas.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    @Autowired
    SecurityFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                .requestMatchers( "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()

                .requestMatchers(HttpMethod.POST, "/user/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/user/register").permitAll()

                .requestMatchers(HttpMethod.GET, "/user/list").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "/user/delete/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "/user/update/**").hasRole("ADMINISTRADOR")

                .requestMatchers(HttpMethod.POST, "/product/register").hasAnyRole("ADMINISTRADOR", "COLABORADOR")
                .requestMatchers(HttpMethod.GET, "/product/list").hasAnyRole("ADMINISTRADOR", "COLABORADOR")
                .requestMatchers(HttpMethod.DELETE, "/product/delete/**").hasAnyRole("ADMINISTRADOR", "COLABORADOR")
                .requestMatchers(HttpMethod.PUT, "/product/update/**").hasAnyRole("ADMINISTRADOR", "COLABORADOR")

                .anyRequest().authenticated()
                .and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
