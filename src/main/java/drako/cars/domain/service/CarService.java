package drako.cars.domain.service;

import drako.cars.domain.dto.CarDto;
import drako.cars.domain.repository.ICarRepository;
import drako.cars.domain.usecase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService implements ICarUseCase {

    private final ICarRepository iCarRepository;

    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    @Override
    public List<CarDto> getCarsByCarBrandId(Integer idBrandCar) {
        return iCarRepository.getCarsByCarBrandId(idBrandCar);
    }

    @Override
    public List<CarDto> getCarByPriceLessThan(Double price) {
        return iCarRepository.getCarByPriceLessThan(price);
    }

    @Override
    public Optional<CarDto> getCar(Integer id) {
        return iCarRepository.getCar(id);
    }

    @Override
    public CarDto save(CarDto newCar) {
        return iCarRepository.save(newCar);
    }

    @Override
    public boolean delete(Integer idCar) {
        if (iCarRepository.getCar(idCar).isEmpty()) {
            return false;
        }
        iCarRepository.delete(idCar);
        return true;
    }
}
