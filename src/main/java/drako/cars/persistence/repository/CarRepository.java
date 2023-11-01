package drako.cars.persistence.repository;

import drako.cars.domain.dto.CarDto;
import drako.cars.domain.repository.ICarRepository;
import drako.cars.persistence.entity.CarEntity;
import drako.cars.persistence.mapper.ICarMapper;
import drako.cars.persistence.repository.crud.ICarCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;

    private final ICarMapper iCarMapper;

    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDtoList(iCarCrudRepository.findAll());
    }

    @Override
    public List<CarDto> getCarsByCarBrandId(Integer idCarBrand) {
        return iCarMapper.toCarsDtoList(iCarCrudRepository.findAllByCarBrandId(idCarBrand));
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return iCarMapper.toCarsDtoList(iCarCrudRepository.findAllByPriceLessThanEqualOrderByPriceAsc(price));
    }

    @Override
    public Optional<CarDto> getCar(Integer id) {
        return iCarCrudRepository.findById(id).map(iCarMapper::toCarDto);
    }

    @Override
    public CarDto save(CarDto newCar) {
        CarEntity carEntity = iCarMapper.toCarEntity(newCar);
        return iCarMapper.toCarDto(iCarCrudRepository.save(carEntity));
    }

    @Override
    public void delete(Integer idCar) {
        iCarCrudRepository.deleteById(idCar);
    }
}
