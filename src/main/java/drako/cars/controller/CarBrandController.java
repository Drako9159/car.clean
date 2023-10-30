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
    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id) {
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    /**
     * Create CarBrand
     *
     * @param carBrandPojo CarBrand to save
     * @return CarBrand created if correct json, or Bad Request if not correct json
     */
    @PostMapping
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo carBrandPojo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandService.save(carBrandPojo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Update CarBrand
     *
     * @param carBrandPojo CarBrand to update
     * @return CarBrand updated
     */
    @PutMapping
    public ResponseEntity<CarBrandPojo> update(@RequestBody CarBrandPojo carBrandPojo) {
        return ResponseEntity.of(iCarBrandService.update(carBrandPojo));
    }

    /**
     * Delete CarBrand
     *
     * @param id CarBrand id
     * @return status code for check
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.status(iCarBrandService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(null);
    }

}
