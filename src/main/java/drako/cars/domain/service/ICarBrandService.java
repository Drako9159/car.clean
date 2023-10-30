package drako.cars.domain.service;

import drako.cars.domain.pojo.CarBrandDto;

import java.util.List;
import java.util.Optional;

public interface ICarBrandService {
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
     * @return CarBrand created
     */
    CarBrandDto save(CarBrandDto newCarBrand);

    /**
     * Update a CarBrand
     *
     * @param updateCarBrand CarBrand to delete
     * @return CarBrand updated
     */
    Optional<CarBrandDto> update(CarBrandDto updateCarBrand);

    /**
     * Delete a CarBrand by id
     *
     * @param idCarBrand CarBrand to delete
     */
    boolean delete(Integer idCarBrand);

}
