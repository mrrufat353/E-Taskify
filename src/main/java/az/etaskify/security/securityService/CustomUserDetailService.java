//package az.etaskify.security.securityService;
//
//import az.etaskify.entity.user.User;
//import az.etaskify.security.UserPrincipal;
//import az.etaskify.service.authority.AuthService;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//public class CustomUserDetailService implements UserDetailsService {
//
//    private final AuthService authService;
//
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Implement logic to load user details from your data source (e.g., database)
//        // You may use Spring Data JPA or any other method to fetch user details.
//
//        // Example: replace the following line with your actual logic
//        throw new UsernameNotFoundException("User not found with username: " + username);
//    }
//
//    @Lazy
//    public CustomUserDetailService(AuthService authService) {
//        this.authService = authService;
//    }
//
//    public UserDetails loadByUsername(String email) {
//        User user = authService.findUser(email);
//        return UserPrincipal.create(user);
//    }
//}