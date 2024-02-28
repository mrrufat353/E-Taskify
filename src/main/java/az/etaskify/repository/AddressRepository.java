package az.etaskify.repository;

import az.etaskify.entity.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
