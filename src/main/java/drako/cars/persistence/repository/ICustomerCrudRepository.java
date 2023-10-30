package drako.cars.persistence.repository;

import drako.cars.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {

    Optional<CustomerEntity> findByEmail(String email);

}
