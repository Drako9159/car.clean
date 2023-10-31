package drako.cars.controller;

import drako.cars.domain.dto.CarDto;
import drako.cars.domain.usecase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cars")
public class CarController {

    private final ICarUseCase iCarUseCase;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iCarUseCase.getAll());
    }

    @GetMapping(path = "/car-brand/{idCarBrand}")
    public ResponseEntity<List<CarDto>> getCarsByCarBrand(@PathVariable Integer idCarBrand) {
        return ResponseEntity.ok(iCarUseCase.getCarsByCarBrandId(idCarBrand));
    }

    @GetMapping(path = "/price/{price}")
    public ResponseEntity<List<CarDto>> getCarsByPriceLessThan(@PathVariable Double price) {
        return ResponseEntity.ok(iCarUseCase.getCarsByPriceLessThan(price));
    }

    @GetMapping(path = "/{idCar}")
    public ResponseEntity<CarDto> getCar(@PathVariable Integer idCar) {
        return ResponseEntity.of(iCarUseCase.getCar(idCar));
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto carDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCarUseCase.save(carDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.status(iCarUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(null);
    }

}
