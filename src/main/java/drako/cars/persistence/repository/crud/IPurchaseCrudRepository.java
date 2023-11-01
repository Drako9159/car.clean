package drako.cars.persistence.repository.crud;

import drako.cars.persistence.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPurchaseCrudRepository extends JpaRepository<PurchaseEntity, Integer> {

    List<PurchaseEntity> findAllByCardIdCustomer(String id);


}
