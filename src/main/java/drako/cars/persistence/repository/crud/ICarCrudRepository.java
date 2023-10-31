package drako.cars.persistence.repository.crud;

import drako.cars.domain.dto.CarDto;
import drako.cars.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllByCarBrandId(Integer id);

    List<CarEntity> findAllByPriceLessThan(Double price);

}
