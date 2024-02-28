package az.etaskify.repository;

import az.etaskify.entity.authority.Authority;
import az.etaskify.entity.authority.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByAuthority(UserAuthority userAuthority);


}
