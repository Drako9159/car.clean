package drako.cars.persistence.repository;

import drako.cars.domain.pojo.CarBrandPojo;
import drako.cars.domain.repository.ICarBrandRepository;
import drako.cars.persistence.mapper.ICarBrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for CarBrand
 */
@Repository
@RequiredArgsConstructor // for create final attributes constructor
public class CarBrandRepository implements ICarBrandRepository {

    /**
     * CrudRepository CarBrand
     */
    private final ICarBrandCrudRepository iCarBrandCrudRepository;

    /**
     * Mapper CarBrand
     */
    private final ICarBrandMapper iCarBrandMapper;

    @Override
    public List<CarBrandPojo> getAll() {
        return iCarBrandMapper.toCarBrandsPojo(iCarBrandCrudRepository.findAll());
    }

    @Override
    public Optional<CarBrandPojo> getCarBrand(Integer id) {
        return iCarBrandCrudRepository.findById(id).map(iCarBrandMapper::toCarBrandPojo);
    }

    @Override
    public CarBrandPojo save(CarBrandPojo newCarBrand) {

        return null;
    }

    @Override
    public void delete(Integer idCarBrand) {

    }
}
