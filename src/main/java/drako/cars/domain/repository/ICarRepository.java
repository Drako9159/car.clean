package drako.cars.domain.repository;

import drako.cars.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {

    /**
     * @return List car
     */
    List<CarDto> getAll();

    /**
     * Return a List Car
     *
     * @param idCar
     * @return List Car by CarBrand
     */
    List<CarDto> getCarsByCarBrandId(Integer idCar);

    /**
     * Return a List Car
     *
     * @param price
     * @return List Car by LessThan
     */
    List<CarDto> getCarsByPriceLessThan(Double price);

    /**
     * Return a Car by id
     *
     * @param id
     * @return Option Car found
     */
    Optional<CarDto> getCar(Integer id);

    /**
     * Save new Car
     *
     * @param newCar Car to save
     * @return Car
     */
    CarDto save(CarDto newCar);

    /**
     * Delete a Car by id
     *
     * @param idCar Carto delete
     */
    void delete(Integer idCar);
}
