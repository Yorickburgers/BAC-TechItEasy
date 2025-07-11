package nl.novi.bachwtechiteasy.config;

import nl.novi.bachwtechiteasy.filter.JwtRequestFilter;
import nl.novi.bachwtechiteasy.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        var auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder);
        auth.setUserDetailsService(customUserDetailsService);
        return new ProviderManager(auth);
    }

    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(basic -> basic.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/ci-modules").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/ci-modules").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/ci-modules").hasRole("ADMIN")
                                .requestMatchers("/ci-modules").authenticated()
                                .requestMatchers(HttpMethod.POST,"/wall-brackets").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/wall-brackets").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/wall-brackets").hasRole("ADMIN")
                                .requestMatchers("/wall-brackets").authenticated()
                                .requestMatchers(HttpMethod.POST,"/remotes").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/remotes").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/remotes").hasRole("ADMIN")
                                .requestMatchers("/remotes").authenticated()
                                .requestMatchers(HttpMethod.POST,"/televisions").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/televisions").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/televisions").hasRole("ADMIN")
                                .requestMatchers("/televisions").authenticated()
                                .requestMatchers("/authenticated").authenticated()
                                .requestMatchers("/authenticate").permitAll()
                                .anyRequest().denyAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
