package drako.cars.domain.repository;


import drako.cars.domain.dto.CarBrandDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface for repository CarBrand
 */
public interface ICarBrandRepository {

    /**
     * @return List car brands
     */
    List<CarBrandDto> getAll();

    /**
     * Return a CarBrand by id
     *
     * @param id
     * @return Option CarBrand found
     */
    Optional<CarBrandDto> getCarBrand(Integer id);

    /**
     * Save new CarBrand
     *
     * @param newCarBrand CarBrand to save
     * @return CarBrand
     */
    CarBrandDto save(CarBrandDto newCarBrand);

    /**
     * Delete a CarBrand by id
     *
     * @param idCarBrand CarBrand to delete
     */
    void delete(Integer idCarBrand);

}
