package drako.cars.persistence.repository;

import drako.cars.domain.pojo.CarBrandDto;
import drako.cars.domain.repository.ICarBrandRepository;
import drako.cars.persistence.entity.CarBrandEntity;
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

    /**
     * Return all CarBrand
     *
     * @return list of CarBrand
     */
    @Override
    public List<CarBrandDto> getAll() {
        return iCarBrandMapper.toCarBrandsPojo(iCarBrandCrudRepository.findAll());
    }

    /**
     * Return a CarBrand by id
     *
     * @param id
     * @return CarBrand
     */
    @Override
    public Optional<CarBrandDto> getCarBrand(Integer id) {
        return iCarBrandCrudRepository.findById(id).map(iCarBrandMapper::toCarBrandPojo);
    }

    /**
     * Save a new CarBrand
     *
     * @param newCarBrand CarBrand to save
     * @return CarBrand created
     */
    @Override
    public CarBrandDto save(CarBrandDto newCarBrand) {
        CarBrandEntity carBrandEntity = iCarBrandMapper.toCarBrandEntity(newCarBrand);
        return iCarBrandMapper.toCarBrandPojo(iCarBrandCrudRepository.save(carBrandEntity));
    }

    /**
     * Delete a CarBrand
     *
     * @param idCarBrand CarBrand to delete
     */
    @Override
    public void delete(Integer idCarBrand) {
        iCarBrandCrudRepository.deleteById(idCarBrand);
    }
}
