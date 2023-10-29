package drako.cars.controller;

import drako.cars.domain.pojo.CarBrandPojo;
import drako.cars.domain.service.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for CarBrand
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/car-brands")
public class CarBrandController {

    /**
     * Service CarBrand
     */
    private final ICarBrandService iCarBrandService;

    /**
     * Return all CarBrands
     *
     * @return List ResponseEntity of CarBrands
     */
    @GetMapping
    public ResponseEntity<List<CarBrandPojo>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iCarBrandService.getAll());
    }

    /**
     * Return a CarBran by id
     *
     * @param id CarBrand id to delete
     * @return CarBrand ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id) {
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    /**
     * Create CarBrand
     *
     * @param carBrandPojo CarBrand to save
     * @return CarBrand created
     */
    @PostMapping
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo carBrandPojo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandService.save(carBrandPojo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        if (iCarBrandService.delete(id)) {
            return ResponseEntity.status(204).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }


}
