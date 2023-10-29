package drako.cars.domain.repository;


import drako.cars.domain.pojo.CarBrandPojo;

import java.util.List;
import java.util.Optional;

public interface ICarBrandRepository {

    /**
     * @return List car brands
     */
    List<CarBrandPojo> getAll();

    /**
     * Return a CarBrand by id
     *
     * @param id
     * @return Option CarBrand found
     */
    Optional<CarBrandPojo> getCarBrand(Integer id);

    /**
     * Save new CarBrand
     *
     * @param newCarBrand CarBrand to save
     * @return CarBrand
     */
    CarBrandPojo save(CarBrandPojo newCarBrand);

    /**
     * Delete a CarBrand by id
     *
     * @param idCarBrand CarBrand to delete
     */
    void delete(Integer idCarBrand);

}
