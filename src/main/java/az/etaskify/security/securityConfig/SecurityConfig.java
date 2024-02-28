//package az.etaskify.security.securityConfig;
//
//import az.etaskify.security.filter.AuthFilterConfigureAdapter;
//import az.etaskify.security.securityService.CustomUserDetailService;
//import az.etaskify.security.securityService.TokenAuthService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableMethodSecurity
//public class SecurityConfig{
//
//    private final TokenAuthService tokenAuthService;
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//
//        //configurations
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.cors(AbstractHttpConfigurer::disable);
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        //authorizes
//        http.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/register", "/auth/login").permitAll());
//        http.authorizeHttpRequests(auth -> auth.requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll());
//        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//
//        http.apply(new AuthFilterConfigureAdapter(tokenAuthService));
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//            throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
