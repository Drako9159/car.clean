package drako.cars.persistence.repository.crud;

import drako.cars.persistence.entity.CarBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICarBrandCrudRepository extends JpaRepository<CarBrandEntity, Integer> {
}
