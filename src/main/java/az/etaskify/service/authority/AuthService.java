package az.etaskify.service.authority;

import az.etaskify.entity.authority.Authority;
import az.etaskify.entity.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthService {

        List<Authority> getAllAuthorities();

        Authority getAuthorityById(Long id);

        Authority createAuthority(Authority authority);

        Authority updateAuthority(Long id, Authority authority);

        void deleteAuthority(Long id);

        User findUser(String email);
    }

