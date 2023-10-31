package drako.cars.domain.service;

import drako.cars.domain.dto.CarDto;
import drako.cars.domain.service.usecase.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    @Override
    public List<CarDto> getAll() {
        return null;
    }

    @Override
    public List<CarDto> getCarsByCarBrandId(Integer idCar) {
        return null;
    }

    @Override
    public List<CarDto> getCarByPriceLessThan(Double price) {
        return null;
    }

    @Override
    public Optional<CarDto> getCar(Integer id) {
        return Optional.empty();
    }

    @Override
    public CarDto save(CarDto newCar) {
        return null;
    }

    @Override
    public boolean delete(Integer idCar) {
        return false;
    }
}
